package fr.eni.projet.bo;

import java.time.LocalDate;

public class Enchere {
	//Variable
	LocalDate dateEnchère;
	int montantEnchere;
	Utilisateur utilisateur;
	ArticleVendu articleVendu;
	
	// Getter & Setter
	public LocalDate getDateEnchère() {
		return dateEnchère;
	}
	public void setDateEnchère(LocalDate dateEnchère) {
		this.dateEnchère = dateEnchère;
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
	public Enchere(LocalDate dateEnchère, int montantEnchere) {
		super();
		this.dateEnchère = dateEnchère;
		this.montantEnchere = montantEnchere;
	}
	public Enchere(LocalDate dateEnchère, int montantEnchere, Utilisateur utilisateur, ArticleVendu articleVendu) {
		super();
		this.dateEnchère = dateEnchère;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}
	
	//toString
	@Override
	public String toString() {
		return "Enchere [dateEnchère=" + dateEnchère + ", montantEnchere=" + montantEnchere + ", utilisateur="
				+ utilisateur + ", articleVendu=" + articleVendu + "]";
	}
	
	
	
	
}
