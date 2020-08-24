package fr.eni.projet.bo;

import java.io.Serializable;

public class Retrait implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//variables
	int noArticleRetrait;
	String rue;
	String codePostal;
	String ville;
	
	ArticleVendu article;
	
	// getters & setter
	public ArticleVendu getArticle() {
		return article;
	}
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public int getNoArticleRetrait() {
		return noArticleRetrait;
	}
	public void setNoArticleRetrait(int noArticleRetrait) {
		this.noArticleRetrait = noArticleRetrait;
	}
	//Constructor
	public Retrait() {
		super();
	}
	
	public Retrait(int noArticleRetrait, String rue, String codePostal, String ville) {
		super();
		this.noArticleRetrait = noArticleRetrait;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	public Retrait(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Retrait [noArticleRetrait=" + noArticleRetrait + ", rue=" + rue + ", codePostal=" + codePostal
				+ ", ville=" + ville + "]";
	}
	
	
	
	
	
}
