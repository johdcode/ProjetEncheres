package fr.eni.projet.bo;

import java.time.LocalDate;

public class Enchere {
	//Variable
	int noEnchere;
	LocalDate dateEnchere;
	int montantEnchere;
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
	
	
	//toString
	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", utilisateur=" + utilisateur + ", articleVendu=" + articleVendu + "]";
	}
	
	
	
	
}
