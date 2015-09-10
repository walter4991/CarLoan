package business.service;

import java.sql.SQLException;

 
import data.DaoLogin;

/**
 * Classe che permette di effettuare il login e il logout al sistema
 * @author Sergio
 *
 */
public class GestioneLogin {

	private DaoLogin daologin;

	/**
	 * Costruisce un istanza di questa classe
	 */
	public GestioneLogin() {
		daologin = new DaoLogin();
	}

	/**
	 * Chiama il DAO per ricercare l'utente nel sistema
	 * @return
	 * 		1 se è presente ed è cliente
	 * 		0 se è presente ed è amministratore
	 * 		-1 se non è presente
	 */
	public int login() {
		int tipo = daologin.login();
		return tipo;

	}

	/**
	 * Chiama il DAO che effettua il logout del sistema 
	 * @throws SQLException
	 */
	public void logout() throws SQLException {
		daologin.logout();

	}
}
