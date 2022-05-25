package com.medical.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台主页面控制
 * @author: lixiang
 * @date: 2022/5/7
 * @version: 1.0版本
 */
@Controller
@RequestMapping("/admin")
public class IndexController {
    //主界面
    @RequestMapping("/index")
    public String index() {
        return "admin/index";
    }
}
