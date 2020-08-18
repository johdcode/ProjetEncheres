package fr.eni.projet.bo;

import java.time.LocalDate;
import java.util.List;

public class ArticleVendu {
	
	// Variables
	int noArticle;
	String nomArticle;
	String description;
	LocalDate dateDebutEnchere;
	LocalDate dateFinEnchere;
	int miseAPrix;
	int prixVente;
	
	Enum<EnumEtatVente> etatVente;
	
	Utilisateur utilisateur;
	Categorie categorie;
	Retrait retrait;
	
	List <Enchere> listEncheres;
	
	//Getters et Setters
	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(LocalDate dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public LocalDate getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(LocalDate dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	public List<Enchere> getListEncheres() {
		return listEncheres;
	}
	
	public Enum<EnumEtatVente> getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(Enum<EnumEtatVente> etatVente) {
		this.etatVente = etatVente;
	}

	//Constructors
	public ArticleVendu() {
		super();
	}

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEnchere,
			LocalDate dateFinEnchere, int miseAPrix, int prixVente, Enum<EnumEtatVente> etatVente) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEnchere,
			LocalDate dateFinEnchere, int miseAPrix, int prixVente, Enum<EnumEtatVente> etatVente,
			Utilisateur utilisateur, Categorie categorie, Retrait retrait, List<Enchere> listEncheres) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
		this.retrait = retrait;
		this.listEncheres = listEncheres;
	}

	
	//toString
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEnchere=" + dateDebutEnchere + ", dateFinEnchere=" + dateFinEnchere + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", utilisateur=" + utilisateur
				+ ", categorie=" + categorie + ", retrait=" + retrait + ", listEncheres=" + listEncheres + "]";
	}

		
	
	
	
	
	
	
	
}
