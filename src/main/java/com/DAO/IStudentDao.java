package com.DAO;

import com.Entity.Student;

import java.util.List;

public interface IStudentDao {

    //查询所有学生
    List<Student> FindAll();

    //插入一个学生
    void AddStudent(Student student);

    //修改学生信息
    void UpdateStudent(Student student);

    //修改学生信息
    void DeleteStudent(int UserID);

    //根据ID查询学生
    Student CheckById(int UserID);

    //根据学校查询学生
    List<Student> CheckBySchool(int collegeID);

}