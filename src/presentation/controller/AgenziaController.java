package presentation.controller;

import business.entity.Agenzia;
import presentation.Login;
import utilita.controlli_e_sicurezza.Sicurezza;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller per la schermate Agenzia dove verranno implementati e tutte le azioni del relativo
 * file fxml
 * @author Sergio
 *
 */
public class AgenziaController {

	@FXML
	private TextField nome;
	@FXML
	private TextField indirizzo;
	@FXML
	private TextField citta;
	@FXML
	private TextField pIva;

	@FXML
	private TextField email;
	@FXML
	private TextField telefono;
	@FXML
	private Button conferma;
	@FXML
	private Button annulla;
	@FXML
	private Button elimina;
	@FXML
	private Label codice_agenziaLabel;
	@FXML
	private TextField codice_agenzia;

	private final String AGGIUNGI = "aggiungi";
	private final String MODIFICA = "modifica";
	private final String VISUALIZZA = "visualizza";
	private final String ELIMINA = "elimina";
	private final String ACCESSO_AMMINISTRATORE = "accessoAmministratore";
	private final String LOGOUT = "logout";
	private final String REGISTRA = "registra";
	private final String MODIFICA_CLIENTE = "modificaCliente";
	private Sicurezza s;

	/**
	 * Chiamato per inizializzare il controllo dopo che la schermata è stata visualizzata
	 */
	@FXML
	void initialize() {

		elimina.setVisible(false);
		
		

		if (Login.getStato().equalsIgnoreCase(AGGIUNGI)) {
			inizializzaAggiuntaAgenzia();

		} else {

			riempiAgenzia();
	 
			if (Login.getStato().equalsIgnoreCase(MODIFICA)
				  ) {

				modificaAgenzia();
			} else {
				 
				if (Login.getStato().equalsIgnoreCase(VISUALIZZA)
						|| Login.getStato().equalsIgnoreCase(ELIMINA)) {

					visualizzazioneAgenzia();

					if (Login.getStato().equalsIgnoreCase(ELIMINA)) {
						elimina.setVisible(true);
					}
				}
			}
		}
	}
	
/*
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
*/
	
	private void riempiAgenzia() {

		Agenzia agenzia = (Agenzia) ApplicationController.params.get("agenzia");

		this.codice_agenzia.setText(agenzia.getCodAgenzia());
		this.nome.setText(agenzia.getNome());
		this.indirizzo.setText(agenzia.getIndirizzo());
		this.citta.setText(agenzia.getCitta());
		this.email.setText(agenzia.getEmail());
		this.telefono.setText(agenzia.getTelefono());
		this.pIva.setText(agenzia.getpIva());
	 
		ApplicationController.params.clear();
	}

	private void visualizzazioneAgenzia() {

		codice_agenzia.setEditable(false);
		nome.setEditable(false);
		indirizzo.setEditable(false);
		citta.setEditable(false);
		pIva.setEditable(false);
		email.setEditable(false);
		telefono.setEditable(false);
		annulla.setVisible(false);
		conferma.setVisible(false);
		
	}

	private void modificaAgenzia() {

		codice_agenzia.setEditable(false);
		annulla.setVisible(false);

	}

	private void inizializzaAggiuntaAgenzia() {

		codice_agenziaLabel.setVisible(false);
		codice_agenzia.setVisible(false);

	}

}
