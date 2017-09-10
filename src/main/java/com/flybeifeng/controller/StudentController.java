package com.flybeifeng.controller;

import com.flybeifeng.annotation.SystemControllerLog;
import com.flybeifeng.annotation.SystemServiceLog;
import com.flybeifeng.service.StudentService;
import com.flybeifeng.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource(name = "studentService")
    private StudentService studentService;


    @RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
    @SystemControllerLog(description = "查询所有用户")
    public ModelAndView getAllStudent() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/views/studentDisplay.jsp");
        mav.addObject("students", studentService.getAllStudent());
        return mav;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @SystemControllerLog(description = "通过id查询用户")
    @SystemServiceLog(description = "通过id查询用户")
    public @ResponseBody Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/put", method = RequestMethod.GET)
    @SystemControllerLog(description = "新增用户")
    public ModelAndView addStudentById(@RequestParam(value = "id") int id,
                                       @RequestParam(value = "name", required = false, defaultValue = "0") String name,
                                       @RequestParam(value = "age") int age,
                                       @RequestParam(value = "sex") boolean sex) {
        studentService.addStudentById(id, name, age, sex);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("value", "haha");
        modelAndView.setViewName("/page/success.html");
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @SystemControllerLog(description = "删除用户")
    public ModelAndView deleteStudentById(@RequestParam(value = "id") int id) {

        studentService.deleteStudentById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("value", "haha");
        modelAndView.setViewName("/page/success.html");
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @SystemControllerLog(description = "修改用户年龄")
    public ModelAndView updateStudentById(@RequestParam(value = "id") int id,
                                          @RequestParam(value = "age") int age) {
        studentService.updateStudentById(id, age);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("value", "haha");
        modelAndView.setViewName("/page/success.html");
        return modelAndView;
    }
}
