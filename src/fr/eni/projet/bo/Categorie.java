package fr.eni.projet.bo;

import java.io.Serializable;
import java.util.List;

public class Categorie implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Variable
	int noCategorie;
	String libelle;
	List <ArticleVendu> listeArticleCategorie;
	
	//Getter et Setter
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<ArticleVendu> getListeArticleCategorie() {
		return listeArticleCategorie;
	}
	
	//Constructor
	public Categorie() {
		super();
	}
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	//toString
	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", listeArticleCategorie="
				+ listeArticleCategorie + "]";
	}
	
	
	
	

}
