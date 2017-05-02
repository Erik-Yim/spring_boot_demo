package org.erik.spring.boot.demo.controller;

import org.erik.spring.boot.demo.vo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    @Autowired
    //这种方法比@Value要常用的多，推荐这种用法
    private People people;

    @RequestMapping(value={"/hello","/hi"}) //访问这两个路径都可以跳转到这个方法
    public String hello() {
        return "hello "  + name + " " + age + " content " + content +
                " people content = " + peopleContent;
    }


    @RequestMapping("/helloPeople")
    public String helloPeople() {
        return "hello people = " + people;
    }

    @RequestMapping("showId/{id}")
    //http://localhost:8090/showId/123?id=111 这样写是支持混合方式的参数的，就是？后面的值不会映射到{id}的值上,加上defaultVaule可以设置默认值
    public String showId(@PathVariable String id, @RequestParam(value = "id", defaultValue = "888") Integer urlParamId) {
        return "id : " + id + " urlParamId : " + urlParamId;
    }
}
