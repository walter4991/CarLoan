package business.service;

import java.sql.SQLException;

import data.DaoVetture;

/**
 * Classe che gestisce le vetture del sistema
 * @author Sergio
 *
 */
public class GestioneVettura {
	private DaoVetture vettura;

	/**
	 * Costruisce un istanza di questa classe
	 */
	public GestioneVettura() {
		vettura = new DaoVetture();
	}

	/**
	 * Chiama il DAO che effettua l'inserimento di una nuova vettura nel sistema
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	public void registra() throws SQLException {
		vettura.registrazione();
	}
}
