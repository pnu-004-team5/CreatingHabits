<%@page import="team5.DBconn"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
   String ip = request.getParameter("ip_address");
   //out.println("code=>" + code);
   Connection con = DBconn.getConnection();
   
   Statement stmt = con.createStatement();
   String selectSql = "SELECT name \n"
		            + "FROM   students ";
   ResultSet result = stmt.executeQuery(selectSql);
   if (result.next()) {
      String result_count = result.getString("name");
%>

   <h1>결과</h1>
   
   <table>
      <tr>
         <td><%=result_count %></td>
      </tr>
   </table>

   <%
   } else {
      out.println("오류");
   }
   result.close();
   stmt.close();
   con.close();
   //DBConn.close();
%>
</body>
</html>