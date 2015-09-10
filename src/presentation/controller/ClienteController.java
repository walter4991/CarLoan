package presentation.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import business.entity.Cliente;
import presentation.Login;
import utilita.controlli_e_sicurezza.Controlli;
import utilita.controlli_e_sicurezza.Sicurezza;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * Controller per la schermata fxml del cliente 
 * @author Sergio
 *
 */
public class ClienteController {

	@FXML
	private TextField username;
	@FXML
	private TextField cognome;
	@FXML
	private TextField nome;
	@FXML
	private DatePicker dataDiNascita;
	@FXML
	private TextField luogoDiNascita;
	@FXML
	private TextField telefono;
	@FXML
	private TextField email;
	@FXML
	private ToggleGroup radioGroup1;
	@FXML
	private RadioButton sessoM;
	@FXML
	private RadioButton sessoF;
	@FXML
	private TextField codiceFiscale;
	@FXML
	private PasswordField password_Corrente;
	@FXML
	private Label password_CorrenteLabel;
	@FXML
	private PasswordField confermaPass;
	@FXML
	private PasswordField password;
	@FXML
	private Button annulla;
	@FXML
	private Button conferma;
	@FXML
	private Button elimina;
	@FXML
	private Label confermaPassLabel;
	@FXML
	private Label passwordLabel;
	private Login login;

	private Controlli controlli;
	private Sicurezza s;
	private FrontController frontController;
	
	private String codiceF;
	private final String AGGIUNGI = "aggiungi";
	private final String REGISTRAZIONE = "registrazione";
	private final String MODIFICA = "modifica";
	private final String VISUALIZZA = "visualizza";
	private final String ELIMINA = "elimina";
	private final String ACCESSO_AMMINISTRATORE = "accessoAmministratore";
	private final String LOGOUT = "logout";
	private final String REGISTRA = "registra";
	private final String MODIFICA_CLIENTE = "modificaCliente";
	
	/**
	 * Chiamato per inizializzare il controllo dopo che la schermata è stata visualizzata
	 */
	@FXML
	void initialize() {

		elimina.setVisible(false);

		if (login.getStato().equalsIgnoreCase(AGGIUNGI)
				|| login.getStato().equalsIgnoreCase(REGISTRAZIONE)) {
			inizializzaRegistrazioneCliente();

		} else {

			riempiCliente();
			codiceF = codiceFiscale.getText().toUpperCase().trim();

			if (login.getStato().equalsIgnoreCase(MODIFICA)
					&& Login.getAmmCliente() == 1) {

				modificaCliente();
			} else {
				username.setEditable(false);
				password_Corrente.setEditable(false);
				if (login.getStato().equalsIgnoreCase(VISUALIZZA)
						|| login.getStato().equalsIgnoreCase(ELIMINA)) {

					visualizzazioneCliente();

					if (login.getStato().equalsIgnoreCase(ELIMINA)) {
						elimina.setVisible(true);

					}
				}

			}

		}

	}

	/**
	 * Costruisce un istanza di questa classe
	 * @throws Exception
	 * 		da gestire
	 */
	public ClienteController() throws Exception {
		controlli = new Controlli();
		login =new Login();
		frontController = new FrontController();
		s= new Sicurezza();
	}

	/**
	 * Permette di annullare le modifiche relative al cliente
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schermata non è stata caricata correttamene
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void annulla(ActionEvent event) throws IOException, SQLException {

		Stage app_stage = (Stage) ((Node) event.getSource()).getScene()
				.getWindow();

		Login.setStage(app_stage);

		if (Login.getAmmCliente() == 0
				&& (login.getStato().equalsIgnoreCase(AGGIUNGI) || login
						.getStato().equalsIgnoreCase(AGGIUNGI))) {
			frontController.dispatchRequest(ACCESSO_AMMINISTRATORE);
		} else {
			frontController.dispatchRequest(LOGOUT);
		}
	}

	/**
	 * Permette di inserire un nuovo cliente nel sistema o modificare i dati di uno gia esistente
	 * in base allo stato di ricerca in cui ci troviamo, una volta effettuati tutti i controlli
	 * @param event
	 * 		l'evento del pulsante
	 * @throws Exception
	 * 		da gestire
	 */
	@FXML
	public void registrato(ActionEvent event) throws Exception {

		boolean verificaUsernameEsistente = false;
		boolean lunghezze = true;
		boolean verificaPassUguali = false;
		boolean sessoEsatto = false;
		boolean verificaMail = false;
		boolean numTelefono = false;
		boolean verificaCF = false;
		boolean verificaDataNascita = false;
		boolean verificaCFEsistente = true;

		Stage app_stage = (Stage) ((Node) event.getSource()).getScene()
				.getWindow();

		Login.setStage(app_stage);

		String user = username.getText().toUpperCase().trim();
		String pass = password.getText().toUpperCase().trim();
		String conf = confermaPass.getText().toUpperCase().trim();

		String cogn = cognome.getText().toUpperCase().trim();
		String nom = nome.getText().toUpperCase().trim();

		String luogoNascita = luogoDiNascita.getText().toUpperCase().trim();
		String mail = email.getText().toUpperCase().trim();
		String tel = telefono.getText().trim();
		String cf = codiceFiscale.getText().toUpperCase().trim();
		RadioButton sesso = (RadioButton) radioGroup1.getSelectedToggle();

		verificaPassUguali = controlli.controlloStringheCoincidenti(pass, conf);//pass.equalsIgnoreCase(conf);
		lunghezze = controlli.controlloLunghezza(username, cognome, nome,
				luogoDiNascita);

		sessoEsatto = controlli.verificaSesso(sesso);
		verificaDataNascita = controlli.dataNascitaEsatta(dataDiNascita);
		verificaMail = controlli.email(email.getText());

		numTelefono = controlli.controlloTelefono(tel);
		verificaCF = controlli.controlloCF(cf);

		if (login.getStato().equalsIgnoreCase(AGGIUNGI)) {

			verificaUsernameEsistente = controlli.usernameEsistente(user);

			verificaCFEsistente = controlli.controlloCFEsistente(cf);

		} else {
			if (login.getStato().equalsIgnoreCase(MODIFICA)) {

				verificaCFEsistente = false;
				if (codiceFiscale.getText().toUpperCase().trim()
						.compareToIgnoreCase(codiceF) != 0) {
					verificaCFEsistente = controlli.controlloCFEsistente(cf);
					if (!verificaCFEsistente) {

						ApplicationController.params.replace("codiceFiscale",
								codiceF);
					}

				}

			}
		}

		if (!verificaUsernameEsistente && !lunghezze && verificaPassUguali
				&& sessoEsatto && verificaDataNascita && verificaMail
				&& numTelefono && verificaCF && !verificaCFEsistente) {
			String passC = s.encrypt(pass);
			ApplicationController.params.put("username", user);
			ApplicationController.params.put("password", passC);
			ApplicationController.params.put("cognome", cogn);
			ApplicationController.params.put("nome", nom);
			ApplicationController.params.put("luogoDiNascita", luogoNascita);
			ApplicationController.params.put("dataDiNascita", dataDiNascita
					.getValue().toString());
			ApplicationController.params.put("sesso", sesso.getText());
			ApplicationController.params.put("codiceFiscale", cf);

			ApplicationController.params.put("email", mail);
			ApplicationController.params.put("telefono", tel);

			if (login.getStato().equalsIgnoreCase(AGGIUNGI)) {
				frontController.dispatchRequest(REGISTRA);

				controlli.alertSuccesso("REGISTRAZIONE ");

			} else if (login.getStato().equalsIgnoreCase(MODIFICA)) {

				if (!pass.isEmpty() || !conf.isEmpty()) {
					lunghezze = controlli.controlloLunghezza(password,
							confermaPass);
				} else {
					ApplicationController.params.replace("password",
							s.encrypt(password_Corrente.getText()));
				}

				// front controller per la modifica
				frontController.dispatchRequest(MODIFICA_CLIENTE);
				controlli.alertSuccesso("MODIFICA ");

			}

			ApplicationController.params.clear();
		}
	}

