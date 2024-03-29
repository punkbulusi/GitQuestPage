package com.msb.service.impl;

import com.msb.mapper.StudentMapper;
import com.msb.pojo.Student;
import com.msb.service.QueryCurrentStudent;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QueryCurrentStudentImpl implements QueryCurrentStudent {
    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    //这里用来模拟面向切面编程
    private void after() {
        //这个构造块是实现为sqlSession进行赋值，而关闭sqlSession由每个使用的方法自行关闭
        //这里存在一个问题，构造块只有在new的时候运行一次，关闭了以后再次运行方法的时候sqlSession已经关闭了，还能再使用么？ 会出现executor的报错，所有把这个变成一个方法
        SqlSessionFactoryBuilder ssfb =new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
        resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    } catch (IOException e) {
        e.printStackTrace();
    }
        SqlSessionFactory factory=ssfb.build(resourceAsStream) ;
        sqlSession=factory.openSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    //这里用来模拟面向切面编程
    public void before(){
        sqlSession.close();
    }


    @Override
    public List<Student> queryStudentOfSize(int size, int currentPage) {
        after();//为sqlSession赋值

        //具体实现根据size和currentPage查询到list<Student>的功能
//        首先判断是要取第几条数据到第几条数据
//        从第几条开始（包含这一条）：size*(currentPage-1)+1  从第几条结束（包含这一条）；size*currentPage  要取几条数据；size
//        所以让mysql使用limit进行查询，需要提供offset（从0开始，包含当前数据），row count（返回几条数据）
        int offset = size*(currentPage-1);//因为从0开始，所以标准表达式是size*(currentPage-1)+1-1，最后的-1是向左偏移一个
        int rowCount = size;
        List<Student> studentBySize = studentMapper.findStudentBySize(offset, rowCount);


        before();//关闭sqlSession
        return studentBySize;
    }

//    这个函数用来返回总共数据条数
    @Override
    public Integer queryTotalSize() {
        after();//为sqlSession赋值

        int studentsSize = studentMapper.findStudentsSize();//查询一共有多少条记录

        before();//关闭sqlSession
        return studentsSize;
    }

    @Override
//    这个函数用来返回总共有多少页
    public Integer queryTotalPage(int size) {

        int x = queryTotalSize() / size;//先将大约页数算出
        int totalPage= (queryTotalSize() % size == 0) ? x : x+1 ;//根据情况进行取值

        return totalPage;
    }

    @Override
    public List<Student> queryStudentOfAge(int ageParameter, int size, int currentPage) {
        after();//为sqlSession赋值

        //具体实现根据ageParameter,size和currentPage查询到list<Student>的功能
//        首先判断是要取第几条数据到第几条数据
//        从第几条开始（包含这一条）：size*(currentPage-1)+1  从第几条结束（包含这一条）；size*currentPage  要取几条数据；size
//        所以让mysql使用limit进行查询，需要提供offset（从0开始，包含当前数据），row count（返回几条数据）
        int offset = size*(currentPage-1);//因为从0开始，所以标准表达式是size*(currentPage-1)+1-1，最后的-1是向左偏移一个
        int rowCount = size;
        List<Student> studentByAge = studentMapper.findStudentByAge(ageParameter, offset, rowCount);

        before();//关闭sqlSession
        return studentByAge;
    }

    @Override
    public List<Student> queryStudentOfName(String studentName, int size, int currentPage) {
        after();//为sqlSession赋值

        //具体实现根据studentName,size和currentPage查询到list<Student>的功能
//        首先判断是要取第几条数据到第几条数据
//        从第几条开始（包含这一条）：size*(currentPage-1)+1  从第几条结束（包含这一条）；size*currentPage  要取几条数据；size
//        所以让mysql使用limit进行查询，需要提供offset（从0开始，包含当前数据），row count（返回几条数据）
        int offset = size*(currentPage-1);//因为从0开始，所以标准表达式是size*(currentPage-1)+1-1，最后的-1是向左偏移一个
        int rowCount = size;
        List<Student> studentByName = studentMapper.findStudentByName(studentName, offset, rowCount);

        before();//关闭sqlSession

        return studentByName;
    }

    @Override
    public List<Student> queryStudentOfNameAndAge(int ageParameter, String studentName, int size, int currentPage) {
        after();//为sqlSession赋值

        //具体实现根据studentName,size和currentPage查询到list<Student>的功能
//        首先判断是要取第几条数据到第几条数据
//        从第几条开始（包含这一条）：size*(currentPage-1)+1  从第几条结束（包含这一条）；size*currentPage  要取几条数据；size
//        所以让mysql使用limit进行查询，需要提供offset（从0开始，包含当前数据），row count（返回几条数据）
        int offset = size*(currentPage-1);//因为从0开始，所以标准表达式是size*(currentPage-1)+1-1，最后的-1是向左偏移一个
        int rowCount = size;
        studentMapper.findStudentByNameAndAge(studentName,ageParameter,offset,rowCount);

        before();//关闭sqlSession
        return null;
    }


}
