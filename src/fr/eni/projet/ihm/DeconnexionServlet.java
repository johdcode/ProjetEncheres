package fr.eni.projet.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * Servlet implementation class DeconnexionServlet
 */
@WebServlet("/deconnexion")
public class DeconnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger deconnexionLogger = (Logger)LoggerFactory.getLogger("fr.eni.projet.ihm.DeconnexionServlet");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		deconnexionLogger.info("Deconnexion utilisateur n°: " +SessionService.getUtilisateurSessionId(request));
		session.invalidate();
		deconnexionLogger.info("Deconnexion réussie");
		response.sendRedirect(request.getContextPath() + "/encheres");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
