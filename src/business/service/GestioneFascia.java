package business.service;

import java.sql.SQLException;
import java.util.ArrayList;

import data.DaoFasce;

/**
 * Classe per la gestione delle fasce di auto presenti nel sistema
 * @author Sergio
 *
 */
public class GestioneFascia {
	private DaoFasce daoF;

	/**
	 * Costruisce un istanza di classe
	 */
	public GestioneFascia() {
		daoF = new DaoFasce();
	}

	/**
	 * Restituisce la lista delle fasce di automobili presenti del sistema
	 * @return
	 * 		la lista delle fascie
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	public ArrayList<String> fasce() throws SQLException {

		return daoF.tutteFasce();
	}
}
