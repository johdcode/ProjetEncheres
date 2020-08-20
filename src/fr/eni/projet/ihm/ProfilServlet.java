package fr.eni.projet.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/profil")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		Utilisateur u = null;
		
		try {
			id = Integer.parseInt(request.getParameter("id"));	
		} catch(NumberFormatException e) {
			System.out.println("L'id entré n'est pas correct");
		}
		
		try {
			u = utilisateurManager.selectById(id);
		}catch(NullPointerException e) {
			System.out.println("L'utilisateur n'a pas été trouvé");
			e.printStackTrace();
		}
		
		if(u != null) {
			request.setAttribute("utilisateur", u);
			request.getRequestDispatcher("/WEB-INF/templates/Profil.jsp").forward(request, response);
		} else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}