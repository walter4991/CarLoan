package presentation.controller;

import java.io.IOException;
import java.sql.SQLException;

import business.entity.Utente;

import presentation.Login;
import utilita.controlli_e_sicurezza.GestioneAlert;
import utilita.controlli_e_sicurezza.Sicurezza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller per la schermata Login per l'accesso al sistema
 * @author Sergio
 *
 */
public class LoginController {

	private final String ALERT_LOGIN = "Attenzione! Completa entrambi i campi";
	private final String ALERT_ERRORE_CREDENZIALI = "Attenzione! Controlla le credenziali o registrati";

	@FXML
	private TextField username_box;
	@FXML
	private PasswordField password_box;

	private FrontController frontController;

	private GestioneAlert alert;

	/**
	 * Costruisce un' istanza di questa classe
	 * 
	 * @throws Exception
	 * 		da gestire
	 */
	public LoginController() throws Exception {

		frontController = new FrontController();
		alert = new GestioneAlert();
	}

	/**
	 * Passa la richiesta al front controller per visualizzare la schermata di registrazione
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non viene caricata completamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void registrati(ActionEvent event) throws IOException, SQLException {

		Stage app_stage = (Stage) ((Node) event.getSource()).getScene()
				.getWindow();

		Login.setStage(app_stage);
		Login.setStato("registrazione");
		frontController.dispatchRequest("cliente");

	}

	/**
	 * Effettua l'accesso al sistema una volta effettuati tutti i controlli
	 * @param event
	 * 		l'evento del pulsante
	 * @throws Exception
	 * 		da gestire
	 */
	@FXML
	protected void accedi(ActionEvent event) throws Exception {
		Stage app_stage = null;
		String username = username_box.getText().toUpperCase();
		String password = password_box.getText().toUpperCase();
		Sicurezza s = new Sicurezza();
		password = s.encrypt(password);
		

		ApplicationController.params.put("username", username);
		ApplicationController.params.put("password", password);

		Utente utente = new Utente();

		utente.setUsername(username);
		utente.setPassword(password);

		frontController.dispatchRequest("login");

		int result = Login.getAmmCliente();
		if (username.isEmpty() || password.isEmpty()) {
			alert.alertErrore(ALERT_LOGIN);
		} else {

			ApplicationController.clienteAttivo.put("username", username);
			if (result == 0) {

				Login.setAmmCliente(0);
			} else {
				if (result == 1) {
					Login.setAmmCliente(1);
				}
			}

			if (result == -1) {
				alert.alertErrore(ALERT_ERRORE_CREDENZIALI);
				username_box.clear();
				password_box.clear();
				ApplicationController.params.clear();
			} else {

				if (Login.getAmmCliente() == 0) {
					app_stage = (Stage) ((Node) event.getSource()).getScene()
							.getWindow();

					Login.setStage(app_stage);

					frontController.dispatchRequest("accessoAmministratore");
					Login.setAmmCliente(0);
				} else {
					app_stage = (Stage) ((Node) event.getSource()).getScene()
							.getWindow();

					Login.setStage(app_stage);

					frontController.dispatchRequest("accessoCliente");
					Login.setAmmCliente(1);
				}
			}
		}
		ApplicationController.params.clear();
	}
}
