package com.msb.mapper;

import com.msb.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> findStudentBySize(int size, int currentPage);

    int findStudentsSize();

    List<Student> findStudentByAge(int ageParameter, int offset, int rowCount);

    List<Student> findStudentByName(String studentName, int offset, int rowCount);

    List<Student> findStudentByNameAndAge(String studentName, int ageParameter, int offset, int rowCount);
}
