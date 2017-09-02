package consultas;

import java.util.ArrayList;

import model.Location;
import model.Media;
import model.Tag;
import model.User;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TratamentoJSon {
	
	public static String getTokenAccess(String json){
		JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) jsonParser.parse(json);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return (String)jsonObject.get("access_token");
	}
	
	public static User getInfoUser(String json){
		User u = new User();
		JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        JSONArray jsonArray = null;
		try {
			jsonArray = (JSONArray) jsonParser.parse(json);
			jsonObject = (JSONObject) jsonArray.get(0);
			u.setId((String)jsonObject.get("id"));
			u.setUsername((String)jsonObject.get("username"));
			u.setFull_name((String)jsonObject.get("full_name"));
			u.setProfile_picture((String)jsonObject.get("profile_picture"));
			u.setBio((String)jsonObject.get("bio"));
			u.setWebsite((String)jsonObject.get("website"));
			JSONObject counts = (JSONObject)jsonObject.get("counts");
			u.setQt_media((long)counts.get("media"));
			u.setQt_follows((long)counts.get("follows"));
			u.setQt_followed_by((long)counts.get("followed_by"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return u;
	}

	public ArrayList<User> getFollows(String json) {
		return null;
	}
	public ArrayList<User> getFollowedBy(String json) {
		return null;
	}
	public ArrayList<User> getRequestedBy(String json) {
		return null;
	}
	public ArrayList<User> getLikeByMedia(String json) {
		return null;
	}
	public Media getInfoMedia(String json) {
		return null;
	}
	public ArrayList<Media> getMediaByUser(String json) {
		return null;
	}
	public ArrayList<Media> getMediaByCoordinate(String json) {
		return null;
	}
	public ArrayList<Media>	getMediaByLocation(String json) {
		return null;
	}
	public ArrayList<Media> getMediaByTag(String json) {
		return null;
	}
	public Tag getInfoTag(String json) {
		return null;
	}
	public ArrayList<Tag> getTagByName(String json) {
		return null;
	}
	public Location getInfoLocation(String json) {
		return null;
	}
	public Location getLocationByCoordinate(String json) {
		return null;
	}
}
