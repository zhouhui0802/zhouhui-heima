package com.heima.freemarker.controller;


import com.heima.freemarker.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/2/26 13:18
 */
@Controller
public class HelloController {

    @GetMapping("/basic")
    public String test(Model model) {

        //纯文本形式的参数
        model.addAttribute("name", "freemarker");

        //实体相关的参数
        Student student = new Student();
        student.setName("zhouhui");
        student.setAge(18);
        model.addAttribute("stu", student);

        return "01-basic";
    }
}
