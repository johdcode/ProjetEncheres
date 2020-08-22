package fr.eni.projet.ihm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;

public class SessionService {
	
	public static Utilisateur checkUtilisateurSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utilisateur u = null;
		
		if((session.getAttribute("utilisateurSessionId")) != null && (session.getAttribute("utilisateurSessionId") != "")) {			
			u = UtilisateurManager.getInstance().selectById((Integer)session.getAttribute("utilisateurSessionId"));
		}
		if(u != null) {
			request.setAttribute("utilisateurSession", u);
//			request.setAttribute("connecte", true);
		}
		return u;
	}
	
	public static void setUtilisateurSessionId(HttpServletRequest request, int id) {
		HttpSession session = request.getSession();
		session.setAttribute("utilisateurSessionId", id);
	}
	
	public static String getUtilisateurSessionId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("utilisateurSessionId");
	}
}
