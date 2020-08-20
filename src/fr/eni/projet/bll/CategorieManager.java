package fr.eni.projet.bll;

import java.util.List;

import fr.eni.projet.bo.Categorie;
import fr.eni.projet.dal.CategorieDAO;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;

public class CategorieManager {

	//Variables
		private static CategorieManager instance;
		private CategorieDAO categorieDAO;
		
		//Constructor
		private CategorieManager() {
			this.categorieDAO = DAOFactory.getCategorieDAO();
		}
		
		//Instance
		public static CategorieManager getInstance() {
			if(instance == null) {
				instance = new CategorieManager();
			}
			return instance;
		}
		
		//Methodes CRUD
			//Insert
		public void insert(Categorie c) throws DALException {
			categorieDAO.insert(c);
		}
			//Select by ID
		public Categorie selectById(int noCategorie) throws DALException {
			return categorieDAO.selectById(noCategorie);	
		}
		
			//Select All
		public List<Categorie> selectAll() throws DALException{
			return categorieDAO.selectAll();
		}
		
			//Update
		public void update(Categorie r) throws DALException {
			categorieDAO.update(r);
		}
		
			//Delete
		public void delete(int noCategorie) throws DALException {
			categorieDAO.delete(noCategorie);
		}
	
}
