package com.flybeifeng.service;

import com.flybeifeng.dao.StudentDao;
import com.flybeifeng.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentService {

    @Autowired
    private StudentDao dao;

    public List<Student> getAllStudent() {
        return dao.findAll();
    }

    public Student getStudentById(int id) {
        return dao.getOneUser(id);
    }
}
