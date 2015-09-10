package presentation.controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Node;

import javafx.stage.Stage;
import presentation.Login;

/**
 * Controller per la schermata principale del cliente
 * @author Sergio
 *
 */
public class PannelloClienteController {

	private FrontController frontController;

	/**
	 * Costruisce un istanza di questa classe
	 */
	public PannelloClienteController() {
		frontController = new FrontController();
	}

	/**
	 * Effettua il logout dal sistema
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connesione non è presente
	 */
	@FXML
	public void logout(ActionEvent event) throws IOException, SQLException {

		Stage app_stage = (Stage) ((Node) event.getSource()).getScene()
				.getWindow();

		Login.setStage(app_stage);
		frontController.dispatchRequest("logout");

	}

	/**
	 * Permette di tornare alla home page del cliente
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connesione non è presente
	 */
	@FXML
	public void tornaHome(ActionEvent event) throws IOException, SQLException {

		frontController.dispatchRequest("accessoCliente");
	}

	/**
	 * Permette di chiudere la finestra del sistema
	 * @param event
	 * 		l'evento del pulsante
	 */
	@FXML
	public void chiudiApp(ActionEvent event) {

		Login.getStage().close();
	}

	/**
	 * Permette di passare alla schermate per visualizzare e modificare il profilo del cliente loggato
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connesione non è presente
	 */
	@FXML
	public void profilo(ActionEvent event) throws IOException, SQLException {

		Login.setStato("modifica");
		frontController.dispatchRequest("cliente");
	}

	/**
	 * Permette di passare alla schermate per visualizzare le prenotazioni del cliente loggato
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connesione non è presente
	 */
	@FXML
	public void visualizzaPrenotazioni(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("visualizzaPrenotazioni");
	}

	/**
	 * Permette di passare alla schermate per cercare una vettura
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connesione non è presente
	 */
	@FXML
	public void cercaVettura(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("cercaVettura");
	}

	/**
	 * Permette di passare alla schermate per visualizzare i contratti del cliente loggato
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connesione non è presente
	 */
	@FXML
	public void visualizzaContratti(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("visualizzaContratti");
	}

	/**
	 * Permette di passare alla schermate per visualizzare il parco auto completo
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connesione non è presente
	 */
	@FXML
	public void visualizzaGarage(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("visualizzaGarage");
	}

	/**
	 * Permette di passare alla schermate per visualizzare le informazioni del sistema
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connesione non è presente
	 */
	@FXML
	public void about(ActionEvent event) throws IOException, SQLException {

		frontController.dispatchRequest("about");
	}

	/**
	 * Permette di passare alla schermate per visualizzare le agenzie 
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connesione non è presente
	 */
	@FXML
	public void visualizzaAgenzia(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("visualizzaAgenzia");
	}

	/**
	 * Permette di passare alla schermate per cercare le prenotazioni effettuate dal cliente loggato
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connesione non è presente
	 */
	@FXML
	public void cercaPrenotazione(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("cercaPrenotazione");
	}

	/**
	 * Permette di passare alla schermate per cercare i contratti dal cliente loggato
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connesione non è presente
	 */
	@FXML
	public void cercaContratto(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("cercaContratto");
	}

	/**
	 * Permette di passare alla schermate per cercare le agenzie
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connesione non è presente
	 */
	@FXML
	public void cercaAgenzia(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("cercaAgenzia");
	}
}
