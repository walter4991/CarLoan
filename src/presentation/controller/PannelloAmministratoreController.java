package presentation.controller;

import java.io.IOException;
import java.sql.SQLException;

import presentation.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Controller per la schermata amministratore in cui vengono iplementate le varie azioni
 * @author Sergio
 *
 */
public class PannelloAmministratoreController {

	private FrontController frontController;

	/**
	 * Costruisce un istanza di questa classe
	 */
	public PannelloAmministratoreController() {
		frontController = new FrontController();
	}

	/**
	 * Efettua il logout del sistema
	 * @param event
	 * 		l'evento del pulsanto
	 * @throws IOException
	 * 		se l'interfaccia non è caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void logout(ActionEvent event) throws IOException, SQLException {

		Stage app_stage = (Stage) ((Node) event.getSource()).getScene()
				.getWindow();

		Login.setStage(app_stage);
		frontController.dispatchRequest("logout");

	}

	/**
	 * Permette di tornare all'home
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione è mancante
	 */
	@FXML
	public void tornaHome(ActionEvent event) throws IOException, SQLException {

		frontController.dispatchRequest("accessoAmministratore");
	}

	/**
	 * Chiude la finestra del sistema
	 * @param event
	 */
	@FXML
	public void chiudiApp(ActionEvent event) {

		Login.getStage().close();
	}

	/**
	 * Permette di passare alla schermata per aggiungere una vettura
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void aggiungiVettura(ActionEvent event) throws IOException,
			SQLException {
		Login.setStato("aggiungi");
		frontController.dispatchRequest("aggiungiVettura");
	}

	/**
	 * Permette di passare alla schermata per aggiungere un' Agenzia
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void aggiungiAgenzia(ActionEvent event) throws IOException,
			SQLException {
		Login.setStato("aggiungi");
		frontController.dispatchRequest("aggiungiAgenzia");
	}

	/**
	 * Permette di passare alla schermata per aprire un contratto
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void apriContratto(ActionEvent event) throws IOException,
			SQLException {
		
		frontController.dispatchRequest("apriContratto");
	}

	/**
	 * Permette di passare alla schermata per chiudere un contratto
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void chiudiContratto(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("chiudiContratto");
	}

	/**
	 * 
	 * Permette di passare alla schermata per aggiungere un nuovo cliente
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void aggiungiCliente(ActionEvent event) throws IOException,
			SQLException {
		Login.setStato("aggiungi");
		frontController.dispatchRequest("cliente");

	}

	/**
	 * Permette di passare alla schermata per aggiungere una prenotazione
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void aggiungiPrenotazione(ActionEvent event) throws IOException,
			SQLException {
		Login.setStato("aggiungi");
		frontController.dispatchRequest("aggiungiPrenotazione");
	}

	/**
	 * Permette di passare alla schermata per aggiungere una fascia
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void aggiungiFascia(ActionEvent event) throws IOException,
			SQLException {
		Login.setStato("aggiungi");
		frontController.dispatchRequest("aggiungiFascia");
	}

	/**
	 * Permette di passare alla schermata per cercare un utente e impostare lo stato si visualizza
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaUtenteV(ActionEvent event) throws IOException,
			SQLException {
		Login.setStato("visualizza");
		frontController.dispatchRequest("cercaUtente");

	}

	/**
	 * Permette di passare alla schermata per cercare un utente e impostare lo stato su modifica
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaUtenteM(ActionEvent event) throws IOException,
			SQLException {
		Login.setStato("modifica");
		frontController.dispatchRequest("cercaUtente");

	}

	/**
	 * Permette di passare alla schermata per cercare un utente e impostare lo stato su elimina
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaUtenteE(ActionEvent event) throws IOException,
			SQLException {
		Login.setStato("elimina");
		frontController.dispatchRequest("cercaUtente");

	}

	/**
	 * Permette di passare alla schermata per cercare una vettura e impostare lo stato su visualizza
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaVetturaV(ActionEvent event) throws IOException,
			SQLException {
		Login.setStato("visualizza");
		frontController.dispatchRequest("cercaVetturaAmm");

	}

	/**
	 * Permette di passare alla schermata per cercare una vettura e impostare lo stato su modifica
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaVetturaM(ActionEvent event) throws IOException,
			SQLException {
		Login.setStato("modifica");
		frontController.dispatchRequest("cercaVetturaAmm");

	}

	/**
	 * Permette di passare alla schermata per cercare una vettura e impostare lo stato su elimina
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaVetturaE(ActionEvent event) throws IOException,
			SQLException {
		Login.setStato("elimina");
		frontController.dispatchRequest("cercaVetturaAmm");

	}

	/**
	 * Permette di passare alla schermata per cercare un contratto
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaContratto(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("cercaContrattoAmm");
	}

	/**
	 * Permette di passare alla schermata per cercare un' Agenzia e impostare lo stato su visualizza
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaAgenziaV(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("cercaAgenziaAmm");
		Login.setStato("visualizza");
	}

	/**
	 * Permette di passare alla schermata per cercare un' Agenzia e impostare lo stato su modifica
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaAgenziaM(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("cercaAgenziaAmm");
		Login.setStato("modifica");
	}

	/**
	 * Permette di passare alla schermata per cercare un' Agenzia e impostare lo stato su elimina
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaAgenziaE(ActionEvent event) throws IOException,
			SQLException {

		frontController.dispatchRequest("cercaAgenziaAmm");
		Login.setStato("elimina");
	}

	/**
	 * Permette di passare alla schermata per cercare una prenotazione e impostare lo stato su visualizza
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaPrenotazioneV(ActionEvent event) throws IOException,
			SQLException {

		Login.setStato("visualizza");
		frontController.dispatchRequest("cercaPrenotazioneAmm");
	}

	/**
	 * Permette di passare alla schermata per cercare una prenotazione e impostare lo stato su elimina
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaPrenotazioneE(ActionEvent event) throws IOException,
			SQLException {

		Login.setStato("elimina");
		frontController.dispatchRequest("cercaPrenotazioneAmm");
	}

	/**
	 * Permette di passare alla schermata per cercare una fascia e impostare lo stato su visualizza
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaFasciaV(ActionEvent event) throws IOException,
			SQLException {

		Login.setStato("visualizza");
		frontController.dispatchRequest("cercaFasciaAmm");
	}

	/**
	 * Permette di passare alla schermata per cercare una fascia e impostare lo stato su modifica
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaFasciaM(ActionEvent event) throws IOException,
			SQLException {

		Login.setStato("modifica");
		frontController.dispatchRequest("cercaFasciaAmm");
	}

	/**
	 * Permette di passare alla schermata per cercare una fascia e impostare lo stato su elimina
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void cercaFasciaE(ActionEvent event) throws IOException,
			SQLException {

		Login.setStato("elimina");
		frontController.dispatchRequest("cercaFasciaAmm");
	}

	/**
	 * Permette di passare alla schermata per aggiungere un'Amministratore e impostare lo stato su aggiungi
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void aggiungiAmministratore(ActionEvent event) throws IOException,
			SQLException {
		Login.setStato("aggiungi");
		frontController.dispatchRequest("aggiungiAmm");
	}
}
