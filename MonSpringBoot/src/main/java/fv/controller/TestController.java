package fv.controller;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@EnableAutoConfiguration
public class TestController {

    /**
     * 下载文件
     * @param request //
     * @param resp //
     * @param id //
     * @param url //
     */
    @RequestMapping(value = "downLoadFile/{id}",method = RequestMethod.GET)
    @ResponseBody
    public void downLoadFile(HttpServletRequest request, HttpServletResponse resp,@PathVariable("id") int id
    ,@RequestParam(value = "url", required = false) String url){

        System.out.println("----" + id + "--" + url) ;

        String theTempPath = request.getSession().getServletContext().getRealPath("\\");
        String theRealPath = theTempPath.substring(0, theTempPath.lastIndexOf("\\") + 1);
        theTempPath += File.separator;

        System.out.println("thePath:" + theRealPath);
        System.out.println("theTempPath:" + theTempPath);

        String name = "123.txt";
        String realPath = "D:\\testDir";

        File file = new File(realPath + File.separator + name);
        resp.reset();
        resp.setContentType("application/octet-stream");
        resp.setCharacterEncoding("utf-8");
        resp.setContentLength((int)file.length());
        resp.setHeader("Content-Disposition","attachment;filename=" + "t456.txt");

        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os;
        try{
            os = resp.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i;
            while ((i = bis.read(buff)) != -1){
                os.write(buff,0,i);
                os.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }


    @RequestMapping(value = "infoJson",method = RequestMethod.GET)
    @ResponseBody
    public String infoJson(){
        return "theTest...LLLL";
    }




}
