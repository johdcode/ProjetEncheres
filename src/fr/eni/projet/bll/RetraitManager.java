package fr.eni.projet.bll;

import java.util.List;

import fr.eni.projet.bo.Retrait;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.RetraitDAO;

public class RetraitManager {

	//Variables
	private static RetraitManager instance;
	private RetraitDAO retraitDAO;
	
	//Constructor
	private RetraitManager() {
		this.retraitDAO = DAOFactory.getRetraitDAO();
	}
	
	//Instance
	public static RetraitManager getInstance() {
		if(instance == null) {
			instance = new RetraitManager();
		}
		return instance;
	}
	
	//Methodes CRUD
		//Insert
	public void insert(Retrait r) throws DALException {
		retraitDAO.insert(r);
	}
		//Select by ID
	public Retrait selectById(int noArticleRetrait) throws DALException {
		return retraitDAO.selectById(noArticleRetrait);	
	}
	
		//Select All
	public List<Retrait> selectAll() throws DALException{
		return retraitDAO.selectAll();
	}
	
		//Update
	public void update(Retrait r) throws DALException {
		retraitDAO.update(r);
	}
	
		//Delete
	public void delete(int noArticleRetrait) throws DALException {
		retraitDAO.delete(noArticleRetrait);
	}
}
