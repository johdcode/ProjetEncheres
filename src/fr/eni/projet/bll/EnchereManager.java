package fr.eni.projet.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.EnchereDAO;

public class EnchereManager {
	
	private static EnchereManager instance;
	private EnchereDAO enchereDAO;
	
	//Appel des managers
	private ArticleVenduManager articleVenduManager = ArticleVenduManager.getInstance();

	
	private EnchereManager() {
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}
	
	public static EnchereManager getInstance() {
		if(instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}
	
	public void insert(Enchere enchere) {
		enchereDAO.insert(enchere);
	}

	public List<Enchere> selectAll(){
		return enchereDAO.selectAll();
	}
	

	public Enchere selectById(int id) {
	return enchereDAO.selectById(id);
	}
	
	public void delete(int id) throws DALException {
		this.enchereDAO.delete(id);
	}
	
	public void update(Enchere enchere) throws DALException {
		this.enchereDAO.update(enchere);
	}
	
	public List<Enchere> selectByArticle(int id) {
		return enchereDAO.selectByArticle(id);
	}
	public List<Enchere> selectByUtilisateur(int id) {
		return enchereDAO.selectByUtilisateur(id);
	}
	
	// recuperer l'enchère la plus haute 
		
	public Enchere getEnchereMax (int idArticle) {
		
			Enchere enchereMax = null;
			List<Enchere> listeEncheresArticle = new ArrayList<Enchere>();
			
				// création de la liste des enchères par raport à l'article
			listeEncheresArticle = instance.selectByArticle(idArticle);
			
				// sélection de l'enchère la plus haute 
			for (int i = 0; i < listeEncheresArticle.size(); i++) {
				try {
					if (listeEncheresArticle.get(i).getMontantEnchere() > articleVenduManager.selectById(idArticle).getMiseAPrix()) {
						enchereMax = listeEncheresArticle.get(i);
					}
				} catch (DALException e) {
					e.printStackTrace();
				};	
			}
			return enchereMax;
		
	
	}
}
