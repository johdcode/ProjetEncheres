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

	List<ArticleVendu> selectByEncheresOuvertes(int id) throws DALException;

	List<ArticleVendu> selectByMesEncheres(int id) throws DALException;

	List<ArticleVendu> selectByMesEncheresRemportees(int id) throws DALException;

	List<ArticleVendu> selectByMesVentesEnCours(int id) throws DALException;

	List<ArticleVendu> selectByMesVentesNonDebutees(int id) throws DALException;

	List<ArticleVendu> selectByMesVentesTerminees(int id) throws DALException;
	
	
}
