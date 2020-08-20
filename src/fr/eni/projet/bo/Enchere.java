package fr.eni.projet.bo;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Enchere {
	//Variable
	int noEnchere;
	Timestamp dateEnchere;
	int montantEnchere;
	int noArticleVenduEnchere;
	int noUtilisateurEnchere;
	
	// Getter & Setter
	public Timestamp getDateEnchere() {
		return dateEnchere;
	}
	public int getNoEnchere() {
		return noEnchere;
	}
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	public void setDateEnchere(Timestamp dateEnchère) {
		this.dateEnchere = dateEnchère;
	}
	public int getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
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
	public Enchere(Timestamp dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	
	public Enchere(Timestamp dateEnchere, int montantEnchere, int noArticleVenduEnchere, int noUtilisateurEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noArticleVenduEnchere = noArticleVenduEnchere;
		this.noUtilisateurEnchere = noUtilisateurEnchere;
	}
	
	public Enchere(int noEnchere, Timestamp dateEnchere, int montantEnchere, int noArticleVenduEnchere,
			int noUtilisateurEnchere) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noArticleVenduEnchere = noArticleVenduEnchere;
		this.noUtilisateurEnchere = noUtilisateurEnchere;
	}
	//toString
	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", noArticleVenduEnchere=" + noArticleVenduEnchere + ", noUtilisateurEnchere=" + noUtilisateurEnchere
				+ ", utilisateur="  + ", articleVendu=" + "]";
	}
	
	
	
	
}
