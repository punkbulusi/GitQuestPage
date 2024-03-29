package com.msb.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer studentID;
    private String studentName;
    private String gender;
    private Integer age;
    private String fileName;
    private String fileType;

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(Integer studentID, String studentName, String gender, Integer age, String fileName, String fileType) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.gender = gender;
        this.age = age;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
