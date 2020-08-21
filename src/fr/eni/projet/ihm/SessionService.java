package fr.eni.projet.ihm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;

public class SessionService {
	
	public Utilisateur checkUtilisateurSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Utilisateur u = null;
		
		if((session.getAttribute("utilisateurId")) != null && (session.getAttribute("utilisateurId") != "")) {			
			u = UtilisateurManager.getInstance().selectById((Integer)session.getAttribute("utilisateurId"));
		}
		if(u != null) {
//			request.setAttribute("connecte", true);
			request.setAttribute("utilisateurSession", u);
		}
		return u;
	}
	
	public void setUtilisateurSession(HttpServletRequest request, HttpServletResponse response, int id) {
		HttpSession session = request.getSession();
		session.setAttribute("utilisateurId", id);
	}
}
