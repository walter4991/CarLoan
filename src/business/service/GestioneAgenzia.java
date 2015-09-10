package business.service;

import java.sql.SQLException;
import java.util.ArrayList;

import data.DaoAgenzie;

/**
 * Classe che permette al gestione delle agenzie del sistema
 * @author Sergio
 *
 */
public class GestioneAgenzia {
	private DaoAgenzie daoA;

	/**
	 * Costruisce un istanza di questa classe
	 */
	public GestioneAgenzia() {
		daoA = new DaoAgenzie();
	}

	/**
	 * Restituisce la lista delle agenzie
	 * @return
	 * 		la lista delle agenzie
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	public ArrayList<String> agenzie() throws SQLException {

		return daoA.tutteAgenzie();
	}
}
