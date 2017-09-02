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
	User usuario = (User)session.getAttribute("user");
	%>
	<form action="">
		<a href="http://www.instagram.com/<%=usuario.getUsername()%>">
			<img alt="Sua foto" src="<%=usuario.getProfile_picture()%>">
		</a>
	
		Olá <%=usuario.getUsername() %></br>
		Segue suas informações do Instgram:</br>
		Nome completo: <%=usuario.getFull_name() %></br>
		Quantidade de mídias postadas: <%=usuario.getQt_media() %></br>
		Quantidade de pessoas que você segue: <%=usuario.getQt_follows() %></br>
		Quantidade de seguidores: <%=usuario.getQt_followed_by() %></br>
		</br></br></br></br>
		<a href="servlet_consulta_seguidores">Consultar Seguidores</a></br>
		<a href="#">Consultr Seguidos</a></br>
		<a href="#">Consultar Requisitados</a></br>
		<a href="#">Consultar Likes</a></br>
		<a href="#">Consultar Info de uma Media</a></br>
		<a href="#">Consultar Medias de um User</a></br>
		<a href="#">Consultar Medias de uma coordenada</a></br>
		<a href="#">Consultar Medias de um local</a></br>
		<a href="#">Consultar Medias de uma tag</a></br>
		<a href="#">Consultar Tag</a></br>
		<a href="#">Consultar Tag por nome</a></br>
		<a href="#">Consultar Local</a></br>
		<a href="#">Consultar Local por coordenada</a></br>
	</form>
</body>
</html>