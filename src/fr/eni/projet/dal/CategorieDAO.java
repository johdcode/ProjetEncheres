package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Categorie;

public interface CategorieDAO {

	void insert(Categorie c) throws DALException;

	Categorie selectById(int noCategorie) throws DALException;

	List<Categorie> selectAll() throws DALException;

	void update(Categorie c) throws DALException;

	void delete(int noCategorie) throws DALException;
	
	

}
