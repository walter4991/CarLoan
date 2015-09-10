package presentation.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import business.service.GestioneCliente;
import business.service.GestioneLogin;
import business.service.GestioneVettura;
import presentation.Login;
import presentation.ViewDispatcher;

/**
 * Classe chiamata dal front controller per gestire tutte le richieste delle varie interfacce
 * @author Sergio
 *
 */
public class ApplicationController {

	/**
	 * Dizioniario che contiene i parametri che verranno prelevati dal DAO
	 */
	public static HashMap<String, Object> params = new HashMap<String, Object>();
	/**
	 * Lista di risultati che vengono restituiti dal DAO
	 */
	public static ArrayList<Object> risultati = new ArrayList<Object>();
	/**
	 * Dizionario che ci indica il cliente loggato al momento
	 */
	public static HashMap<String, Object> clienteAttivo = new HashMap<String, Object>();

	private GestioneCliente cliente;
	private ViewDispatcher view;
	private GestioneLogin login;
	private GestioneVettura vettura;

	// comuni
	final static String CLIENTE = "schermate/Cliente.fxml";// "schermate/registrazioneCliente.fxml"
	final static String PANNELLO_CLIENTE = "schermate/pannelloCliente.fxml";
	final static String PANNELLO_AMMINISTRATORE = "schermate/pannelloAmministratore.fxml";
	final static String LOGIN = "schermate/login.fxml";
	final static String VISUALIZZAZIONE_UTENTE = "schermate/Cliente.fxml";

	// cliente
	final static String PROFILO_UTENTE = "schermate/Cliente.fxml";// "schermate/modificaUtente.fxml"
	final static String PRENOTAZIONI = "schermate/elencoPrenotazioni.fxml";
	final static String CONTRATTI = "schermate/elencoContratti.fxml";
	final static String AGENZIE = "schermate/visualizzaAgenzia.fxml";
	final static String GARAGE = "schermate/parcoVetture1.fxml";
	final static String CERCA_PRENOTAZIONE = "schermate/cercaPrenotazione.fxml";
	final static String CERCA_CONTRATTO = "schermate/cercaContratto.fxml";
	final static String CERCA_VETTURA = "schermate/cercaVettura.fxml";
	final static String CERCA_AGENZIA = "schermate/cercaAgenzia.fxml";
	final static String ABOUT = "schermate/about.fxml";
	// amministratore
	final static String CERCA_UTENTE = "schermate/cercaUtenteAmm.fxml";
	final static String VISUALIZZA_UTENTE_AMM = "schermate/Cliente.fxml";// "schermate/visualizzaUtenteAmm.fxml"
	final static String ELIMINA_UTENTE = "schermate/Cliente.fxml";// "schermate/eliminaUtente.fxml"
	final static String CERCA_VETTURA_AMM = "schermate/cercaVetturaAmm.fxml";
	final static String VISUALIZZA_VETTURA_AMM = "schermate/visualizzaVetturaAmm.fxml";
	final static String MODIFICA_VETTURA = "schermate/modificaVettura.fxml";
	final static String ELIMINA_VETTURA = "schermate/eliminaVettura.fxml";
	final static String CERCA_AGENZIA_AMM = "schermate/cercaAgenziaAmm.fxml";
	final static String VISUALIZZA_AGENZIA_AMM = "schermate/visualizzaAgenziaAmm.fxml";
	final static String MODIFICA_AGENZIA = "schermate/modificaAgenzia.fxml";
	final static String ELIMINA_AGENZIA = "schermate/eliminaAgenzia.fxml";
	final static String CERCA_CONTRATTO_AMM = "schermate/cercaContrattoAmm.fxml";
	final static String VISUALIZZA_CONTRATTO_AMM = "schermate/visualizzaContrattoAmm.fxml";
	final static String CERCA_PRENOTAZIONE_AMM = "schermate/cercaPrenotazioneAmm.fxml";
	final static String VISUALIZZA_PRENOTAZIONE_AMM = "schermate/visualizzaPrenotazioneAmm.fxml";
	final static String AGGIUNGI_PRENOTAZIONE = "schermate/aggiungiPrenotazione.fxml";
	final static String ELIMINA_PRENOTAZIONE = "schermate/eliminaPrenotazione.fxml";
	final static String CERCA_FASCIA_AMM = "schermate/cercaFasciaAmm.fxml";
	final static String VISUALIZZA_FASCIA_AMM = "schermate/visualizzaFasciaAmm.fxml";
	final static String AGGIUNGI_VETTURA = "schermate/aggiungiVettura.fxml";
	final static String AGGIUNGI_AGENZIA = "schermate/aggiungiAgenzia.fxml";
	final static String APRI_CONTRATTO = "schermate/apriContratto.fxml";
	final static String CHIUDI_CONTRATTO = "schermate/chiudiContratto.fxml";
	final static String AGGIUNGI_FASCIA = "schermate/aggiungiFascia.fxml";
	final static String MODIFICA_FASCIA = "schermate/modificaFascia.fxml";
	final static String ELIMINA_FASCIA = "schermate/eliminaFascia.fxml";

	/**
	 * Cotruisce un istanza di questa classe
	 */
	public ApplicationController() {
		login = new GestioneLogin();
		view = new ViewDispatcher();
		cliente = new GestioneCliente();
		vettura = new GestioneVettura();
	}

