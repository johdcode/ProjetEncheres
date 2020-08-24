package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Enchere;

public interface EnchereDAO {
	public void insert(Enchere enchere);
	public List<Enchere> selectAll();
	public void update(Enchere enchere) throws DALException;
	void delete(int id) throws DALException;
	Enchere selectById(int id);
	List<Enchere> selectByArticle(int id);
}
