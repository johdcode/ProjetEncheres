package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.ArticleVendu;

public interface ArticleVenduDAO {

	
	public abstract void insert(ArticleVendu a, int noUtilisteur, int noCategorie) throws DALException;
	
	public abstract ArticleVendu selectById(int noArticle) throws DALException;
	
	public abstract List<ArticleVendu> selectAll() throws DALException;
	
	public abstract void update(ArticleVendu a) throws DALException;
	
	public abstract void delete(int id) throws DALException;
	
	
}
