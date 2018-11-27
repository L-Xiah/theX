package fv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/webGLAni")
    public String webGLAni() {
        return "/webgl_animation_cloth";//通过thymeleaf引入resources下的html文件
    }
    @RequestMapping("/webGLAni1")
    public String webGLAni1() {
        return "/webgl_animation_keyframes";//通过thymeleaf引入resources下的html文件
    }

    @RequestMapping("/webGLObj")
    public String webGLObj() {
        System.out.println("--" + System.getProperty("catalina.home"));
        System.out.println("--" + System.getProperty("user.home"));
        logger.info("index---+++++");
        return "/webgl_loader_obj";//通过mvc访问src/main/webapp路径下jsp文件（前面不加"/"）
    }

    @RequestMapping("/webGLStl")
    public String webGLStl() {
        System.out.println("-webGLStl-" + System.getProperty("catalina.home"));
        System.out.println("-webGLStl-" + System.getProperty("user.home"));
        logger.info("index--webgl_loader_stl-+++++");
        return "/webgl_loader_stl";//通过mvc访问src/main/webapp路径下jsp文件（前面不加"/"）
    }

    @RequestMapping("/webgl")
    public String index1() {
        return "/webgl";//通过thymeleaf引入resources下的html文件
    }



}



