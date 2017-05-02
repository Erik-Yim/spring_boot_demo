package org.erik.spring.boot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Erik_Yim on 2017/5/2.
 */



@RestController
public class HelloController {

    @Value("${people.age}")
    //当application.properties和当application.yml都存在是优先读取properties文件，
    // 并且idea支持在编辑器中直接查看properties的文件属性，yml文件不支持
    private int age;

    @Value("${people.name}")
    private String name;

    @Value("${content}")
    private String content;

    @Value("${people.content}")
    private String peopleContent;

    @RequestMapping("/hello")
    public String hello() {
        return "hello "  + name + " " + age + " content " + content +
                " people content = " + peopleContent;
    }
}
