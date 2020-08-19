package fr.eni.projet.bll;

import java.util.List;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	private static UtilisateurManager instance;
	private UtilisateurDAO utilisateurDAO;
	
	private UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	public void insert(Utilisateur utilisateur) {
		utilisateurDAO.insert(utilisateur);
	}

	public List<Utilisateur> selectAll(){
		return utilisateurDAO.selectAll();
	}
	
	
	public boolean authentification(String identifiant, String motDePasse) {
		List <Utilisateur> listeAuthentification = this.utilisateurDAO.selectAll();
		boolean correspondance = false;
		for(Utilisateur utilisateur : listeAuthentification) {
			if(utilisateur.getPseudo().equals(identifiant)&&utilisateur.getMotDePasse().equals(motDePasse)) {
				correspondance = true;
			}
		}
		
		return correspondance;
	}

	public Utilisateur selectById(String identifiant) {
	return utilisateurDAO.selectById(identifiant);
	}
}
