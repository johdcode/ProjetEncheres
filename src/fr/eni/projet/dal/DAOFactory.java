package fr.eni.projet.dal;

import fr.eni.projet.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.projet.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.projet.dal.jdbc.UtilisateurDAOJdbcImpl;


public class DAOFactory {
	
	//Utilisateur
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	
	//ArticleVendu
	
	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOJdbcImpl();
	}
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}

}
