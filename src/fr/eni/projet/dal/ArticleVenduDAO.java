package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Retrait;

public interface ArticleVenduDAO {

	
	ArticleVendu selectById(int noArticle) throws DALException;
	
	List<ArticleVendu> selectAll() throws DALException;
	
	void update(ArticleVendu a, Retrait r) throws DALException;
	
	void delete(int id) throws DALException;

	void insert(ArticleVendu a, Retrait r) throws DALException;

	List<ArticleVendu> selectByRecherche(String recherche) throws DALException;
	
	
}
