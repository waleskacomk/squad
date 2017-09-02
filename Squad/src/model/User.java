package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id_banco;
	private String id;
	private String username;
	private String full_name;
	private String profile_picture;
	private String bio;
	private String website;
	private long qt_media;
	private long qt_follows;
	private long qt_followed_by;
	private String token_access;
	
	public String getTokenAccess() {
		return token_access;
	}
	public void setTokenAccess(String token_access) {
		this.token_access = token_access;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getProfile_picture() {
		return profile_picture;
	}
	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public long getQt_media() {
		return qt_media;
	}
	public void setQt_media(long qt_media) {
		this.qt_media = qt_media;
	}
	public long getQt_follows() {
		return qt_follows;
	}
	public void setQt_follows(long qt_follows) {
		this.qt_follows = qt_follows;
	}
	public long getQt_followed_by() {
		return qt_followed_by;
	}
	public void setQt_followed_by(long qt_followed_by) {
		this.qt_followed_by = qt_followed_by;
	}
}
