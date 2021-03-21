package com.paydiluv.JakartaProject.persistant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import mediatek2021.*;

// classe mono-instance : l'unique instance est connue de la bibliotheque
// via une injection de d�pendance dans son bloc static

public class MediatekData implements PersistentMediatek {
// Jean-Fran�ois Brette 01/01/2018
	static {
		// injection dynamique de la d�pendance dans le package stable mediatek2021
	try {
		Mediatek.getInstance().setData(new MediatekData());
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}
	private Connection conn;
	private final PreparedStatement catalogueStatement;
	private final PreparedStatement getUserStatement;
	private final PreparedStatement getDocumentStatement;
	private final PreparedStatement addNewDocumentStatement;
	private final PreparedStatement removeDocumentStatement;
	{
		assert false;
		removeDocumentStatement = conn.prepareStatement("DELETE FROM document WHERE num=?");
		addNewDocumentStatement = conn.prepareStatement("INSERT INTO document VALUES (?, ?, ?, ?)");
		getDocumentStatement = conn.prepareStatement("Select * from document where num = ?");
		getUserStatement = conn.prepareStatement("Select * from utilisateur where login=? and password= ?");
		catalogueStatement = conn.prepareStatement("Select * from document where cat=?");
	}


	private MediatekData() throws ClassNotFoundException, SQLException {
		String myDriver = "com.mysql.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/jakarta";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, "root", "");
	}

	// renvoie la liste de tous les documents de la biblioth�que par type
	@Override
	public List<Document> catalogue(int type) {
		List<Document> res = new ArrayList<>();
		try {
			catalogueStatement.setInt(1, type);

			ResultSet rs = catalogueStatement.executeQuery();

			while(rs.next()){
				String auteur = rs.getString("auteur");
				String titre = rs.getString("titre");
				int id = rs.getInt("num");
				res.add(new com.paydiluv.JakartaProject.mediaimpl.Document(titre, auteur, type,id));
			}
			catalogueStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}


	// va r�cup�rer le User dans la BD et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		Utilisateur user= null;
		try {
			getUserStatement.setString(1,login);
			getUserStatement.setString(2,password);

			ResultSet rs = getUserStatement.executeQuery();

			user = new com.paydiluv.JakartaProject.mediaimpl.Utilisateur(rs.getString("login"),rs.getString("password"));

			getUserStatement.close();

		}catch (SQLException e){
			e.printStackTrace();
		}
		return user;
	}

	// va r�cup�rer le document de num�ro numDocument dans la BD
	// et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Document getDocument(int numDocument) {
		Document doc= null;
		try {
			getDocumentStatement.setInt(1,numDocument);

			ResultSet rs = getDocumentStatement.executeQuery();

			doc = new com.paydiluv.JakartaProject.mediaimpl.Document(rs.getString("titre"),rs.getString("auteur"), rs.getInt("cat"), rs.getInt("num"));

			getDocumentStatement.close();

		}catch (SQLException e){
			e.printStackTrace();
		}
		return doc;
	}

	// ajoute un nouveau document - exception � d�finir
	@Override
	public void newDocument(int type, Object... args) throws NewDocException {
		if(getDocument((int) args[2]) == null) {
			try {
				addNewDocumentStatement.setString(1, (String) args[0]);
				addNewDocumentStatement.setString(2, (String) args[1]);
				addNewDocumentStatement.setInt(3, type);
				addNewDocumentStatement.setInt(4, (int) args[2]);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}else{ throw new NewDocException("Ce document existe deja");}
	}

	// supprime un document - exception � d�finir
	@Override
	public void suppressDoc(int numDoc) throws SuppressException {
		if(getDocument(numDoc) != null) {
			try {
				removeDocumentStatement.setInt(1, numDoc);
				ResultSet rs = removeDocumentStatement.executeQuery();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}else{ throw new SuppressException("Ce fichier n'existe pas");}
	}

}
