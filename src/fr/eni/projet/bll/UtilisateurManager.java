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
	
	
	public boolean authentification(String identifiant, String motDePasse) {
		List <Utilisateur> listeAuthentification = this.utilisateurDAO.selectAll();
		boolean correspondance = false;
		for(Utilisateur utilisateur : listeAuthentification) {
			System.out.println(utilisateur.getPseudo());
			System.out.println(utilisateur.getMotDePasse());
	
			if(utilisateur.getPseudo().equals(identifiant)&&utilisateur.getMotDePasse().equals(motDePasse)) {
				correspondance = true;
			}
		}
		
		return correspondance;
	}

	public Utilisateur selectById(int identifiant) {
	return utilisateurDAO.selectById(identifiant);
	}
	
	public void delete(Utilisateur utilisateur) throws DALException {
		this.utilisateurDAO.delete(utilisateur);
	}
	
	public void update(Utilisateur utilisateur) throws DALException {
		this.utilisateurDAO.update(utilisateur);
	}
}
