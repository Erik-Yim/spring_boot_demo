package org.erik.spring.boot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Erik_Yim on 2017/5/2.
 */
@Controller
public class TemplateTestController {

    @RequestMapping("/index")
    private String showIndex() {
        return "index";
    }
}
