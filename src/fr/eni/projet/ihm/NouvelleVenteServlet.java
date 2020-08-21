package fr.eni.projet.ihm;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.dal.DALException;

/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVenteServlet")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager cm = CategorieManager.getInstance();
		try {
			request.setAttribute("categories", cm.selectAll());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/NouvelleVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//récupération de la saisie utilisateur
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		String photo = request.getParameter("photo");
		String prix = request.getParameter("prix");
		Timestamp debutEnchere = Timestamp.valueOf(request.getParameter("debut-enchere")) ;
		Timestamp finEnchere = Timestamp.valueOf(request.getParameter("fin-enchere"));
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		
		//affichage saisie pour vérification
		System.out.println("article :"+article);
		System.out.println("article :"+description);
		System.out.println("article :"+categorie);
		System.out.println("article :"+photo);
		System.out.println("article :"+prix);
		System.out.println("article :"+debutEnchere);
		System.out.println("article :"+finEnchere);
		System.out.println("article :"+rue);
		System.out.println("article :"+cp);
		System.out.println("article :"+ville);
		
		
		//vérification des erreurs formulaire
		int erreur = 0;
		if(article == null || article == "") {
			erreur++;
			}
		
		if(article != null && article.length() >= 50) {
			erreur++;
			}
		
		if(description == null || description == "") {
			erreur++;
		}
		if(description != null && description.length() >= 50) {
			erreur++;
			}
		if(categorie == null || categorie == "") {
			erreur++;
		}
		//TODO liste bdd
		if(categorie != null && categorie.length() >= 50) {
			erreur++;
			}
		//TODO erreur fichier(taille? format?)
		if(photo == null || photo == "") {
			erreur++;
		}
		if(photo != null && photo.length() >= 50) {
			erreur++;
			}
		if(prix == null || prix == "") {
			erreur++;
		}
		if(prix != null && prix.length() >= 9) {
			erreur++;
			}
		//TODO format date?
		if(debutEnchere == null ) {
			erreur++;
		}
		
		//TODO format date?
		if(finEnchere == null) {
			erreur++;
		}
	
		if(rue == null || rue == "") {
			erreur++;
		}
		if(rue != null && rue.length() >= 30) {
			erreur++;
			}
		if(cp == null || cp == "") {
			erreur++;
		}
		if(cp != null && cp.length() == 5) {
			erreur++;
			}
		if(erreur == 0) {
			response.sendRedirect(request.getContextPath() + "/encheres");
		} else {
			response.getWriter().print("Il y a eu une erreur dans la recherche.");
		}
	}

}
