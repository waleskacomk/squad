package consultas;

import java.util.ArrayList;

import model.Coordinate;
import model.Location;
import model.Media;
import model.Tag;
import model.User;

public class Produtos {

	/* COLETAS DE USUÁRIO */
	public static User getInfoUser(Coletor c){
		User usuario = new User();
		String link = "https://api.instagram.com/v1/users/self/?access_token=";
		String json = c.ConsultaPagina(link, 0);
		usuario = TratamentoJSon.getInfoUser(json);
		return usuario;
	}
	public static User getInfoUser(Coletor c,String user_id){
		User usuario = new User();
		String link = "https://api.instagram.com/v1/users/"+user_id+"/?access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return usuario;
	}
	public static ArrayList<User> getFollows(Coletor c){
		ArrayList<User> usuarios = new ArrayList<User>();
		String link = "https://api.instagram.com/v1/users/self/follows/?access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return usuarios;
	}
	public static ArrayList<User> getFollowedBy(Coletor c){
		ArrayList<User> usuarios = new ArrayList<User>();
		String link = "https://api.instagram.com/v1/users/self/followed-by?access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return usuarios;
	}
	public static ArrayList<User> getRequestedBy(Coletor c){
		ArrayList<User> usuarios = new ArrayList<User>();
		String link = "https://api.instagram.com/v1/users/self/requested-by?access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return usuarios;
	}
	public static ArrayList<User> getLikeByMedia(Coletor c,String media_id){
		ArrayList<User> usuarios = new ArrayList<User>();
		String link = "https://api.instagram.com/v1/media/"+media_id+"/likes?access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return usuarios;
	}
	/* COLETAS DE MEDIA */
	public static Media getInfoMedia(Coletor c,String media_id){
		Media media = new Media();
		String link = "https://api.instagram.com/v1/media/"+media_id+"/?access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return media;
	}
	public static ArrayList<Media> getMediaByUser(Coletor c){
		ArrayList<Media> medias = new ArrayList<Media>();
		String link = "https://api.instagram.com/v1/users/self/media/recent/?access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return medias;
	}
	public static ArrayList<Media> getMediaByCoordinate(Coletor c,Coordinate coordenada,int distancia){
		ArrayList<Media> medias = new ArrayList<Media>();
		String link = "https://api.instagram.com/v1/locations/search?lat="+coordenada.getLatitude()+"&lng="+coordenada.getLongitude()+"&access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return medias;
	}
	public static ArrayList<Media>	getMediaByLocation(Coletor c,String location_id){
		ArrayList<Media> medias = new ArrayList<Media>();
		String link = "https://api.instagram.com/v1/locations/"+location_id+"/media/recent?access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return medias;
	}
	public static ArrayList<Media> getMediaByTag(Coletor c,String tag){
		ArrayList<Media> medias = new ArrayList<Media>();
		String link = "https://api.instagram.com/v1/tags/"+tag+"/media/recent?access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return medias;
	}
	/* COLETAS DE TAGS */
	public static Tag getInfoTag(Coletor c,String tag){
		Tag nova_tag = new Tag();
		String link = "https://api.instagram.com/v1/tags/"+tag+"?access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return nova_tag;
	}
	public static ArrayList<Tag> getTagByName(Coletor c,String name){
		ArrayList<Tag> tags = new ArrayList<Tag>();
		String link = "https://api.instagram.com/v1/tags/search?q="+name+"&access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return tags;
	}
	/* COLETAS DE LOCAIS */
	public static Location getInfoLocation(Coletor c,String location_id){
		Location local = new Location();
		String link = "https://api.instagram.com/v1/locations/"+location_id+"?access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return local;
	}
	public static Location getLocationByCoordinate(Coletor c,Coordinate coordenadas){
		Location local = new Location();
		String link = "https://api.instagram.com/v1/locations/search/?lat="+coordenadas.getLatitude()+"&lng="+coordenadas.getLongitude()+"&access_token=";
		String resultado = c.ConsultaPagina(link, 0);
		System.out.println(resultado);
		return local;
	}
}
