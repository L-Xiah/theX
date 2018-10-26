package fv.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import fv.model.CompanyTheAttachment;
import fv.vo.Result;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * 上传、下载文件--Xiah20181023
 * 注意：文件上传的js中设置-〉"theType"、"theId";
 */
public class TheAttachmentLoad {


    private String theAttachPathStr ;//文件存档路径--"root" + File.separator + "source" + File.separator + "companyTheAttach"
    private String theAttachTempPathStr ;//temp文件夹--使用temp路径用于临时*.zip下载--"source" + File.separator + "companyTheAttachTemp"
    private String theTableType ;//附件大类--"package"

    public TheAttachmentLoad(String theAttachPathStr, String theAttachTempPathStr, String theTableType) {
        this.theAttachPathStr = theAttachPathStr;
        this.theAttachTempPathStr = theAttachTempPathStr;
        this.theTableType = theTableType;
    }



    private String theRealPath = "";//实际文档存储路径
    private String theTempPath = "";//temp存储路径(供下载)
    private String tempDelPath = "";//不删除自身temp文件夹



    public String getTheRealPath(HttpServletRequest request, boolean isReal) {

        if (theRealPath.isEmpty()) {
            theTempPath = request.getSession().getServletContext().getRealPath(File.separator);
            theRealPath = new File(theTempPath).getParentFile()+ File.separator;
            theTempPath = theTempPath + File.separator;
        }
        if (isReal) {
            return theRealPath;
        } else {
            return theTempPath;
        }


    }

    /**
     * 上传附件
     * @param request HttpServletRequest
     * @param userId String
     * @return String
     */
    public String fileupload(HttpServletRequest request, String userId) {
        JSONObject result = new JSONObject();
        result.put("success", false);
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        // 文件路径处理
        String savePath = getTheRealPath(request, true) + theAttachPathStr;
        File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {//判断上传文件的保存目录是否存在
            if (file.mkdirs()) {
                System.out.println(savePath + "目录不存在，需要创建"); //创建目录
            }
        }
        String message = "";//消息提示
        String theType = "theType";
        String theId = "theId";
        try {
            //使用Apache文件上传组件处理文件上传步骤：
            DiskFileItemFactory factory = new DiskFileItemFactory();//1、创建一个DiskFileItemFactory工厂
            ServletFileUpload upload = new ServletFileUpload(factory);//2、创建一个文件上传解析器
            upload.setHeaderEncoding("UTF-8");//解决上传文件名的中文乱码
            if (!ServletFileUpload.isMultipartContent(request)) { //3、判断提交上来的数据是否是上传表单的数据
                System.out.println("没有文件上传");//按照传统方式获取数据
                return result.toString();
            }
            List<FileItem> list = upload.parseRequest(request);//4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            for (FileItem item : list) {
                if (item.isFormField()) {//如果fileitem中封装的是普通输入项的数据//--获取theType\theId
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");//解决普通输入项的数据的中文乱码问题System.out.println(name + "=" + value);//value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    if (name.equals(theType)) {
                        theType = value;
                    } else {
                        if (name.equals(theId)) {
                            theId = value;
                        }
                    }
                }
            }
            if (theType.equals("theType") || theId.equals("theId")) {//未传入参数
                return result.toString();
            }

