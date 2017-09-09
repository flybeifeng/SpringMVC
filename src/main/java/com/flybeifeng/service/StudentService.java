package com.flybeifeng.service;

import com.flybeifeng.bean.Student;
import com.flybeifeng.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addStudentById(int id, String name, int age, boolean sex) {
        dao.addOneUser(id, name, age, sex);
    }

    public void deleteStudentById(int id) {
        dao.deleteUserById(id);

    }

    public void updateStudentById(int id, int age) {
        dao.updateUserById(id, age);
    }

}