	/**
	 * Gestitsce le richieste che gli vengono passate dal front controller
	 * @param request
	 * 			la richiesta da soddisfare
	 * @throws IOException
	 * 			se la schermata non puo essere caricata
	 * @throws SQLException
	 * 			se la connessione non è presente
	 */
	public void dispatch(String request) throws IOException, SQLException {

		switch (request) {
		case "login":

			int result = login.login();
			Login.setAmmCliente(result);
			if (result == 1) {
				cliente.cercaUSER();
			}
			break;
		case "registra":
			cliente.registrazione();
			break;
		case "registraVettura":
			vettura.registra();

			break;
		case "cercaUCF":
			cliente.cercaCF();
			break;
		case "cercaUUSER":
			cliente.cercaUSER();
			break;
		case "modificaCliente":
			cliente.modifica();

			break;

		case "eliminaCliente":
			cliente.elimina();

			break;
		case "modificaCampi":
			break;

		// tutti i cambi di interfaccia

		case "accessoCliente":
			view.setInterface(PANNELLO_CLIENTE, Login.getStage());
			break;
		case "accessoAmministratore":
			view.setInterface(PANNELLO_AMMINISTRATORE, Login.getStage());
			break;
		case "logout":
			login.logout();
			view.setInterface(LOGIN, Login.getStage());

			break;

		// tutti i cambi di anchorPane centrale comnuni

		case "cliente":
			if (Login.getStato().equalsIgnoreCase("registrazione")) {
				view.setInterface(CLIENTE, Login.getStage());
			} else {
				view.setPane(CLIENTE);

			}

			break;

		// tutti i cambi di anchorPane centrale utente

		case "visualizzaPrenotazioni":
			view.setPane(PRENOTAZIONI);
			break;
		case "visualizzaContratti":
			view.setPane(CONTRATTI);
			break;
		case "visualizzaGarage":
			view.setPane(GARAGE);
			break;
		case "visualizzaAgenzia":
			view.setPane(AGENZIE);
			break;
		case "cercaPrenotazione":
			view.setPane(CERCA_PRENOTAZIONE);
			break;
		case "cercaContratto":
			view.setPane(CERCA_CONTRATTO);
			break;
		case "cercaVettura":
			view.setPane(CERCA_VETTURA);
			break;
		case "cercaAgenzia":
			view.setPane(CERCA_AGENZIA);
			break;
		case "about":
			view.setPane(ABOUT);
			break;

		// tutti i cambi di anchorPane centrale amministratore

		case "cercaUtente":
			view.setPane(CERCA_UTENTE);
			break;

		case "cercaVetturaAmm":
			view.setPane(CERCA_VETTURA_AMM);
			break;
		case "visualizzaVetturaAmm":
			view.setPane(VISUALIZZA_VETTURA_AMM);
			break;
		case "aggiungiVettura":
			view.setPane(AGGIUNGI_VETTURA);
			break;
		case "modificaVettura":
			view.setPane(MODIFICA_VETTURA);
			break;
		case "eliminaVettura":
			view.setPane(ELIMINA_VETTURA);
			break;
		case "cercaAgenziaAmm":
			view.setPane(CERCA_AGENZIA_AMM);
			break;
		case "visualizzaAgenziaAmm":
			view.setPane(VISUALIZZA_AGENZIA_AMM);
			break;
		case "aggiungiAgenzia":
			view.setPane(AGGIUNGI_AGENZIA);
			break;
		case "modificaAgenzia":
			view.setPane(MODIFICA_AGENZIA);
			break;
		case "eliminaAgenzia":
			view.setPane(ELIMINA_AGENZIA);
			break;
		case "cercaContrattoAmm":
			view.setPane(CERCA_CONTRATTO_AMM);
			break;
		case "visualizzaContrattoAmm":
			view.setPane(VISUALIZZA_CONTRATTO_AMM);
			break;
		case "apriContratto":
			view.setPane(APRI_CONTRATTO);
			break;
		case "chiudiContratto":
			view.setPane(CHIUDI_CONTRATTO);
			break;
		case "cercaPrenotazioneAmm":
			view.setPane(CERCA_PRENOTAZIONE_AMM);
			break;
		case "visualizzaPrenotazioneAmm":
			view.setPane(VISUALIZZA_PRENOTAZIONE_AMM);
			break;
		case "aggiungiPrenotazione":
			view.setPane(AGGIUNGI_PRENOTAZIONE);
			break;
		case "eliminaPrenotazione":
			view.setPane(ELIMINA_PRENOTAZIONE);
			break;
		case "cercaFasciaAmm":
			view.setPane(CERCA_FASCIA_AMM);
			break;
		case "visualizzaFasciaAmm":
			view.setPane(VISUALIZZA_FASCIA_AMM);
			break;
		case "aggiungiFascia":
			view.setPane(AGGIUNGI_FASCIA);
			break;
		case "modificaFascia":
			view.setPane(MODIFICA_FASCIA);
			break;
		case "eliminaFascia":
			view.setPane(ELIMINA_FASCIA);
			break;
		case "aggiungiAmm":
			view.setPane(CLIENTE);
			break;
		default:
			break;
		}
	}
}
