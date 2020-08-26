package fr.eni.projet.bll;

import java.util.List;

import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.dal.ArticleVenduDAO;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;

public class ArticleVenduManager {

	private static ArticleVenduManager instance;
	private ArticleVenduDAO articleVenduDAO;
	
	private ArticleVenduManager() {
		this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
	}
	
	public static ArticleVenduManager getInstance() {
		if(instance == null) {
			instance = new ArticleVenduManager();
		}
		return instance;
	}
	
	public void insert(ArticleVendu a, Retrait r) throws DALException {
			articleVenduDAO.insert(a, r);
	}
	public ArticleVendu selectById(int noArticle) throws DALException {
		return articleVenduDAO.selectById(noArticle);
		
	}
	public List<ArticleVendu> selectByRecherche(String recherche) throws DALException {
		return articleVenduDAO.selectByRecherche(recherche);
		
	}
	
	public List<ArticleVendu> selectAll() throws DALException{
		return articleVenduDAO.selectAll();
	}
	
	public void update(ArticleVendu a, Retrait r) throws DALException {
		articleVenduDAO.update(a, r);
	}
	
	public void delete(int id) throws DALException {
		articleVenduDAO.delete(id);
	}

	

}
