package com.SingleMode.Demo03.service;

import com.SingleMode.Demo03.entity.Student;

import java.util.List;

public interface ServiceStudent {
    /**
     * 保存student记录
     * @param student
     * @return 返回保存成功记录数
     */
    int save(Student student);

    /**
     * 根据id删除student记录
     * @param id
     * @return 返回删除成功记录数
     */
    int delete(int id);

    /**
     * 修改student记录
     * @param student
     * @return
     */
    int update(Student student);

    /**
     * 根据id查询学生记录
     * @param id
     * @return
     */
    Student getStudent(int id);

    /**
     * 查询所有的学生记录
     * @return
     */
    List<Student> getStudents();

}
