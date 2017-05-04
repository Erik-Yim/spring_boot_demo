package com.erik.spring.boot.swagger.demo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Erik_Yim on 2017/5/3.
 */
@RestController
public class RestApiDemoController {

    @ApiOperation(value="用户登录提示", notes="用户登录提示 notes")
    @ApiImplicitParam(name = "name", value = "String 变量", required = true, dataType = "String")
    @GetMapping("/hello")
    public String sayHello(String name) {
        return "hello " + name;
    }
}
