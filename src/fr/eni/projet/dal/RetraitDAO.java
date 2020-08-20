package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Retrait;

public interface RetraitDAO {

	void insert(Retrait r) throws DALException;

	Retrait selectById(int noArticleRetrait) throws DALException;

	List<Retrait> selectAll() throws DALException;

	void update(Retrait r) throws DALException;

	void delete(int noArticleRetrait) throws DALException;
	

}
