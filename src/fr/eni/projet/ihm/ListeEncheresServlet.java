package fr.eni.projet.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListeEncheresServlet
 */
@WebServlet("/encheres")
public class ListeEncheresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("utilisateurSession") != null) {
			request.setAttribute("connecte", true);
		}
		
		request.getRequestDispatcher("/WEB-INF/templates/ListeEncheres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recherche = request.getParameter("recherche");
		String categorie = request.getParameter("categorie");
		
//		String achat = request.getParameter("achat");
		String type = request.getParameter("type");
		String encheresOuvertes = request.getParameter("encheres_ouvertes");
		String mesEncheres = request.getParameter("mes_encheres");
		String mesEncheresRemportees = request.getParameter("mes_encheres_remportees");
		
//		String vente = request.getParameter("vente");
		String ventesEnCours = request.getParameter("ventes_en_cours");
		String ventesNonDebutees = request.getParameter("ventes_non_debutees");
		String ventesTerminees = request.getParameter("ventes_terminees");
		
		System.out.println("recherche : " + recherche);
		System.out.println("categorie : " + categorie);
		System.out.println("achat : " + type);
		System.out.println("encheresOuvertes : " + encheresOuvertes);
		System.out.println("mesEncheres : " + mesEncheres);
		System.out.println("mesEncheresRemportees : " + mesEncheresRemportees);
		System.out.println("vente : " + type);
		System.out.println("ventesEnCours : " + ventesEnCours);
		System.out.println("ventesNonDebutees : " + ventesNonDebutees);
		System.out.println("ventesTerminees : " + ventesTerminees);

		int erreur = 0;

		if(recherche == null || recherche == "") {
			erreur++;
		}
		if(recherche != null && recherche.length() >= 30) {
			erreur++;
		}
		
		if(categorie == null || categorie == "") {
			erreur++;
		}
		if(categorie != null && categorie.length() >= 30) {
			erreur++;
		}
		
		if(type == null || type == "") {
			erreur++;
		}
		if(type != null && type.length() >= 30) {
			erreur++;
		}
		
		if(encheresOuvertes == null || encheresOuvertes == "") {
			erreur++;
		}
		if(encheresOuvertes != null && encheresOuvertes.length() >= 30) {
			erreur++;
		}
		
		if(mesEncheres == null || mesEncheres == "") {
			erreur++;
		}
		if(mesEncheres != null && mesEncheres.length() >= 30) {
			erreur++;
		}
		
		if(mesEncheresRemportees == null || mesEncheresRemportees == "") {
			erreur++;
		}
		if(mesEncheresRemportees != null && mesEncheresRemportees.length() >= 30) {
			erreur++;
		}
		
		if(ventesEnCours == null || ventesEnCours == "") {
			erreur++;
		}
		if(ventesEnCours != null && ventesEnCours.length() >= 30) {
			erreur++;
		}
		
		if(ventesNonDebutees == null || ventesNonDebutees == "") {
			erreur++;
		}
		if(ventesNonDebutees != null && ventesNonDebutees.length() >= 30) {
			erreur++;
		}
		
		if(ventesTerminees == null || ventesTerminees == "") {
			erreur++;
		}
		if(ventesTerminees != null && ventesTerminees.length() >= 30) {
			erreur++;
		}
		
		if(erreur == 0) {
			response.sendRedirect(request.getContextPath() + "/encheres");
		} else {
			response.getWriter().print("Il y a eu une erreur dans la recherche.");
		}
	}

}
