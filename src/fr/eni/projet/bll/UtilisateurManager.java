package fr.eni.projet.bll;

import java.util.List;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;
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
	
	
	public Utilisateur authentification(String identifiant, String motDePasse) {
		List <Utilisateur> listeAuthentification = this.utilisateurDAO.selectAll();
		for(Utilisateur utilisateur : listeAuthentification) {
			if((utilisateur.getPseudo().equals(identifiant) || utilisateur.getEmail().equals(identifiant)) && utilisateur.getMotDePasse().equals(motDePasse)) {
				return utilisateur;
			}
		}
		return null;
	}

	public Utilisateur selectById(int identifiant) {
		return utilisateurDAO.selectById(identifiant);
	}
	
	public void delete(int id) throws DALException {
		this.utilisateurDAO.delete(id);
	}
	
	public void update(Utilisateur utilisateur) throws DALException {
		this.utilisateurDAO.update(utilisateur);
	}
}
