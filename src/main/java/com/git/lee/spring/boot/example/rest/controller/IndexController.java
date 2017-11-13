package com.git.lee.spring.boot.example.rest.controller;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LISHUAIWEI
 * @date 2017/11/13 16:42
 */
@Controller
public class IndexController {

    @RequestMapping("index")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "Lee")String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping("vue1")
    public String vue1(@RequestParam(value = "name", required = false, defaultValue = "Lee")String name, Model model) {
        model.addAttribute("name", name);
        return "vue-demo1";
    }

    @RequestMapping("vue-thymeleaf")
    public String vueThymeleaf(Model model) {
        model.addAttribute("items", Lists.newArrayList("aa", "bb", "cc"));
        return "vue-thymeleaf";
    }
}
