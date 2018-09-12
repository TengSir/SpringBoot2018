package com.oracle.sb.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//静态资源加载的controller


@Controller
@RequestMapping("/")
public class ResourceControl {
    @RequestMapping("/{path}.html")
    public String gotoStaticResource(@PathVariable("path") String path){
        System.out.println("load resource:"+path+".html");
        return "/"+path;
    }
}
