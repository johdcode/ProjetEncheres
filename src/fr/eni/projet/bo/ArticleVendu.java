package fr.eni.projet.bo;


import java.sql.Timestamp;
import java.util.List;

public class ArticleVendu {
	
	// Variables
	int noArticle;
	String nomArticle;
	String description;
	Timestamp dateDebutEnchere;
	Timestamp dateFinEnchere;
	int miseAPrix;
	int prixVente;
	int noUtilisateurArticle;
	int noCategorieArticle;
	
	
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

	public Timestamp getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(Timestamp dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public Timestamp getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(Timestamp dateFinEnchere) {
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

	public int getNoUtilisateurArticle() {
		return noUtilisateurArticle;
	}

	public void setNoUtilisateurArticle(int noUtilisateurArticle) {
		this.noUtilisateurArticle = noUtilisateurArticle;
	}

	public int getNoCategorieArticle() {
		return noCategorieArticle;
	}

	public void setNoCategorieArticle(int noCategorieArticle) {
		this.noCategorieArticle = noCategorieArticle;
	}

	public void setListEncheres(List<Enchere> listEncheres) {
		this.listEncheres = listEncheres;
	}

	//Constructors
	public ArticleVendu() {
		super();
	}

	public ArticleVendu(String nomArticle, String description, Timestamp dateDebutEnchere,
			Timestamp dateFinEnchere, int miseAPrix, int prixVente, Enum<EnumEtatVente> etatVente) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}

	

	public ArticleVendu(String nomArticle, String description, Timestamp dateDebutEnchere, Timestamp dateFinEnchere,
			int miseAPrix, int prixVente, int noUtilisateurArticle, int noCategorieArticle,
			Enum<EnumEtatVente> etatVente, Utilisateur utilisateur, Categorie categorie, Retrait retrait,
			List<Enchere> listEncheres) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.noUtilisateurArticle = noUtilisateurArticle;
		this.noCategorieArticle = noCategorieArticle;
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
				+ miseAPrix + ", prixVente=" + prixVente + ", noUtilisateurArticle=" + noUtilisateurArticle
				+ ", noCategorieArticle=" + noCategorieArticle + ", etatVente=" + etatVente + ", utilisateur="
				+ utilisateur + ", categorie=" + categorie + ", retrait=" + retrait + ", listEncheres=" + listEncheres
				+ "]";
	}

		
	
	
	
	
	
	
	
}
