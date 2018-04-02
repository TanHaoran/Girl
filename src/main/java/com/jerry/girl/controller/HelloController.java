package com.jerry.girl.controller;

import com.jerry.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/3
 * Time: 15:31
 * Description:
 */

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping(value = {"/say", "/read"})
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id: " + id;
    }
}
