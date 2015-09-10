package presentation.controller;

import presentation.Login;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * Controller per la schermate delle prenotazioni
 * @author Sergio
 *
 */
public class PrenotazioneController {
	
	private final String VISUALIZZA  = "visualizza";
	private final String AGGIUNGI = "aggiungi";

	@FXML
	private ComboBox<String> agenziaPartenza;
	@FXML
	private ComboBox<String> tipoNol;
	@FXML
	private ComboBox<String> fascia;
	@FXML
	private ComboBox<String> agenziaConsegna;
	@FXML
	private ComboBox<String> tipoChilometri;
	@FXML
	private ComboBox<String> vettura;
	@FXML
	private Button prenota;
	@FXML
	private Button elimina;
	
	/**
	 * Chiamato per inizializzare il controllo dopo che la schermata è stata visualizzata
	 */
	@FXML
	void initialize() {
		if(Login.getStato().equalsIgnoreCase(VISUALIZZA)) {
			prenota.setVisible(false);
			elimina.setVisible(false);
		}
		else if(Login.getStato().equalsIgnoreCase(AGGIUNGI)) {
			elimina.setVisible(false);
		}
		else {
			prenota.setVisible(false);
		}
	}
	
	
	@FXML
	public void prenota() {
		
	}
	
	@FXML
	public void elimina() {
		
	}
}
