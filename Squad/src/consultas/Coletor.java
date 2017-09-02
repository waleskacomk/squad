package consultas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Coordinate;
import model.Location;
import model.Media;
import model.Tag;
import model.User;

public class Coletor {
	private String acess_token;
	private static int limitePaginas = 1500;

	public String getAcess_token() {
		return acess_token;
	}
	public void setAcess_token(String acess_token) {
		this.acess_token = acess_token;
	}
	
	@SuppressWarnings("unchecked")
	public String ConsultaPagina(String link,int cont){
		String saida = "";
		// Acompanhamento de Execucao
		cont++;
		if ((cont % 100) == 0)
			System.out.println("Pagina "+cont+" - "+ Auxiliares.getSdf().format(new Date())+link);
		
		//Variáveis de Internet
		URL url = null;
		HttpURLConnection request = null;

		//Variáveis de Json
		JSONParser jsonParser = null;
		JSONObject jsonObject = null;
		JSONObject jsonPagination = null;
		
		try {
			url = new URL(link+acess_token);
			request = (HttpURLConnection) url.openConnection();
			request.connect();
			jsonParser = new JSONParser();
		    jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader((InputStream) request.getContent()));
		    if (jsonObject.get("data").toString().startsWith("[")){
		    	saida = saida+jsonObject.get("data").toString();
		    } else {
		    	JSONArray jsonArray = new JSONArray();
		    	jsonArray.add(jsonObject.get("data"));
		    	saida = saida+jsonArray.toString();
		    }
		    jsonPagination = (JSONObject) jsonObject.get("pagination");
		    if (!(jsonPagination==null) && !jsonPagination.isEmpty() && cont < limitePaginas){
		    	saida = saida+Auxiliares.FazPaginacao(jsonPagination,cont,this);
		    }
		} catch (FileNotFoundException e){
			System.out.println("!!!!! Página não encontrada! - "+link+" - "+ Auxiliares.getSdf().format(new Date()));
		} catch (IOException e) {
			String erro = e.toString();
			System.out.println("Erro:"+erro);
			System.out.println("Saída:"+jsonObject);
			if (erro.contains("Server returned HTTP response code: 400")){
				int inicioId = erro.indexOf("users/")+7;
				String userid = erro.substring(inicioId, inicioId+10);
				if (userid.contains("/")) userid.substring(0, 9);
				System.out.println("!!!!! Token não tem permissão para acessar usuario. - Id: "+userid+" - "+ Auxiliares.getSdf().format(new Date()));
			}
			if (erro.contains("Server returned HTTP response code: 429")){
				cont--;
				System.out.println("!!!!! Limite Máximo de Consultas para o Token: "+acess_token+" - "+ Auxiliares.getSdf().format(new Date()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return saida;

	}
}