package fr.eni.projet.bo;

import java.time.LocalDate;

public class Enchere {
	//Variable
	int noEnchere;
	LocalDate dateEnchere;
	int montantEnchere;
	int noArticleVenduEnchere;
	int noUtilisateurEnchere;
	
	Utilisateur utilisateur;
	ArticleVendu articleVendu;
	
	// Getter & Setter
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	public int getNoEnchere() {
		return noEnchere;
	}
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	public void setDateEnchere(LocalDate dateEnchère) {
		this.dateEnchere = dateEnchère;
	}
	public int getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}
	
	public int getNoArticleVenduEnchere() {
		return noArticleVenduEnchere;
	}
	public void setNoArticleVenduEnchere(int noArticleVenduEnchere) {
		this.noArticleVenduEnchere = noArticleVenduEnchere;
	}
	public int getNoUtilisateurEnchere() {
		return noUtilisateurEnchere;
	}
	public void setNoUtilisateurEnchere(int noUtilisateurEnchere) {
		this.noUtilisateurEnchere = noUtilisateurEnchere;
	}
	//Constructor
	public Enchere() {
		super();
	}
	public Enchere(LocalDate dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	public Enchere(LocalDate dateEnchere, int montantEnchere, Utilisateur utilisateur, ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}
	
	public Enchere(LocalDate dateEnchere, int montantEnchere, int noArticleVenduEnchere, int noUtilisateurEnchere,
			Utilisateur utilisateur, ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noArticleVenduEnchere = noArticleVenduEnchere;
		this.noUtilisateurEnchere = noUtilisateurEnchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}
	
	
	
	//toString
	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", noArticleVenduEnchere=" + noArticleVenduEnchere + ", noUtilisateurEnchere=" + noUtilisateurEnchere
				+ ", utilisateur=" + utilisateur + ", articleVendu=" + articleVendu + "]";
	}
	
	
	
	
}
