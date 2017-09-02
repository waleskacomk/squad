<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exercício de Servlets</title>
</head>
<body>

	<%
	
	HttpSession session2 = request.getSession();
	String nome = String.valueOf(session2.getAttribute("nome"));
	String filme = String.valueOf(session2.getAttribute("filme"));
	String imc = String.valueOf(session2.getAttribute("imc"));
	String palavra = String.valueOf(session2.getAttribute("palavra"));
	
	if(!filme.equals("null")){
		out.println("O Filme preferido do(a) "+nome+" é o "+filme);%></br><%
	}
	if(!imc.equals("null")){
		out.println("O IMC do(a) "+nome+" é "+imc);%></br><%
	}
	if(!palavra.equals("null")){
		out.println("A palavra formada com o nome recebido foi "+palavra);%></br><%
	}
	%>
	<form action="inicio.jsp">
	</BR><input type="submit" value="VOLTAR">
	</form>

</body>
</html>