package fr.eni.projet.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.bll.ArticleVenduManager;
import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.dal.DALException;

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
//		HttpSession session = request.getSession();
//		if(session.getAttribute("utilisateurSession") != null) {
//			request.setAttribute("connecte", true);
//		}
//		Utilisateur u = SessionService.checkUtilisateurSession(request, response);
		
		SessionService ss = new SessionService();
		Utilisateur u = ss.checkUtilisateurSession(request, response);
		
		// liste des catégories
		List <Categorie> listeCategorie = new ArrayList<Categorie>();
		CategorieManager cm = CategorieManager.getInstance();
		try {
			listeCategorie = cm.selectAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listeCategorie", listeCategorie);
		
		
		// liste fictive pour mise en place affichage des articles
				// à mettre en jour ensuite avec la liste générée par la recherche
		
		List <ArticleVendu> listeArticle = new ArrayList<ArticleVendu>();
		ArticleVenduManager avm = ArticleVenduManager.getInstance();
		
		try {
			listeArticle = avm.selectAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listeArticle", listeArticle);
		
		
		
		
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
