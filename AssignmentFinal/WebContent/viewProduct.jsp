
<%@page import="java.util.Iterator"%>
<%@page import="com.bean.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>PId</th>
		<th>PName</th>
		<th>Price</th>
		<th>Brand</th>
	</tr>

<%
Object obj =request.getAttribute("obj");
List<Product_prj> listOfProdut = (List<Product_prj>)obj;
Iterator<Product_prj> li = listOfProdut.iterator();
while(li.hasNext()){
	Product_prj p  = li.next();
	%>
	<tr>
		<td><%=p.getPid() %> </td>
		<td><%=p.getPname() %> </td>
		<td><%=p.getPrice() %> </td>
		<td><%=p.getCategory()%> </td>
	</tr>
	<%
}
%>

</table>
</body>
</body>
</html>