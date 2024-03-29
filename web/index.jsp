<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2024/3/14
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <!--表格：4行4列
          table:表格
          tr:行
          td:单元格
          th:特殊单元格：表头效果：加粗，居中
          默认情况下表格是没有边框的，通过属性来增加表框：
          border:设置边框大小
          cellspacing：设置单元格和边框之间的空隙
          align="center"  设置居中
          background 设置背景图片 background="img/ss.jpg"
          bgcolor :设置背景颜色
          rowspan:行合并
          colspan：列合并
  -->
  <table border="1px" cellspacing="0px" width="400px" height="300px" bgcolor="darkseagreen" >
    <tr bgcolor="bisque">
      <th>学号</th>
      <th>姓名</th>
      <th>年纪</th>
      <th>成绩</th>
    </tr>
    <tr>
      <td align="center">1001</td>
      <td>丽丽</td>
      <td>19</td>
      <td rowspan="3">90.5</td>
    </tr>
    <tr>
      <td colspan="2" align="center">2006</td>
      <td>30</td>
    </tr>
    <tr>
      <td>3007</td>
      <td>小明</td>
      <td>18</td>
    </tr>
  </table>
  </body>
</html>
