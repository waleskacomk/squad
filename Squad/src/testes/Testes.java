package testes;

import model.Persistencia;
import model.Tag;

public class Testes {
	public static void main(String[] args) {
		Tag tag = new Tag();
		tag.setCount(10);
		tag.setName("teste");
		Persistencia.inserir(tag, "Tag");
		System.out.println("Suuuuucessooooo");
	}
}
