package com.msb.service;
//这里实现查询相关数据并返回的功能

import com.msb.pojo.Student;

import java.util.List;

public interface QueryCurrentStudent {

    List<Student> queryStudentOfSize(int size, int currentPage);

    Integer queryTotalSize();

    Integer queryTotalPage(int size);

    List<Student> queryStudentOfAge(int ageParameter, int size, int currentPage);

    List<Student> queryStudentOfName(String studentName, int size, int currentPage);

    List<Student> queryStudentOfNameAndAge(int ageParameter, String studentName, int size, int currentPage);
}
