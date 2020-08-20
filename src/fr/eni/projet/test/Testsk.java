package fr.eni.projet.test;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.projet.bll.EnchereManager;
import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.dal.DALException;


/**
 * Servlet implementation class Tests
 */
@WebServlet("/Testsk")
public class Testsk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//		EnchereManager em = EnchereManager.getInstance();
//		Enchere e = new Enchere(new Timestamp(2020-8-20), 12,2,6);
//		em.insert(e);
//		e.setNoArticleVenduEnchere(4);
//		try {
//			em.update(e);
//		} catch (DALException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
////		try {
////			em.delete(1);
////		} catch (DALException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		}
//		System.out.println(em.selectAll());
//		System.out.println(em.selectById(2));
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
