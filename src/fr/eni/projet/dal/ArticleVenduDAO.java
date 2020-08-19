package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.ArticleVendu;

public interface ArticleVenduDAO {

	
	void insert(ArticleVendu a, int noUtilisteur, int noCategorie) throws DALException;
	
	ArticleVendu selectById(int noArticle) throws DALException;
	
	List<ArticleVendu> selectAll() throws DALException;
	
	void update(ArticleVendu a) throws DALException;
	
	void delete(int id) throws DALException;
	
	
}
