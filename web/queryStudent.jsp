<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2024/3/14
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>queryStudent</title>
</head>
<style>
    th,td{
        width: 50px;
        height: 35px;
    }

</style>
<body>
<table cellspacing="0px" border="1px black solid" align="center" width="80%">

<%--表头上面内容，用于做具体数据查询--%>
    <tr>
        <td colspan="8" align="center">
            <form>
                姓名:<input type="text" name="studentName" value="${studentName}">
                年龄:<input type="text" name="age" value="${age}">
                <input type="hidden" name="size" value="${size}">
                <input type="hidden" name="currentPage" value="${currentPage}">
                <input type="submit" value="查询">
            </form>
        </td>
    </tr>

<%--表头--%>
    <tr >
        <th>序号</th>
        <th>学生编号</th>
        <th>学生姓名</th>
        <th>学生性别</th>
        <th>学生年龄</th>
        <th>文件名</th>
        <th>文件类型</th>
        <th>操作</th>
    </tr>
<%--学生具体信息（表格内主要内容）,这里的size需要在selvet中进行初始化--%>
<%--  size>totalSize?totalSize-1:size-1 这里判断要求每页的条数是否大于总条数  --%>
    <c:forEach var="i" begin="0" end="${size>totalSize?totalSize-1:size-1}" step="1">
    <tr>
        <td>${size*(currentPage-1)+i+1}</td>
        <td>${students[i].studentID}</td>
        <td>${students[i].studentName}</td>
        <td>${students[i].gender}</td>
        <td>${students[i].age}</td>
        <td>${students[i].fileName}</td>
        <td>${students[i].fileType}</td>
        <td>${i}</td>
    </tr>
    </c:forEach>

<%--最下方内容，用于跳转某页，改变每页数据条数--%>
    <tr>
        <td colspan="8" align="center">
<%--当前在第几页--%>
            当前为${currentPage}页
    <%--    首页        --%>

            <a href="queryStudent.do?currentPage=${1}&size=${size}&age=${age}&studentName=${studentName}" target="_self">首页</a>

<%--    如果currentPage离第一页较远 则增加...的显示       --%>
            <c:if test="${currentPage-2>=1}">
                ...
            </c:if>
<%--这里totalPage是总页数,可选页数总是前后不超过2页--%>
<%--    (currentPage-2>=1)?currentPage-2:1 这个表达式保证begin总是大于或等于1        --%>
<%--    (currentPage+2<totalPage)?currentPage+2:totalPage 这个表达式保证end总是小于或等于tatalPage      --%>
            <c:forEach var="i" begin="${(currentPage-2>=1)?currentPage-2:1}" end="${(currentPage+2<totalPage)?currentPage+2:totalPage}" step="1">
                <a href="queryStudent.do?currentPage=${i}&size=${size}&age=${age}&studentName=${studentName}" target="_self">${i}</a>
            </c:forEach>
<%--    如果currentPage离最后一页较远 则增加...的选项        --%>
            <c:if test="${currentPage+2<totalPage}">
                ...
            </c:if>

<%--    尾页        --%>

            <a href="queryStudent.do?currentPage=${totalPage}&size=${size}&age=${age}&studentName=${studentName}" target="_self">尾页</a>



            <br/>
    <%--展示查询到了多少条数据--%>
    <%--下面的表单是调整每页的条数--%>
            <form>
                共查询到${totalSize}条数据
                &nbsp;
                每页
                <input type="text" name="size" style="width:30px " value="${size}">
                条
                <input type="submit" value="修改">
            </form>

        </td>
    </tr>

</table>
</body>
</html>
