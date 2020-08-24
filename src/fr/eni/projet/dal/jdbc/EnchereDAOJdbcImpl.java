package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	private final String INSERT = "INSERT INTO encheres (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES (?,?,?,?);";
	private final String SELECT_ALL = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur from encheres;";
	private final String SELECT_BY_ID = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur from encheres where no_enchere=?;";
	private final String UPDATE = "UPDATE encheres set date_enchere=?, montant_enchere=?, no_article=?, no_utilisateur=? where no_enchere=?;";
	private final String DELETE = "DELETE FROM encheres WHERE no_enchere =?;";
	private final String SELECT_BY_ARTICLE = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur from encheres where no_article=?;";
	
	@Override
	public void insert(Enchere enchere) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try(Connection connection = ConnectionProvider.getConnection()) {
			pstmt = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			pstmt.setTimestamp(1, java.sql.Timestamp.valueOf(enchere.getDateEnchere()));
			pstmt.setInt(2, enchere.getMontantEnchere());
			pstmt.setInt(3, enchere.getNoArticleVenduEnchere());
			pstmt.setInt(4, enchere.getNoUtilisateurEnchere());
			
			
			int nbLignes = pstmt.executeUpdate();
			if (nbLignes == 1) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					enchere.setNoEnchere(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
//			BusinessException.addCodeErreur(DALJdbcCodeError.DAL_REPAS_INSERT_ERROR);
//			throw new BusinessException();
		} finally{
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	@Override
	public List<Enchere> selectAll() {
		List<Enchere> encheres = new ArrayList<Enchere>();
		
		try ( Connection connection = ConnectionProvider.getConnection()){
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				Enchere enchere = new Enchere(rs.getInt("no_enchere"),
						rs.getTimestamp("date_enchere").toLocalDateTime(), 
						rs.getInt("montant_enchere"),
						rs.getInt("no_article"),
						rs.getInt("no_utilisateur"));
				encheres.add(enchere);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encheres;
		
	}

	@Override
	public void update(Enchere enchere) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
			
			pstmt.setTimestamp(1, java.sql.Timestamp.valueOf(enchere.getDateEnchere()));
			pstmt.setInt(2, enchere.getMontantEnchere());
			pstmt.setInt(3, enchere.getNoArticleVenduEnchere());
			pstmt.setInt(4, enchere.getNoUtilisateurEnchere());
			pstmt.setInt(5, enchere.getNoEnchere());
			
			
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Update Utilisateur FAIL", e);
		}
	}

	@Override
	public void delete(int id) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			//Desactiver les foreign keys
			Statement desactiveEnchere = cnx.createStatement();
			desactiveEnchere.executeUpdate("ALTER TABLE encheres NOCHECK CONSTRAINT encheres_utilisateur_fk;");
			Statement desactiveArticlesVendus = cnx.createStatement();
			desactiveArticlesVendus.executeUpdate("ALTER TABLE articles_vendus NOCHECK CONSTRAINT ventes_utilisateur_fk;");
			
			//Executer la suppresion
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
			System.out.println("ok");
			//Reactiver les foreign keys
			Statement activeEnchere = cnx.createStatement();
			activeEnchere.executeUpdate("ALTER TABLE encheres CHECK CONSTRAINT encheres_utilisateur_fk;");
			Statement activeArticlesVendus = cnx.createStatement();
			activeArticlesVendus.executeUpdate("ALTER TABLE articles_vendus CHECK CONSTRAINT ventes_utilisateur_fk;");
			
			
		} catch (SQLException e) {
			throw new DALException("Delete Enchere FAIL - ", e);
		}
	}

	@Override
	public Enchere selectById(int id) {
		Enchere enchere = null;
		
		try (Connection connection = ConnectionProvider.getConnection()){
			
		PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ID);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
		enchere = new Enchere(rs.getInt("no_enchere"),
				rs.getTimestamp("date_enchere").toLocalDateTime(), 
				rs.getInt("montant_enchere"),
				rs.getInt("no_article"),
				rs.getInt("no_utilisateur"));
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enchere;
	}

	@Override
	public List<Enchere> selectByArticle(int id) {
			List<Enchere> encheres = new ArrayList<Enchere>();
		
		try ( Connection connection = ConnectionProvider.getConnection()){
			
			PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ARTICLE);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Enchere enchere = new Enchere(rs.getInt("no_enchere"),
						rs.getTimestamp("date_enchere").toLocalDateTime(), 
						rs.getInt("montant_enchere"),
						rs.getInt("no_article"),
						rs.getInt("no_utilisateur"));
				encheres.add(enchere);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encheres;
	}
}
