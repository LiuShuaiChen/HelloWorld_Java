package com.DesignMode.Demo03.service.impl;

import com.DesignMode.Demo03.entity.Student;
import com.DesignMode.Demo03.service.ServiceStudent;

import java.util.List;

public class ServiceStudentImpl implements ServiceStudent {

    /**
     * 保存student实体类
     * @param student
     * @return
     */
    @Override
    public int save(Student student) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public Student getStudent(int id) {
        return null;
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }
}
