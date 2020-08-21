package fr.eni.projet.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Enchere;

/**
 * Servlet implementation class DetailVente
 */
@WebServlet("/DetailVente")
public class DetailVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("utilisateurSession") != null) {
			request.setAttribute("connecte", true);
		}
		// reccupérer l'ID de l'utilisateur
		
		
		// reccuperer l'ID de l'article
		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		System.out.println(idArticle);
		
		ArticleVendu av = new ArticleVendu();
		
		
		//Methode selectionne l'enchere la plus haute en fonction de l'article
		
		
		request.getRequestDispatcher("/WEB-INF/templates/DetailVente.jsp").forward(request, response);
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/templates/DetailVente.jsp").forward(req, resp);
	}

}
