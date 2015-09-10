package business.service;

import java.sql.SQLException;
import data.DaoClienti;

/**
 * Classe per la gestione dei clienti del sistema
 * @author Sergio
 *
 */
public class GestioneCliente {
	private DaoClienti daoC;

	/**
	 * Costruisce un istanza di questa classe
	 */
	public GestioneCliente() {
		daoC = new DaoClienti();

	}

	/**
	 * Chiama il DAO e esegue la registrazione
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	public void registrazione() throws SQLException {
		daoC.registrazione();

	}

	/**
	 * Chiama il DAO ricercando il codice fiscale
	 */
	public void cercaCF() {
		daoC.cercaCF();
	
	}

	/**
	 * Chiama il DAO ricercando l'username
	 */
	public void cercaUSER() {
		daoC.cercaUSER();

	}

	/**
	 * Chiama il dao che effetua la modifica
	 */
	public void modifica() {
		daoC.modifica();

	}

	/**
	 * Chiama il dao effettuando l'eliminazione
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	public void elimina() throws SQLException {
		daoC.elimina();
	}
}
