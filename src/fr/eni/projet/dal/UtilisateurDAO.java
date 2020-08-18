package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Utilisateur;

public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur);
	public List<Utilisateur> selectAll();
}
