<%@page import="team5.DBconn"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
   //out.println("code=>" + code);
   Connection con = DBconn.getConnection();
   PreparedStatement stmt;
   ResultSet result;
   String selectSql;
   
   selectSql = "SELECT name " 
            + "FROM   students ";
   stmt = con.prepareStatement(selectSql);
   result = stmt.executeQuery();
   if (result.next()) {
      String result_count = result.getString("name");
%>

   <h1>결과</h1>
   
   <table>
      <tr>
        <td><%//result_count %></td>
      </tr>
   </table>

   <%
  }
   /* result.close();
   stmt.close();
   con.close();*/
   //DBConn.close();
%>
</body>
</html>