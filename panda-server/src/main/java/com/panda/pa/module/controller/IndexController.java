package com.panda.pa.module.controller;

import com.panda.pa.base.model.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 
 * @author wl
 */
@Slf4j
@RestController
@RequestMapping("/")

public class IndexController extends BaseController
{


    @GetMapping
    public String index()
    {
        return "server start";
    }


}
