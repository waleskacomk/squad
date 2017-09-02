<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="consultas.Coletor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Squad - Você no mundo!</title>
</head>
<body>

	<%
	ArrayList<User> usuarios = (ArrayList<User>)session.getAttribute("users");
	%>
	<form action="">
		<%
		int i;
		if(usuarios == null){
			out.println("Lista Vazia!");
		} else {
			for(i=0;i<usuarios.size();i++){
				out.println(usuarios.get(i).getFull_name());%></br><%
			}
		}%>
	</form>

</body>
</html>