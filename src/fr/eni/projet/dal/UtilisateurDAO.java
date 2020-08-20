package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Utilisateur;

public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur);
	public List<Utilisateur> selectAll();
	public void update(Utilisateur utilisateur) throws DALException;
	void delete(int id) throws DALException;
	Utilisateur selectById(int identifiant);
	
}
