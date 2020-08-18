package fr.eni.projet.bo;

import java.util.List;

public class Categorie {
	
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
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	public Categorie(int noCategorie, String libelle, List<ArticleVendu> listeArticleCategorie) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.listeArticleCategorie = listeArticleCategorie;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", listeArticleCategorie="
				+ listeArticleCategorie + "]";
	}
	
	
	
	

}
