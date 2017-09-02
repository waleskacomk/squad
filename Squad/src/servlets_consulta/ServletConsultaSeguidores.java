package servlets_consulta;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import consultas.Coletor;
import consultas.Produtos;
import model.User;

@WebServlet("/servlet_consulta_seguidores")
public class ServletConsultaSeguidores extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Coletor coletor = (Coletor)session.getAttribute("coletor");
		User usuario = (User)session.getAttribute("user");
		
		//Produtos.getFollows(coletor);
		Produtos.getFollowedBy(coletor);
		
		response.sendRedirect("Tela_Lista_Follows.jsp");
	}
}
