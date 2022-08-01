
<%@page import="java.util.Iterator"%>
<%@page import="com.bean.Product_prj"%>
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
	<th>Category</th>
</tr>
<%
Object obj = request.getAttribute("listOfProduct");
if(obj != null){
	List<Product_prj> listOfProduct = (List<Product_prj>)obj;
	Iterator<Product_prj> ii = listOfProduct.iterator();
	while(ii.hasNext()){
		Product_prj p = ii.next();
		%>
		<tr>
				<td><%=p.getPid() %></td>
				<td><%=p.getPname() %></td>
				<td><%=p.getPrice() %></td>
				<td><%=p.getCategory() %></td>
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