<%@page import="java.util.Iterator"%>
<%@page import="com.bean.Purchase"%>
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
	<th>Id</th>
	<th>Item</th>
	<th>Price</th>
	<th>Date</th>
</tr>
<%
Object obj = request.getAttribute("listOfPurchase");
if(obj != null){
	List<Object[]> listOfPurchase = (List<Object[]>)obj;
	Iterator<Object[]> ii = listOfPurchase.iterator();
	while(ii.hasNext()){
		Object p[] = ii.next();
		%>
		<tr>
				<td><%=p[0] %></td>
				<td><%=p[1] %></td>
				<td><%=p[2] %></td>
				<td><%=p[3] %></td>
		</tr>
		<%
	}
}
%>
</table>
</br>
<a href="index.jsp">logout</a>
</body>
</html>