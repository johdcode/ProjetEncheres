package fr.eni.projet.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;

/**
 * Servlet implementation class Tests
 */
@WebServlet("/Tests")
public class Tests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager um = UtilisateurManager.getInstance();
	//	System.out.println(um.authentification("jo", "motDePasse"));
	System.out.println(um.selectAll());
		//System.out.println(um.selectById("jo"));
	//	Utilisateur u = new Utilisateur("kim", "Kim", "Maroé", "kim@mail.com", "0707070707", "Rue des lilas", "44200", "Nantes", "motDePasse", 10.0f, false);
		//um.insert(u);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
