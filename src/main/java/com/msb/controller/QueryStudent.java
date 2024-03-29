package com.msb.controller;

import com.msb.pojo.Student;
import com.msb.service.QueryCurrentStudent;
import com.msb.service.impl.QueryCurrentStudentImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/queryStudent.do")
public class QueryStudent extends HttpServlet {
    private QueryCurrentStudent queryCurrentStudent = new QueryCurrentStudentImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置初始化值
        int size = 10;
        int currentPage = 1;
        List<Student> students = null;

        //获取前端返回的姓名和年龄值
        String studentName = req.getParameter("studentName");
        String age = req.getParameter("age");

        //如果前端页面返回size值，获取每页数据条数
        String stringSize =req.getParameter("size");
        if(stringSize != null && stringSize!=""){
            size = Integer.parseInt(stringSize);
        }

        //如果前端页面返回currentPage值，获取currentPage
        String stringCurrentPage = req.getParameter("currentPage");
        if(stringCurrentPage != null && stringCurrentPage!=""){
            currentPage = Integer.parseInt(stringCurrentPage);
        }

        //返回students的值
        if((studentName==null || studentName=="") && age!=null && age!=""){
            int ageParameter = Integer.valueOf(age);
            students = queryCurrentStudent.queryStudentOfAge(ageParameter,size,currentPage);
        }else if(studentName!=null && studentName!="" && (age==null || age=="")){
            students = queryCurrentStudent.queryStudentOfName(studentName,size,currentPage);
        }else if(studentName!=null && age!=null && studentName!="" && age!=""){
            int ageParameter = Integer.valueOf(age);
            students = queryCurrentStudent.queryStudentOfNameAndAge(ageParameter,studentName,size,currentPage);
        }
        else {//当studentName和age为空时，根据size和currentPage获取学生信息进行返回
            students = queryCurrentStudent.queryStudentOfSize(size, currentPage);
        }

        //查询totalSize和totalPage
        Integer totalSize = queryCurrentStudent.queryTotalSize();
        Integer totalPage = queryCurrentStudent.queryTotalPage(size);

        //将数据存入请求域
        req.setAttribute("students",students);
        req.setAttribute("currentPage",currentPage);
        req.setAttribute("totalSize",totalSize);
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("size",size);
        req.setAttribute("age",age);
        req.setAttribute("studentName",studentName);



        //请求转发至questStudent.jsp
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("queryStudent.jsp");
        requestDispatcher.forward(req,resp);
    }
}
