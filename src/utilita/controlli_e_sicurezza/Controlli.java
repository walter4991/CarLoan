package utilita.controlli_e_sicurezza;

import java.time.LocalDate;
 


import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import data.DaoClienti;
import data.DaoLogin;
import data.DaoPrenotazioni;
import data.DaoVetture;

/**
 * Classe che permette di effettuare tutti i controlli necessari al sistema
 * @author Sergio
 *
 */
public class Controlli {

	/*private*/ final String ERROR_TELEFONO = "Controlla il NUMERO DI TELEFONO! Dev' essere di 10 cifre, ognuna compresa tra 0 e 9! ";
	/*private*/ final String ERROR_KM = "Controlla i CHILOMETRI! Dev' essere minimo di una cifra massimo di 6! ";
	/*private*/ final String ERROR_EMAIL = "Controlla L'INDIRIZZO E-MAIL! Dev'essere del formato indirizzo@dominio.estensione! ";
	/*private*/ final String ERROR_DATADINASCITA = "controlla che la DATA DI NASCITA sia esatta! ";
	/*private*/ final String CONTROLLO_MAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	/*private*/ final String CONTROLLO_TELEFONO = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
	/*private*/ final String CONTROLLO_KM = "[0-9]{1,6}";
	/*private*/ final String CONTROLLO_CF = "[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]";
	/*private*/ final String ERROR_CF = "codice fiscale non corretto!";
	/*private*/ final String ERROR_CF_ESISTENTE = "codice fiscale GIA' ESISTENTE";
	/*private*/ final String CONTROLLO_TARGA = "[a-z,A-Z]{2}[0-9]{3}[a-z,A-Z]{2}";
	/*private*/ final String ERROR_TARGA = "targa vettura non corretta!";
	/*private*/ final String ERROR_TARGA_ESISTENTE = "TARGA GIA' ESISTENTE";
	/*private*/ final String USER_ESISTENTE = "USERNAME GIA' ESISTENTE! ";
	/*private*/ final String CAMPO_SESSO_VUOTO = "BISOGNA SELEZIONARE, NECESSARIAMENTE, UN SESSO!";
	/*private*/ final String CAMPO_AC_VUOTO = "BISOGNA SELEZIONARE, NECESSARIAMENTE, SE LA VETTURA PRESENTA L'ARIA CONDIZIONATA!";
	/*private*/ final String CAMPO_NULLO = "CAMPO VUOTO: ";
	final String PRENOTAZIONE_NON_TROVATA = "PRENOTAZIONE NON PRESENTE NEL SISTEMA";
	/*private*/ final int ETA_MINIMA_REGISTRAZIONE = 18;
	/*private*/ final int gg = LocalDate.now().getDayOfMonth();
	/*private*/ final  int mm = LocalDate.now().getMonthValue();
	/*private*/ final  int aaaa = LocalDate.now().getYear() - ETA_MINIMA_REGISTRAZIONE;
	/*private*/ final String ERROR_DATA_NASCITA = "PER REGISTRARTI AL SISTEMA DEVI AVERE PIï¿½ DI 18 ANNI!";

	/*private*/ final String ERROR_DATA_IMM = "INSERISCI UNA DATA DI IMMATRICOLAZIONE VALIDA! PRIMA DI OGGI!";

	/*private*/ final String SUCCESSO = "AVVENUTA CON SUCCESSO! ";

	private DaoClienti daoC;
	private DaoLogin daoL;
	private DaoPrenotazioni daoP;
	

	private GestioneAlert ga;
	private final int LUNGHEZZA_CF = 16;

	/**
	 * Costruisce un istanza della classe controlli
	 */
	public Controlli() {
		ga = new GestioneAlert();
		daoL = new DaoLogin();
	}

	/**
	 * Permette di controllare se il numero di telefono è in formato corretto 
	 * altrimenti genera un alert
	 * @param numeri
	 * 		il numero di telefono
	 * @return
	 * 		true se è corretto 
	 * 		false altrimenti
	 */
	public boolean controlloTelefono(String numeri) {
		if (!numeri.matches(CONTROLLO_TELEFONO)) {
			ga.alertErrore(ERROR_TELEFONO);
			return false;
		}
		return true;
	}

	/**
	 * Permette di controllare il formato dei chilometri inseriti in una vettura
	 * generando un alert in caso contrario
	 * @param km
	 * 		i chilometri della vettura
	 * @return
	 * 		true se è corretto 
	 * 		false altrimenti
	 */
	public boolean controlloChilometri(String km) {

		boolean controlloKM = true;
		if (!km.matches(CONTROLLO_KM)) {
			ga.alertErrore(ERROR_KM);
			controlloKM = false;
		}
		return controlloKM;
	}

