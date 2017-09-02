package login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import consultas.Coletor;
import consultas.Produtos;
import consultas.TratamentoJSon;

@WebServlet("/servlet_autorizado")
public class ServletAutorizado extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		
		String link = "https://api.instagram.com/oauth/access_token";
		String client_id = "b0f19aceb46a4fa5bc699e536da2c8dd";
		String client_secret = "6b84287cf20c48c5adf9b76fdd66a4d3";
		String grant_type = "authorization_code";
		String redirect_uri = "http://localhost:8080/Squad/servlet_autorizado";		

		try{
			URL url = new URL(link);
			Map<String,Object> params = new LinkedHashMap<>();
	        params.put("client_id", client_id);
	        params.put("client_secret", client_secret);
	        params.put("grant_type", grant_type);
	        params.put("redirect_uri", redirect_uri);
	        params.put("code", code);

	        StringBuilder postData = new StringBuilder();
	        for (Map.Entry<String,Object> param : params.entrySet()) {
	            if (postData.length() != 0) postData.append('&');
	            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	            postData.append('=');
	            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	        }
	        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setDoOutput(true);
	        conn.getOutputStream().write(postDataBytes);

	        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

	        String resposta = "";
	        for (int c; (c = in.read()) >= 0;) resposta = resposta+(char)c;
	        String access_token = TratamentoJSon.getTokenAccess(resposta);
	        
	        Coletor col = new Coletor();
	        col.setAcess_token(access_token);
	        User u = Produtos.getInfoUser(col);
	        
	        HttpSession session = request.getSession();
	        session.setAttribute("coletor", col);
	        session.setAttribute("user", u);
	        
	        response.sendRedirect("Tela_Dados_Coleta_Basica.jsp");
	        
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}