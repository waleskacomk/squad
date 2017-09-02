package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet_login")
public class ServletLogin extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "https://api.instagram.com/oauth/authorize/?";
		String client_id = "b0f19aceb46a4fa5bc699e536da2c8dd";
		String redirect_uri = "http://localhost:8080/Squad/servlet_autorizado";
		String response_type = "code";
		url = url + 
				"client_id=" + client_id + 
				"&redirect_uri=" + redirect_uri + 
				"&response_type=" + response_type;
		response.sendRedirect(url);
	}
}
