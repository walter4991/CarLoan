package presentation.controller;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Classe che accoglie tutte le richieste delle interfacce e li invia all'Application Controller per la gestione
 * @author Sergio
 *
 */
public class FrontController {

	private ApplicationController dispatcher;

	/**
	 * Costruisce un istanza di questa classe
	 */
	public FrontController() {
		dispatcher = new ApplicationController();
	}

	/**
	 * Accoglie la richiesta e la invia al giusto dispatcher
	 * @param request
	 * 			la richiesta letta
	 * @throws IOException
	 * 			se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 */
	public void dispatchRequest(String request) throws IOException,
			SQLException {
		
		dispatcher.dispatch(request);
	}
}
