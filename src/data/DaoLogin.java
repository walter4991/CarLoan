package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import presentation.controller.ApplicationController;

/**
 * Classe che permette di manipolare i dati relativi alle credenziali di un cliente o amministratore
 * @author Sergio
 *
 */
public class DaoLogin extends Dao {

	private final String QUERY_LOGIN = "SELECT * FROM Credenziali WHERE username = ? AND password = ?;";
	private final String QUERY_USERNAME = "SELECT * FROM Credenziali WHERE username = ?;";
	private final String LOGIN_LOGOUT = "UPDATE Credenziali   SET loggato=?  WHERE username = ? ;";
	
	public DaoLogin() {
		super();
	}

	/**
	 * Permette di cercare un utente tramite le sue credenziali
	 * @return
	 * 		1 se è un cliente
	 * 		0 se è un amministratore
	 * 		-1 se non è presente del database
	 * 	
	 */
	public int login() {
		int tipo = -1;

		PreparedStatement query;
		PreparedStatement login;
		
		try {
		  
			query = connessione.prepareStatement(QUERY_LOGIN);
			login= connessione.prepareStatement(LOGIN_LOGOUT);
			
			  
			login.setString(1, "1");
			 
			login.setString(2, (String) ApplicationController.params.get("username"));
		
			
		
			 
			query.setString(1, (String) ApplicationController.params.get("username"));
			query.setString(2, (String) ApplicationController.params.get("password"));
			login.execute();
			ResultSet results = query.executeQuery();
			if (results.next()) {
				tipo = results.getInt("tipo");

			} 
		} catch (SQLException e) {	 

			 e.printStackTrace();
		}

		return tipo;
	}

	/**
	 * Permette di cercare l'username di un utente
	 * 
	 * @param username
	 * 		username dell'utente
	 * @return
	 * 		il risultato della ricerca
	 */
	public boolean usernameEsistente(String username) {
		PreparedStatement query;
		boolean esistente=false;
		try {

			query = connessione.prepareStatement(QUERY_USERNAME);

			query.setString(1, username);
	 
			ResultSet results = query.executeQuery();

			
				if (results.next()) {
			esistente= true;

			} else {
				esistente= false;}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esistente;
	}
	
	/**
	 * Permette di effetture il logout dal sistema settando una variabile nel DB
	 */
	public void logout() {

		PreparedStatement logout;

		try {

			logout = connessione.prepareStatement(LOGIN_LOGOUT);

			logout.setString(1, "0");
			logout.setString(2,
					(String) ApplicationController.params.get("username"));

			logout.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
