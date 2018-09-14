package fv.controller;


import fv.model.CompanyTheDictionary;
import fv.service.CompanyTheDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {

    private final CompanyTheDicService theDicService;
    @Autowired
    public HelloController(CompanyTheDicService theDicService) {
        this.theDicService = theDicService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello,Spring boot!";
    }

    //带参数
    @RequestMapping("/word/{name}")
    public String word(@PathVariable String name) {
        return "word--spring boot:" + name;
    }


    @RequestMapping("/showUser/{id}")
    public CompanyTheDictionary selectUser (@PathVariable int id){
        return theDicService.selectUser(id);

    }

    @RequestMapping("/showMapUser/{id}")
    public CompanyTheDictionary selectMapUser (@PathVariable int id){
        return theDicService.selectMapUser(id);

    }






}
