package presentation.controller;

import java.io.IOException;
import java.sql.SQLException;

import business.service.GestioneAgenzia;
import business.service.GestioneFascia;
import presentation.Login;
import utilita.controlli_e_sicurezza.Controlli;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * Controller della schermata della vettura
 * @author Sergio
 *
 */
public class VetturaController {
	private final String[] cambioType = { "MANUALE", "AUTOMATICO",
			"SEMIAUTOMATICO" };
	private final String[] alimentazioneType = { "BENZINA", "DIESEL", "METANO",
			"GAS", "ELETTRICA" };
	private final String[] statoType = { "DISPONIBILE", "NOLEGGIATA",
			"MANUTENZIONE" };

	@FXML
	private TextField targa;

	@FXML
	private TextField marca;
	@FXML
	private TextField modello;
	@FXML
	private TextField cilindrata;
	@FXML
	private Label scadenzaAssicurazoneLabel;
	@FXML
	private ComboBox<String> cambio;
	@FXML
	private ComboBox<String> stato;
	@FXML
	private Spinner<Integer> posti;
	@FXML
	private DatePicker data_immatricolazione;
	@FXML
	private DatePicker scadenza_assicurazione;
	@FXML
	private TextField chilometri;
	@FXML
	private ToggleGroup radioGroup1;
	@FXML
	private RadioButton acS;
	@FXML
	private RadioButton acN;
	@FXML
	private ComboBox<String> fascia;
	@FXML
	private ComboBox<String> alimentazione;
	@FXML
	private ComboBox<String> agenzia;
	private Controlli controlli;
	private FrontController front;
	private GestioneAgenzia gAgenzia;
	private GestioneFascia gFascia;
	private Login login;

	/**
	 * Costruisce un istanza di questa classe
	 */
	public VetturaController() {

		controlli = new Controlli();
		front = new FrontController();
		gAgenzia = new GestioneAgenzia();
		gFascia = new GestioneFascia();
		login = new Login();
	}

	/**
	 * Chiamato per inizializzare il controllo dopo che la schermata è stata visualizzata
	 */
	@FXML
	void initialize() throws SQLException {

		if (login.getStato().equalsIgnoreCase("aggiungi")) {
			cambio.setValue(cambioType[0]);

			cambio.getItems().addAll(cambioType);

			alimentazione.setValue(alimentazioneType[0]);

			alimentazione.getItems().addAll(alimentazioneType);
			stato.setValue(statoType[0]);

			stato.getItems().addAll(statoType);

			agenzia.setValue(gAgenzia.agenzie().get(0));
			agenzia.getItems().addAll(gAgenzia.agenzie());

			fascia.setValue(gFascia.fasce().get(0));
			fascia.getItems().addAll(gFascia.fasce());

		}

	}

	/**
	 * Permette di aggiungere una nuova vettura al sistema una volta effettuati tutti i controlli necessari
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void aggiungi(ActionEvent event) throws IOException, SQLException {
		boolean verificaTarga = false;
		boolean verificaAC = false;
		boolean verificaDataImm = false;
		boolean lunghezze = false;
		boolean verificaKM = false;
		boolean verificaTargaEsistente = false;
		boolean verificaAssicurazione = false;

		Stage app_stage = (Stage) ((Node) event.getSource()).getScene()
				.getWindow();

		Login.setStage(app_stage);
		String targa = this.targa.getText().replaceAll("\\s+", "")
				.toUpperCase().trim();
		String modello = this.modello.getText().toUpperCase().trim();
		String marca = this.marca.getText().toUpperCase().trim();
		String km = this.chilometri.getText().toUpperCase().trim();

		String cilindrata = this.cilindrata.getText().toUpperCase().trim();

		RadioButton ac = (RadioButton) radioGroup1.getSelectedToggle();
		verificaAC = controlli.verificaAC(ac);
		verificaDataImm = controlli.dataImmEsatta(this.data_immatricolazione);
		
		String posti = String.valueOf(this.posti.getValue());
		posti = posti.substring(0, posti.length()-2);

		String cambio = this.cambio.getValue().toString();

		verificaAssicurazione = controlli.oggettoNull(
				this.scadenza_assicurazione.getValue(),
				scadenzaAssicurazoneLabel.toString());

		verificaKM = controlli.controlloChilometri(km);
		verificaTarga = controlli.controlloTarga(targa);
		verificaTargaEsistente = controlli.controlloTargaEsistente(targa);
		lunghezze = controlli.controlloLunghezza(this.modello, this.cilindrata,
				this.marca);

		if (verificaTarga && !verificaTargaEsistente && verificaAC
				&& verificaKM && verificaDataImm && !verificaAssicurazione
				&& !lunghezze) {
			ApplicationController.params.put("targa", targa);
			ApplicationController.params.put("marca", marca);
			ApplicationController.params.put("modello", modello);
			ApplicationController.params.put("cilindrata", cilindrata);
			ApplicationController.params.put("cambio", cambio);
			ApplicationController.params.put("ac", ac.getText());
			ApplicationController.params.put("posti", posti);
			ApplicationController.params.put("dataImm",
					this.data_immatricolazione.getValue().toString());
			ApplicationController.params.put("dataScadenzaAss",
					this.scadenza_assicurazione.getValue().toString());
			ApplicationController.params.put("alimentazione", alimentazione
					.getValue().toString());
			ApplicationController.params.put("stato", stato.getValue()
					.toString());
			ApplicationController.params.put("km", km);
			ApplicationController.params.put("agenzia", agenzia.getValue()
					.toString());
			ApplicationController.params.put("fascia", fascia.getValue()
					.toString());
			
			System.out.println(ApplicationController.params.toString());

			front.dispatchRequest("registraVettura");

			controlli.alertSuccesso("VETTURA REGISTRATA");

		}
		ApplicationController.params.clear();
	}
	
	/**
	 * Permette di visualizzare l'auto cercata e presente nel sistema
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void visualizza(ActionEvent event) throws IOException, SQLException {
		
		String targa = this.targa.getText().replaceAll("\\s+", "")
				.toUpperCase().trim();
		
		System.out.println(targa);
		
	}
}
