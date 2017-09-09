package com.flybeifeng.controller;

import com.flybeifeng.service.StudentService;
import com.flybeifeng.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource(name = "studentService")
    private StudentService studentService;


    @RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
    public ModelAndView getAllStudent() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/views/studentDisplay.jsp");
        mav.addObject("students", studentService.getAllStudent());
        return mav;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }
}