	/**
	 * Permette di eliminare, una volta ricercato, un cliente in modo definitivo dal sistema
	 * @param event
	 * 		l'evento del pulsante
	 * @throws IOException
	 * 		se la schemata non è stata caricata correttamente
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	@FXML
	public void elimina(ActionEvent event) throws IOException, SQLException {

		ApplicationController.params.put("username", username.getText()
				.toUpperCase().trim());
		ApplicationController.params.put("codiceFiscale", codiceFiscale
				.getText().toUpperCase().trim());
		frontController.dispatchRequest("eliminaCliente");
		controlli.alertSuccesso("ELIMINAZIONE ");
		ApplicationController.params.clear();
	}

	private void riempiCliente() {

		Cliente c = (Cliente) ApplicationController.risultati.get(0);

		nome.setText(c.getNome());
		cognome.setText(c.getCognome());

		if (c.getSesso().equalsIgnoreCase("M")) {
			sessoM.setSelected(true);
		} else {
			sessoF.setSelected(true);
		}

		luogoDiNascita.setText(c.getLuogoNascita());

		String date = c.getDataNascita();
		String[] tmp = date.split("-");
		int year = Integer.parseInt(tmp[0]);
		int month = Integer.parseInt(tmp[1]);
		int day = Integer.parseInt(tmp[2]);
		LocalDate data = LocalDate.of(year, month, day);
		dataDiNascita.setValue(data);

		codiceFiscale.setText(c.getCodFisc());
		telefono.setText(c.getTelefono());
		email.setText(c.getEmail());
		username.setText(c.getUsername());

		try {
			password_Corrente.setText(s.decrypt(c.getPassword()));
		} catch (Exception e) {
			e.getMessage();
		}

		ApplicationController.risultati.clear();

	}

	private void visualizzazioneCliente() {

		username.setEditable(false);
		password_Corrente.setEditable(false);

		nome.setEditable(false);
		cognome.setEditable(false);
		luogoDiNascita.setEditable(false);
		dataDiNascita.setEditable(false);
		codiceFiscale.setEditable(false);
		telefono.setEditable(false);
		email.setEditable(false);
		confermaPassLabel.setVisible(false);
		confermaPass.setVisible(false);
		passwordLabel.setVisible(false);
		password.setVisible(false);
		annulla.setVisible(false);
		conferma.setVisible(false);

	}

	private void modificaCliente() {

		username.setEditable(false);
		password_Corrente.setEditable(false);

		nome.setEditable(false);
		cognome.setEditable(false);

		luogoDiNascita.setEditable(false);
		dataDiNascita.setEditable(false);
		codiceFiscale.setEditable(false);

		annulla.setVisible(false);

	}

	private void inizializzaRegistrazioneCliente() {

		password_CorrenteLabel.setVisible(false);
		password_Corrente.setVisible(false);

	}

	@FXML
	private void switchSesso(ActionEvent event) {
		if (Login.getStato().equalsIgnoreCase(VISUALIZZA)
				|| Login.getStato().equalsIgnoreCase(ELIMINA)
				|| (Login.getStato().equalsIgnoreCase(MODIFICA) && Login
						.getAmmCliente() == Login.CLIENTE)) {
			if (sessoM.isSelected()) {
				sessoM.setSelected(false);
				sessoF.setSelected(true);
			} else {
				sessoM.setSelected(true);
				sessoF.setSelected(false);
			}
		}
	}
}
