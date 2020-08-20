package fr.eni.projet.bll;

import java.util.List;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.EnchereDAO;
import fr.eni.projet.dal.UtilisateurDAO;

public class EnchereManager {
	
	private static EnchereManager instance;
	private EnchereDAO enchereDAO;
	
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
}
