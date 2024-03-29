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

@WebServlet(urlPatterns = "/queryStudentTest.do")
public class QueryStudentTest extends HttpServlet {
    private QueryCurrentStudent queryCurrentStudent = new QueryCurrentStudentImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置size和currentPage值
        int currentPage = 1;
        int size = 2;
        //根据size和currentPage获取学生信息进行返回
        List<Student> students = queryCurrentStudent.queryStudentOfSize(size, currentPage);

        //查询totalSize和totalPage
        Integer totalSize = 10;
        Integer totalPage = 3;

        //将数据存入请求域
        req.setAttribute("students",students);
        req.setAttribute("currentPage",currentPage);
        req.setAttribute("totalSize",totalSize);
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("size",size);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("queryStudent.jsp");
        requestDispatcher.forward(req,resp);
    }
}
