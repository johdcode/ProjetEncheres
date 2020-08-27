package fr.eni.projet.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;

/**
 * Servlet implementation class SupprimerMonCompteServlet
 */
@WebServlet("/supprimer-mon-compte")
public class SupprimerMonCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UtilisateurManager um = UtilisateurManager.getInstance();
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("utilisateurSessionId", SessionService.getUtilisateurSessionId(request));
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/templates/SupprimerCompte.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//récupération de l'utilisateur via le paramètre envoyé en url
		Utilisateur utilisateurASupprimer = um.selectById(Integer.parseInt(SessionService.getUtilisateurSessionId(request)));
		
		//Suppression définitive de l'utilisateur
		try {
			um.delete(utilisateurASupprimer);
		} catch (DALException e) {
		
			e.printStackTrace();
		}
		request.getSession().invalidate();
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/templates/ListeEncheres.jsp");
		rd.forward(request, response);
	}

}
