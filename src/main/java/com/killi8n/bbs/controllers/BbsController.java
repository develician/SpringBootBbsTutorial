package com.killi8n.bbs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class BbsController {

    @RequestMapping("/")
    @ResponseBody
    String testing() {
        return "변경!";
    }
}
