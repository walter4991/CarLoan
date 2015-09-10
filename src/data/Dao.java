package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe che deve essere concretizzata da tutte le altre per prelevare modificare eliminare dati 
 * dal data source. Contiene le credenziali per l'accesso al database.
 * @author Sergio
 *
 */
public abstract class Dao {

	protected Connection connessione;

	/**
	 * Costruttore che effettua la connessione.
	 */
	public Dao() {
		connetti();
	}

	/**
	 * Metodo che prelevando le credenziali di accesso esegue la connessione al database.
	 */
	private void connetti() {

		// new com.mysql.jdbc.Driver();
		String url = "jdbc:mysql://localhost/CarLoan";
		String username = "root";
		String password = "qwerty";
		/*
		 * creazione di una connessione al database HenrysBooksDB20130222 con
		 * credenziali di accesso appropriate
		 */

		try {
			connessione = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
