package fr.eni.projet.bll;

import java.util.List;

import fr.eni.projet.bo.ArticleVendu;
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
	
	public void insert(ArticleVendu a, int noUtilisteur, int noCategorie) throws DALException {
			articleVenduDAO.insert(a, noUtilisteur, noCategorie);
	}
	public ArticleVendu selectById(int noArticle) throws DALException {
		return articleVenduDAO.selectById(noArticle);
		
	}
	
	public List<ArticleVendu> selectAll() throws DALException{
		return articleVenduDAO.selectAll();
	}
	
	public void update(ArticleVendu a) throws DALException {
		articleVenduDAO.update(a);
	}
	
	public void delete(int id) throws DALException {
		articleVenduDAO.delete(id);
	}

}
