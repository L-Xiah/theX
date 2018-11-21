package fv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/index")
    public String index() {
        System.out.println("--" + System.getProperty("catalina.home"));
        System.out.println("--" + System.getProperty("user.home"));
        logger.info("index---+++++");
        return "index";//通过mvc访问src/main/webapp路径下jsp文件（前面不加"/"）
    }

    @RequestMapping("/index1")
    public String index1() {
        return "/index";//通过thymeleaf引入resources下的html文件
    }


    @RequestMapping("/set")
    public String getSet() {
        return "theK";
    }

    @RequestMapping("/theK")
    public String getTheK() {
        return "/theK";
    }

    @RequestMapping("/slide")
    public String getTheSlide() {
        return "/theSlide";
    }
    @RequestMapping("/theCss")
    public String getTheCss() {
        return "/theCss";
    }



}



