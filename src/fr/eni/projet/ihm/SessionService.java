package fr.eni.projet.ihm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;

public class SessionService {
	
	/**
	 * Récuperer l'utisateur dont l'id stockée en session correspond si elle existe,
	 * et le place comme attribut de la requête
	 * 
	 * @param request
	 * @return utilisateur
	 */
	public static Utilisateur checkUtilisateurSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utilisateur u = null;
		
		if((session.getAttribute("utilisateurSessionId")) != null && (session.getAttribute("utilisateurSessionId") != "")) {			
			u = UtilisateurManager.getInstance().selectById((Integer)session.getAttribute("utilisateurSessionId"));
		}
		if(u != null) {
			request.setAttribute("utilisateurSession", u);
//			
		}
		return u;
	}
	
	/**
	 * Démarre une session: définie l'id de l'utilisateur dans la session
	 * 
	 * @param request
	 * @param id
	 */
	public static void setUtilisateurSessionId(HttpServletRequest request, int id) {
		HttpSession session = request.getSession();
		session.setAttribute("utilisateurSessionId", id);
	}
	
	/**
	 * Recupère l'id stocké en session
	 * 
	 * @param request
	 * @return id
	 */
	public static String getUtilisateurSessionId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return String.valueOf((int)session.getAttribute("utilisateurSessionId"));
	}
}
