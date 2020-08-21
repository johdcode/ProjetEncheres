package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.bll.ArticleVenduManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	private final String SELECT_BY_EMAIL = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur from utilisateurs where email=?;";
	private final String INSERT = "INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String SELECT_ALL = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur from utilisateurs;";
	private final String SELECT_BY_ID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur from utilisateurs where no_utilisateur=?;";
	private final String UPDATE = "UPDATE Utilisateurs set pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=? where no_utilisateur=?;";

	@Override
	public void insert(Utilisateur utilisateur) {
		PreparedStatement req = null;
		ResultSet rs = null;
		
		try(Connection connection = ConnectionProvider.getConnection()) {
			req = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			req.setString(1, utilisateur.getPseudo());
			req.setString(2, utilisateur.getNom());
			req.setString(3, utilisateur.getPrenom());
			req.setString(4, utilisateur.getEmail());
			req.setString(5, utilisateur.getTelephone());
			req.setString(6, utilisateur.getRue());
			req.setString(7, utilisateur.getCodePostal());
			req.setString(8, utilisateur.getVille());
			req.setString(9, utilisateur.getMotDePasse());
			req.setFloat(10, utilisateur.getCredit());
			req.setBoolean(11, utilisateur.isAdministrateur());
			
			int nbLignes = req.executeUpdate();
			if (nbLignes == 1) {
				rs = req.getGeneratedKeys();
				if (rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
//			BusinessException.addCodeErreur(DALJdbcCodeError.DAL_REPAS_INSERT_ERROR);
//			throw new BusinessException();
		} finally{
			try {
				if(req != null) {
					req.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public List<Utilisateur> selectAll(){
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		
		try ( Connection connection = ConnectionProvider.getConnection()){
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo").trim(), 
						rs.getString("nom").trim(), rs.getString("prenom").trim(), rs.getString("email").trim(),rs.getString("telephone").trim(),
						rs.getString("rue").trim(),rs.getString("code_postal").trim(),rs.getString("ville").trim(),rs.getString("mot_de_passe").trim(),
						rs.getFloat("credit"),rs.getBoolean("administrateur"));
				utilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateurs;
		
	}
	@Override
	public Utilisateur selectById(int identifiant) {
		Utilisateur utilisateur = null;
		
		try (Connection connection = ConnectionProvider.getConnection()){
			
		PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ID);
		pstmt.setInt(1, identifiant);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
		utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo").trim(), 
					rs.getString("nom").trim(), rs.getString("prenom").trim(), rs.getString("email").trim(),rs.getString("telephone").trim(),
					rs.getString("rue").trim(),rs.getString("code_postal").trim(),rs.getString("ville").trim(),rs.getString("mot_de_passe").trim(),
					rs.getFloat("credit"),rs.getBoolean("administrateur"));
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateur;
		
	}
	@Override
	public void update(Utilisateur utilisateur) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
			
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setFloat(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.isAdministrateur());
			pstmt.setInt(12, utilisateur.getNoUtilisateur());
			
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Update Utilisateur FAIL", e);
		}
		}	
	
	@Override
	public void delete(Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
			pstmt.setString(1, "désactivé");
			pstmt.setString(2, "x");
			pstmt.setString(3, "x");
			pstmt.setString(4, "x");
			pstmt.setString(5, "x");
			pstmt.setString(6, "x");
			pstmt.setString(7, "x");
			pstmt.setString(8, "x");
			pstmt.setString(9, "x");
			pstmt.setFloat(10, 0);
			pstmt.setBoolean(11, utilisateur.isAdministrateur());
			pstmt.setInt(12, utilisateur.getNoUtilisateur());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new DALException("Delete Utilisateur FAIL - ", e);
		}
	}
	@Override
	public Utilisateur selectByEmail(String email) {
Utilisateur utilisateur = null;
		
		try (Connection connection = ConnectionProvider.getConnection()){
			
		PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_EMAIL);
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
		utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo").trim(), 
					rs.getString("nom").trim(), rs.getString("prenom").trim(), rs.getString("email").trim(),rs.getString("telephone").trim(),
					rs.getString("rue").trim(),rs.getString("code_postal").trim(),rs.getString("ville").trim(),rs.getString("mot_de_passe").trim(),
					rs.getFloat("credit"),rs.getBoolean("administrateur"));
		}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return utilisateur;
	}
}