	/**
	 * Permette di controllare il formato della email generando un alert in caso contrario
	 * @param e_mail
	 * 		email da controllare
	 * @return
	 * 		true se è corretto
	 * 		false altrimenti
	 */
	public boolean email(String e_mail) {
		if (!e_mail.matches(CONTROLLO_MAIL)) {
			ga.alertErrore(ERROR_EMAIL);
			return false;
		}
		return true;
	}

	/**
	 * Genera un alert per un errore sulla data di nascita
	 */
	public void alertdataDiNascita() {

		ga.alertErrore(ERROR_DATADINASCITA);

	}

	/**
	 * Permette di controllare se un codice fiscale di un utente è presente nel sistema
	 * generando un alert se esso è presente
	 * @param cf
	 * 		il codice fiscale da ricercare
	 * @return
	 * 		true se è presente
	 * 		false altrimenti
	 */
	public boolean controlloCFEsistente(String cf) {
		// [a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]

		boolean esiste = false;

		daoC = new DaoClienti();
		esiste = daoC.cfEsistente(cf);

		if (esiste) {
			ga.alertErrore(ERROR_CF_ESISTENTE);
		}
		return esiste;

	}

	/**
	 * Permette di controllare se il codice fiscale è in formato corretto generando un alert in 
	 * caso contrario
	 * @param cf
	 * 		il codice fiscale da ritornare
	 * @return
	 * 		true se è corretto
	 * 		false altrimenti
	 */
	public boolean controlloCF(String cf) {
		// [a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]
		boolean esatto = true;

		if (cf.length() == LUNGHEZZA_CF) {
			if (!cf.matches(CONTROLLO_CF)) {

				esatto = false;
			}
		} else {
			esatto = false;
		}
		if (!esatto) {
			ga.alertErrore(ERROR_CF);
		}

		return esatto;
	}

	/**
	 * Permette di controllate se la targa è in formato corretto generando un aler in caso contrario
	 * @param targa
	 * 		la targa da ricercare
	 * @return
	 * 		true se è corretto
	 * 		false altrimenti
	 */
	public boolean controlloTarga(String targa) {
		boolean controlloTarga = true;
		if (!targa.matches(CONTROLLO_TARGA)) {

			ga.alertErrore(ERROR_TARGA);
			controlloTarga = false;
		}
		return controlloTarga;
	}

	/**
	 * Permette di controllare se una targa di un'autovettura è presente nel sistema
	 * generando un alert se essa è presente
	 * @param targa
	 * 		la targa da ricercare
	 * @return
	 * 		true se è presente
	 * 		false altrimenti
	 */
	public boolean controlloTargaEsistente(String targa) {
		// [a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]

		boolean esiste = false;
		DaoVetture controlloTarga = new DaoVetture();
		esiste = controlloTarga.targaEsistente(targa);

		if (esiste) {
			ga.alertErrore(ERROR_TARGA_ESISTENTE);
		}
		return esiste;
	}

	/**
	 * Permette di controllare la lunghezza delle stringhe in modo da non essere vuote o 
	 * superiori a 30 caratteri, in caso di errori genera un alert
	 * @param parametri
	 * 		una serie di TextField da cui controllare la lunghezza del testo
	 * @return
	 * 		true se ci sono errori 
	 * 		false altrimenti
	 */
	public boolean controlloLunghezza(TextField... parametri) {

		String messaggioErrore = "I campi: \n";
		boolean errore = false;

		for (TextField s : parametri)
			if (s.getText().trim().length() > 30
					|| s.getText().trim().isEmpty()) {
				messaggioErrore += "\n" + s.getId().toUpperCase();
				errore = true;
			}

		messaggioErrore += "\n\ndevono essere compresi tra 0 e 30 caratteri";

		if (errore) {
			ga.alertErrore(messaggioErrore);
		}

		return errore;
	}

	/**
	 * Permette di controllare che due stringhe siamo coincidenti, generando un alert in caso contrario
	 * @param nuova
	 * 		la prima stringa
	 * @param conf
	 * 		la seconda stringa
	 * @return
	 * 		true se sono conincidenti
	 * 		false altrimenti
	 */
	public boolean controlloStringheCoincidenti(String nuova, String conf) {
		boolean giuste = true;

		if (!nuova.equalsIgnoreCase(conf)) {
			giuste = false;
		}

		if (!giuste) {
			ga.alertErrore("LE PASSWORD NON COMBACIANO");
		}
		return giuste;
	}

	/**
	 * Permette di controllare se un username è gia presente nel sistema generando così
	 * un alert
	 * @param username
	 * 		l'username da cercare
	 * @return
	 * 		true se è presente
	 * 		false altrimenti
	 */
	public boolean usernameEsistente(String username) {
		boolean esistente = false;
		if (daoL.usernameEsistente(username)) {
			esistente = true;
			ga.alertErrore(USER_ESISTENTE);
		}

		return esistente;
	}

