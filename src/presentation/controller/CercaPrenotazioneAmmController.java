package presentation.controller;

import java.io.IOException;
import java.sql.SQLException;

import presentation.Login;
import utilita.controlli_e_sicurezza.Controlli;
import utilita.controlli_e_sicurezza.GestioneAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller per la schermata cerca delle prenotazioni
 * @author Sergio
 *
 */
public class CercaPrenotazioneAmmController {
	
	private final String ERRORE_CAMPI = "Completare solo uno dei due campi!";

	private FrontController frontController;
	private GestioneAlert ga;
	private Controlli co;
	
	@FXML
	private TextField prenotazione;
	@FXML
	private TextField codFis;

	/**
	 * Costruisce un istanza di questa classe
	 */
	public CercaPrenotazioneAmmController() {
		frontController = new FrontController();
		ga = new GestioneAlert();
		co = new Controlli();
	}

	/**
	 * Visualizza la prenotazione cercata dopo aver effettuato tutti i controlli delle varie text field
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non viene caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	public void visualizza(ActionEvent event) throws IOException, SQLException {
		boolean cambiaSchermata = false;
		boolean lunghezza = false;
		boolean verificaCF = false;
		String codPrenotazione = prenotazione.getText().trim().toUpperCase();
		String codFisc = codFis.getText().trim().toUpperCase();
		
		if((codPrenotazione.isEmpty() && codFisc.isEmpty()) || (!codPrenotazione.isEmpty() && !codFisc.isEmpty())) {
			ga.alertErrore(ERRORE_CAMPI);
			prenotazione.clear();
			codFis.clear();
		}
		else {
			
			if(!codPrenotazione.isEmpty()) {
				lunghezza = co.controlloLunghezza(prenotazione);
				if(!lunghezza) {
					if(co.prenotazioneCerca(codPrenotazione)) {
						ApplicationController.params.put("codPrenotazione", codPrenotazione);
						frontController.dispatchRequest("cercaCodPrenotazione");
						cambiaSchermata = true;
					}
				}
			}
			
			if(!codFisc.isEmpty()) {
				verificaCF = co.controlloCF(codFisc);
				if(verificaCF) {
					if(co.cfCerca(codFisc)) {
						ApplicationController.params.put("codFiscale", codFisc);
						frontController.dispatchRequest("cercaPrenotazioneCf");
						cambiaSchermata = true;
					}
				}
			}
		}
		
		if(cambiaSchermata) {
			frontController.dispatchRequest("aggiungiPrenotazione");
		}
	}
}
