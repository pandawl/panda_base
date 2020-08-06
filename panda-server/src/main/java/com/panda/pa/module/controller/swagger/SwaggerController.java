package com.panda.pa.module.controller.swagger;

import com.panda.pa.base.model.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * swagger 接口
 * 
 * @author wl
 */
@Controller
@RequestMapping("/swagger")
public class SwaggerController extends BaseController
{
    @GetMapping
    public String index()
    {
        return "redirect:/swagger-ui.html";
    }
}