	// va messo nel oggettonull
	/**
	 * Verifica che l'oggetto non sia null, generando un alert in caso contrario
	 * @param sesso
	 * 		l'oggetto da controllare
	 * @return
	 * 		true se non è null
	 * 		false altrimenti
	 */
	public boolean verificaSesso(RadioButton sesso) {
		boolean verificaSesso = true;
		if (sesso == null) {
			ga.alertErrore(CAMPO_SESSO_VUOTO);
			verificaSesso = false;
		}
		return verificaSesso;

	}

	// va messo nel oggettonull
	/**
	 * Verifica che l'oggetto non sia null, generando un alert in caso contrario
	 * @param ac
	 * 		l'oggetto da controllare
	 * @return
	 * 		true se non è null
	 * 		false altrimenti
	 */
	public boolean verificaAC(RadioButton ac) {
		boolean verificaAC = true;
		if (ac == null) {
			ga.alertErrore(CAMPO_AC_VUOTO);
			verificaAC = false;
		}
		return verificaAC;

	}

	/**
	 * Permette di controllare che un utente sia maggiorenne generando un alert in caso contrario
	 * @param dataNascita
	 * 		la data da controllare
	 * @return
	 * 		true se è maggiorenne
	 * 		false altrimenti
	 */
	public boolean dataNascitaEsatta(DatePicker dataNascita) {
		boolean verificaDataNascita = true;

		if (dataNascita.getValue() != null) {

			LocalDate dataDiNascita = dataNascita.getValue();
			if (dataDiNascita.isAfter(LocalDate.now())
					|| (dataDiNascita.isAfter(LocalDate.of(aaaa, mm, gg)))) {

				verificaDataNascita = false;

			}
		} else {
			verificaDataNascita = false;
		}

		if (!verificaDataNascita) {
			ga.alertErrore(ERROR_DATA_NASCITA);
		}
		return verificaDataNascita;
	}

	/**
	 * Genera un alert informando l'utente che un operazione è stata eseguita
	 * @param stringa
	 * 		il messaggio da visualizzare nell'alert
	 */
	public void alertSuccesso(String stringa) {
		ga.alertInformativo(stringa + SUCCESSO);
	}

	/**
	 * Permette di verificare se un oggetto non è null generando un alert altrimenti
	 * @param oggetto
	 * 		l'oggetto da controllare
	 * @param messaggio
	 * 		il messaggio da visualizzare nell'alert
	 * @return
	 * 		true se l'oggetto è null
	 * 		false altrimenti
	 */
	public boolean oggettoNull(Object oggetto, String messaggio) {
		boolean verifica = false;
		if (oggetto == null) {
			ga.alertErrore(CAMPO_NULLO + messaggio);
			verifica = true;
		}
		return verifica;
	}

	/**
	 * Permette di verificare che la data di immatricolazione di una vettura 
	 * sia inferiore alla data corrente, generando un alert in caso di errore
	 * @param dataImm
	 * 		la data da controllare
	 * @return
	 * 		true se è corretta 
	 * 		false altrimenti
	 */
	public boolean dataImmEsatta(DatePicker dataImm) {
		boolean verificaImm = true;

		if (dataImm.getValue() != null) {

			LocalDate dataImmatricolazione = dataImm.getValue();
			if (dataImmatricolazione.isAfter(LocalDate.now())) {

				verificaImm = false;

			}
		} else {
			verificaImm = false;
		}

		if (!verificaImm) {
			ga.alertErrore(ERROR_DATA_IMM);
		}
		return verificaImm;
	}
	
	/**
	 * Permette di controllare se una prenotazione è presente nel sistema generando un alert in caso 
	 * negativo
	 * @param codPrenotazione
	 * 		il codice della prenotazione da ricercare
	 * @return
	 * 		true se è presente 
	 * 		false altrimenti
	 */
	public boolean prenotazioneCerca (String codPrenotazione) {
		boolean trovato = false;
		
		daoP = new DaoPrenotazioni();
		trovato = daoP.controlloPrenotazioneEsistente(codPrenotazione);
		
		if(!trovato){
			ga.alertInformativo(PRENOTAZIONE_NON_TROVATA);
		}
		return trovato;
	}
	
	public boolean cfCerca(String cf) {
		boolean trovato = false;
		
		daoC = new DaoClienti();
		
		trovato = daoC.cfEsistente(cf);
		
		if(!trovato) {
			ga.alertInformativo(PRENOTAZIONE_NON_TROVATA);
		}
		
		return trovato;
	}
}
