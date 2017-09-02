package consultas;

import java.text.SimpleDateFormat;

import org.json.simple.JSONObject;

import model.Location;
import model.Media;
import model.Tag;
import model.User;

public abstract class Auxiliares {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	
	public static SimpleDateFormat getSdf() {
		return sdf;
	}
	public static void setSdf(SimpleDateFormat sdf) {
		Auxiliares.sdf = sdf;
	}
	public static User setItem(String json, User usuario){
		
		return usuario;
	}
	public static Media setItem(String json, Media media){
		
		return media;
	}
	public static Tag setItem(String json, Tag tag){
		
		return tag;
	}
	public static Location setItem(String json, Location local){
		
		return local;
	}
	public static String FazPaginacao (JSONObject jsonPagination,int cont,Coletor coletor){
		String proxima = (String) jsonPagination.get("next_url");
		int inicio = proxima.indexOf(coletor.getAcess_token());
		return coletor.ConsultaPagina(proxima.substring(0, inicio),cont);
	}
}