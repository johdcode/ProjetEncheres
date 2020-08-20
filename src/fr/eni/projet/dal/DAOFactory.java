package fr.eni.projet.dal;

import fr.eni.projet.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.projet.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.projet.dal.jdbc.RetraitDAOJdbcImpl;
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
	
	//Retrait
	
	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOJdbcImpl();
		}
	
	//Categorie
	
		public static CategorieDAO getCategorieDAO() {
			return new CategorieDAOJdbcImpl();
			}
}
