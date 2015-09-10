package presentation.controller;

import java.io.IOException;
import java.sql.SQLException;

import data.DaoClienti;
import data.DaoLogin;
import utilita.controlli_e_sicurezza.Controlli;
import utilita.controlli_e_sicurezza.GestioneAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller per la schermata cerca di un utente
 * @author Sergio
 *
 */
public class CercaUtenteAmmController {

	private final String CAMPI_VUOTI = "RIEMPI SOLO UN CAMPO PER EFFETTURE LA RICERCA";
	private final String NESSUN_CLIENTE = "IL CLIENTE NON E' PRESENTE NEL SISTEMA";
	private final String DIMENSIONE_USERNAME = "USERNAME TROPPO GRANDE, DEVE ESSERE MINORE DI 30 CARATTERI";

	private FrontController frontController;

	private GestioneAlert ga;
	private Controlli controlli;
	private DaoLogin daoLogin;
	private DaoClienti daoClienti;

	@FXML
	private TextField username;
	@FXML
	private TextField codFiscale;

	/**
	 * Costruisce un istanza di questa classe
	 */
	public CercaUtenteAmmController() {
		frontController = new FrontController();
		ga = new GestioneAlert();
		controlli = new Controlli();
		daoLogin = new DaoLogin();
		daoClienti = new DaoClienti();
	}

	/**
	 * Visualizza il cliente cercato dopo aver effettuato tutti i controlli e generando 
	 * eventuali alert
	 * @param event
	 * 		l'evento del pulsante	
	 * @throws IOException
	 * 		se la schermata non è stata coricata correttamente
	 * @throws SQLException
	 * 			se la connessione non è presente
	 */
	@FXML
	public void visualizza(ActionEvent event) throws IOException, SQLException {

		boolean cambiaSchermata = false;
		String user = username.getText().trim().toUpperCase();
		String codFis = codFiscale.getText().trim().toUpperCase();

		if ((user.isEmpty() && codFis.isEmpty())
				|| (!user.isEmpty() && !codFis.isEmpty())) {
			ga.alertErrore(CAMPI_VUOTI);
			username.clear();
			codFiscale.clear();
		} else if (!user.isEmpty()) {
			if (user.length() < 30) {
				if (daoLogin.usernameEsistente(user)) {
					ApplicationController.params.put("username", user);
					frontController.dispatchRequest("cercaUUSER");
					cambiaSchermata = true;
				} else {
					ga.alertInformativo(NESSUN_CLIENTE);
				}
			} else {
				ga.alertErrore(DIMENSIONE_USERNAME);
			}
		} else {
			if (controlli.controlloCF(codFis)) {
				if (daoClienti.cfEsistente(codFis)) {
					ApplicationController.params.put("codFis", codFis);
					frontController.dispatchRequest("cercaUCF");
					cambiaSchermata = true;
				} else {
					ga.alertInformativo(NESSUN_CLIENTE);
				}
			}
		}

		ApplicationController.params.clear();

		if (cambiaSchermata) {
			frontController.dispatchRequest("cliente");

		}
	}
}
