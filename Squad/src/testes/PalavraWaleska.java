package testes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/palavra_nome")
public class PalavraWaleska extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		HttpSession sessao = arg0.getSession();
		sessao.setAttribute("nome", "waleska");
		sessao.setAttribute("palavra", "palavra intercalada");
		arg1.sendRedirect("pagina_saida.jsp");
	}

}
