package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Media {
	@Id
	@GeneratedValue
	private int id_banco;
	private String id;
	private String type;
	private ArrayList<String> usuarios;
	private String filtro;
	private ArrayList<String> tags;
	private String qt_comentarios;
	private String qt_likes;
	private String created_time;
	private String id_user;
	private String id_local;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	public String getQt_comentarios() {
		return qt_comentarios;
	}
	public void setQt_comentarios(String qt_comentarios) {
		this.qt_comentarios = qt_comentarios;
	}
	public String getQt_likes() {
		return qt_likes;
	}
	public void setQt_likes(String qt_likes) {
		this.qt_likes = qt_likes;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getId_local() {
		return id_local;
	}
	public void setId_local(String id_local) {
		this.id_local = id_local;
	}
	public ArrayList<String> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<String> usuarios) {
		this.usuarios = usuarios;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
}
