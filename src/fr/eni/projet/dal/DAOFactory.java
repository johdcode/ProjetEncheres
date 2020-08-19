package fr.eni.projet.dal;

import fr.eni.projet.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.projet.dal.jdbc.UtilisateurDAOJdbcImpl;
import fr.eni.projet.bo.ArticleVendu;

public class DAOFactory {
	
	//Utilisateur
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	
	//ArticleVendu
	
	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOJdbcImpl();
	}
}