            for (FileItem item : list) {
                if (item.isFormField()) {
                    continue; //如果fileitem中封装的是普通输入项的数据
                }
                String filename = item.getName();//得到上传的文件名称，//如果fileitem中封装的是上传文件
                filename = filename.replace(" ", "");
                if ( filename.trim().equals("")) {
                    continue;
                }
                //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                filename = filename.substring(filename.lastIndexOf(File.separator) + 1);//注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                String newFilename = System.currentTimeMillis() + "-" + filename;

                if (theTransferTo(item, savePath + File.separator + newFilename)) {
                    CompanyTheAttachment theAttachment = new CompanyTheAttachment();

                    theAttachment.setAttachmentType(theTableType);//attachmentType和dataTableType互换
                    theAttachment.setDataTableType(theType);
                    theAttachment.setAttachmentName(newFilename);
                    theAttachment.setDataTableId(theId);
                    theAttachment.setCreatedBy(userId);
                    message = "文件上传成功！";
                    result.put("success", true);
                    result.put("id", theAttachment.getId());
                    result.put("dataTableId", theAttachment.getDataTableId());
                    result.put("dataTableType", theAttachment.getDataTableType());
                    result.put("attachmentName", theAttachment.getAttachmentName());
                    result.put("attachmentType", theAttachment.getAttachmentType());
                    result.put("createdByName", theAttachment.getCreatedByName());
                    result.put("creationTime", theAttachment.getCreationTime());
                    result.put("attachmentTypeName", theAttachment.getAttachmentTypeName());

                } else {
                    message = "文件上传失败！--";
                }
            }
        } catch (Exception e) {
            message = "文件上传失败！";
            e.printStackTrace();
        }
        result.put("message", message);
        return result.toString();
    }


    /**
     * 下载文件（多个文件，压缩在一起）
     * 单个文件直接下载(txt\pdf格式会在浏览器中直接打开)
     * @param filename //
     * @param request  //
     * @return result
     */
    public Result downloadFile(String filename, HttpServletRequest request) {
        Result result = new Result();
        List<String> fileAttachName = JSON.parseArray(filename,String.class);
        com.alibaba.fastjson.JSONArray filenames = JSON.parseArray(filename);
        String rootPath = getTheRealPath(request, true);// 文件路径处理
        String path = rootPath + theAttachPathStr + File.separator;
        String zipFileName;
        ArrayList<File> fs = new ArrayList<>();
        try {
//            List<String> fileAttachName = JSONArray.toC;
//            List<String> fileAttachName = (List<String>) filenames;
            for (String fileName : fileAttachName) {// 要下载的文件名
                String targetpath = path + File.separator + fileName;
                File f = new File(targetpath);
                fs.add(f);
            }

            zipFileName = "temp" + System.currentTimeMillis();
            tempDelPath = getTheRealPath(request, false) + theAttachTempPathStr; //temp存储和下载路径
            File file = new File(tempDelPath);
            if (!file.exists() && !file.isDirectory()) {//判断temp保存目录是否存在
                if (file.mkdirs()) {
                    System.out.println(path + "目录不存在，需要创建");//创建目录
                }
            } else {
                deleteFile(tempDelPath);//删除temp文件夹下的所有文件
            }


            if (fs.size() > 1) {//|| fs.get(0).getName().substring(fs.get(0).getName().lastIndexOf(".") + 1).equals("txt")
                zipFileName = zipFileName + ".zip";
                String zipFilepath = tempDelPath + File.separator + zipFileName;//使用temp路径
                result.setCode("temp");//用于Js判读文件在是否在temp文件夹中
                zipFile(fs, zipFilepath);
            } else {
                zipFileName = zipFileName + fs.get(0).getName().substring(fs.get(0).getName().lastIndexOf("."));
                String tempFilepath = tempDelPath + File.separator + zipFileName;//使用temp路径
                File in = fs.get(0);
                File out = new File(tempFilepath);
                Files.copy(in.toPath(), out.toPath(), StandardCopyOption.REPLACE_EXISTING);//复制文件到temp
            }
            result.setSuccess(true);
            result.setDetail(zipFileName);
        } catch (Exception e) {
            System.out.println("" + e);
            result.setSuccess(false);
        }
        return result;
    }


    public Result DeletedTempFile(String fileName, HttpServletRequest request) { //删除temp**.zip文件
        Result result = new Result();
        String rootPath = getTheRealPath(request, false) + theAttachTempPathStr;// 文件路径处理
        if (!fileName.substring(0, 4).equals("temp")) {
            return result;
        }
        try {
            File f = new File(rootPath + File.separator + fileName);
            if (f.delete()) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            System.out.println("删除附件异常" + e);
            result.setSuccess(false);
        }
        return result;
    }


    private boolean theTransferTo(FileItem item, String savePathFileName) throws IOException {
        //保存item到savePathFileName
        //获取item中的上传文件的输入流
        InputStream in = item.getInputStream();
        //创建一个文件输出流
        FileOutputStream out = new FileOutputStream(savePathFileName);//System.out.println(savePathFileName);
        //创建一个缓冲区
        byte buffer[] = new byte[1024];
        //判断输入流中的数据是否已经读完的标识
        int len;
        //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
        while ((len = in.read(buffer)) > 0) {
            //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + File.separator + filename)当中
            out.write(buffer, 0, len);
        }
        //关闭输入流
        in.close();
        //关闭输出流
        out.close();
        //删除处理文件上传时生成的临时文件
        item.delete();
        return true;
    }

    /**
     * 压缩文件
     *
     * @param fs          文件list
     * @param zipFilepath 压缩后文件保存地址
     */
    private void zipFile(ArrayList<File> fs, String zipFilepath) {
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(zipFilepath));
            for (File f : fs) {
                if (f.isFile()) {
                    zip(f, out);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 压缩单个文件
     *
     * @param srcFile //
     * @param out     //
     */
    private void zip(File srcFile, ZipOutputStream out) {
        if (!srcFile.exists())
            return;
        byte[] buf = new byte[1024];
        FileInputStream in = null;
        try {
            int len;
            in = new FileInputStream(srcFile);
            out.putNextEntry(new ZipEntry(srcFile.getName()));
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.closeEntry();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void deleteFile(String delPath) {
        boolean tempIs = false;
        try {
            File file = new File(delPath);
            if (!file.isDirectory()) { // 当且仅当此抽象路径名表示的文件存在且 是一个目录时，返回 true
                tempIs = file.delete();
            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                if (filelist != null) {
                    for (String aFilelist : filelist) {
                        File delFile = new File(delPath + File.separator + aFilelist);
                        if (!delFile.isDirectory()) {
                            tempIs = delFile.delete();
                            //System.out.println(delFile.getAbsolutePath() + "删除文件成功");
                        } else if (delFile.isDirectory()) {
                            deleteFile(delPath + File.separator + aFilelist);
                            System.out.println(file + "ssss");
                        }
                    }
                }
                if (!delPath.equals(tempDelPath)) {//选择不删除自身文件夹
                    tempIs = file.delete();
                }
            }
        } catch (Exception e) {
            System.out.println("deleteFile() Exception:" + e.getMessage() + "--" + tempIs);
        }
    }



}
