package fv.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@SuppressWarnings("unused")
@RestController
@EnableAutoConfiguration
public class FileController {




    @GetMapping("/Download2")
    public void downloadFileByOutputStream(HttpServletResponse response) {

        // 1.获取要下载的文件的绝对路径
        File file = new File("D:\\testDir\\123.txt");
        // 2.获取要下载的文件名
        String fileName = "dtd.txt";
        // 3.设置content-disposition响应头控制浏览器以下载的形式打开文件
        response.setHeader("content-disposition", "attachment;filename=" + fileName);

        // 4.根据文件路径获取要下载的文件输入流
        try {
            InputStream in = new FileInputStream(file);
            int len;
            // 5.创建数据缓冲区
            byte[] buffer = new byte[1024];
            // 6.通过response对象获取OutputStream流
            OutputStream out = response.getOutputStream();
            // 7.将FileInputStream流写入到buffer缓冲区
            while ((len = in.read(buffer)) > 0) {
                // 8.使用OutputStream将缓冲区的数据输出到客户端浏览器
                out.write(buffer, 0, len);
                in.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @GetMapping("/Download")
    public void testDownload (HttpServletResponse  response, HttpServletRequest request) {

        System.out.println("---------" + request.getContextPath());
        File file=new File("D:\\testDir\\123.txt");//     //1.获取要下载的文件的绝对路径
        String newDname="new.txt";     //2.获取要下载的文件名
        if(file.exists()) {  //判断文件父目录是否存在
            System.out.println("aaa");
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + newDname);  //3.设置content-disposition响应头控制浏览器以下载的形式打开文件
            byte[] buff = new byte[1024];    //5.创建数据缓冲区
            BufferedInputStream bis = null;
            OutputStream os;
            try {
                os = response.getOutputStream(); //6.通过response对象获取OutputStream流
                bis = new BufferedInputStream(new FileInputStream(file));     //4.根据文件路径获取要下载的文件输入流
                int i = bis.read(buff);         //7.将FileInputStream流写入到buffer缓冲区
                while (i != -1) {
                    os.write(buff, 0, buff.length); //8.使用将OutputStream缓冲区的数据输出到客户端浏览器
                    os.flush();
                    i = bis.read(buff);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



}
