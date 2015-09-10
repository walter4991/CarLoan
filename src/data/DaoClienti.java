package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.entity.Cliente;
import presentation.Login;
import presentation.controller.ApplicationController;

/**
 * Classe che permette di manipolare i dati dei Clienti del sistema
 * @author Sergio
 *
 */
public class DaoClienti extends DaoService {

	private final String REGISTRAZIONE = "INSERT INTO `CarLoan`.`Clienti` (`nome`, `cognome`, `sesso`, `luogoNascita`, `dataNascita`, `CodFisc`, `telefono`,email) VALUES (? ,? ,?, ?, ?, ?, ?,?);";
	private final String REGISTRAZIONE_CREDENZIALI_CLIENTI = "INSERT INTO `CarLoan`.`Credenziali` (`username`, `password`, `tipo`,`Clienti_CodFisc`) VALUES (? ,? ,'1',?);";
	private final String QUERY_CF_ESISTENTE = "SELECT CodFisc FROM Clienti WHERE CodFisc = ?;";
	private final String QUERY_RICERCA_CODFIS = "SELECT username, password, nome, cognome, sesso, luogoNascita, dataNascita, CodFisc, telefono, email FROM Clienti JOIN Credenziali WHERE CodFisc=? AND Clienti_CodFisc = CodFisc  ;";
	private final String QUERY_RICERCA_USER = "SELECT username, password, nome, cognome, sesso, luogoNascita, dataNascita, CodFisc, telefono, email FROM Clienti JOIN Credenziali WHERE Clienti_CodFisc = CodFisc AND username = ?;";
	private final String QUERY_UPDATE_CLIENTE = "UPDATE Credenziali INNER JOIN Clienti ON Clienti_CodFisc= CodFisc SET password = ?, email=?, telefono=?  WHERE username = ? ;";
	private final String QUERY_UPDATE_AMM = "UPDATE Credenziali INNER JOIN Clienti ON Clienti_CodFisc= CodFisc SET nome=?, cognome=?,sesso=?,luogoNascita=?,dataNascita=?,CodFisc=?,password = ?, email=?, telefono=?  WHERE username = ? ;";

	private final String ELIMINAZIONE_CREDENZIALI = "DELETE FROM Credenziali WHERE   Clienti_CodFisc=?;";
	private final String ELIMINAZIONE_CLIENTI = "DELETE FROM Clienti WHERE   CodFisc=?;";

	public DaoClienti() {
		super();

	}

	/**
	 * Permette di inserire un nuovo utente al database
	 * @throws SQLException
	 * 			se la connessione non è presente
	 */
	public void registrazione() throws SQLException {

		PreparedStatement registrazione = null;
		PreparedStatement registrazioneCredenziali = null;

		try {

			registrazioneCredenziali = connessione
					.prepareStatement(REGISTRAZIONE_CREDENZIALI_CLIENTI);
			registrazione = connessione.prepareStatement(REGISTRAZIONE);

			registrazioneCredenziali.setString(1,
					(String) ApplicationController.params.get("username"));
			registrazioneCredenziali.setString(2,
					(String) ApplicationController.params.get("password"));
			registrazioneCredenziali.setString(3,
					(String) ApplicationController.params.get("codiceFiscale"));

			registrazione.setString(1,
					(String) ApplicationController.params.get("nome"));
			registrazione.setString(2,
					(String) ApplicationController.params.get("cognome"));
			registrazione.setString(3,
					(String) ApplicationController.params.get("sesso"));
			registrazione
					.setString(4, (String) ApplicationController.params
							.get("luogoDiNascita"));
			registrazione.setString(5,
					(String) ApplicationController.params.get("dataDiNascita"));
			registrazione.setString(7,
					(String) ApplicationController.params.get("telefono"));
			registrazione.setString(8,
					(String) ApplicationController.params.get("email"));

			registrazione.setString(6,
					(String) ApplicationController.params.get("codiceFiscale"));

			registrazione.execute();
			registrazioneCredenziali.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Permette di cercare un cliente mediante codice fiscale e leggerne i dati
	 * @return
	 * 		il risultato della ricerca
	 */
	public boolean cercaCF() {

		String user = "";
		String pass = "";
		String nome = "";
		String cognome = "";
		String sesso = "";
		String luogo = "";
		String dataNascita = "";
		String codFisc = "";
		String telefono = "";
		String email = "";
		boolean trovato = false;

		PreparedStatement ricercaCod = null;

		try {
			ricercaCod = connessione.prepareStatement(QUERY_RICERCA_CODFIS);
			ricercaCod.setString(1,
					(String) ApplicationController.params.get("codFis"));
			ResultSet resultsRicercaCod = ricercaCod.executeQuery();

			if (resultsRicercaCod.next()) {
				user = resultsRicercaCod.getString("username");
				pass = resultsRicercaCod.getString("password");
				nome = resultsRicercaCod.getString("nome");
				cognome = resultsRicercaCod.getString("cognome");
				sesso = resultsRicercaCod.getString("sesso");
				luogo = resultsRicercaCod.getString("luogoNascita");
				dataNascita = resultsRicercaCod.getString("dataNascita");
				codFisc = resultsRicercaCod.getString("codFisc");
				telefono = resultsRicercaCod.getString("telefono");
				email = resultsRicercaCod.getString("email");
				trovato = true;
			}

			Cliente c = new Cliente(user, pass, nome, cognome, sesso, luogo,
					dataNascita, codFisc, telefono, email);
			ApplicationController.risultati.add(c);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trovato;
	}

	/**
	 * Permette di cercare un cliente mediante l'username e leggerne i dati
	 * @return
	 * 		il risultato della ricerca
	 */
	public boolean cercaUSER() {
		String user = "";
		String pass = "";
		String nome = "";
		String cognome = "";
		String sesso = "";
		String luogo = "";
		String dataNascita = "";
		String codFisc = "";
		String telefono = "";
		String email = "";

		boolean trovato = false;

		PreparedStatement ricercaUser = null;

		try {
			ricercaUser = connessione.prepareStatement(QUERY_RICERCA_USER);
			ricercaUser.setString(1,
					(String) ApplicationController.params.get("username"));
			ResultSet resultsRicercaUser = ricercaUser.executeQuery();

			if (resultsRicercaUser.next()) {
				user = resultsRicercaUser.getString("username");
				pass = resultsRicercaUser.getString("password");
				nome = resultsRicercaUser.getString("nome");
				cognome = resultsRicercaUser.getString("cognome");
				sesso = resultsRicercaUser.getString("sesso");
				luogo = resultsRicercaUser.getString("luogoNascita");
				dataNascita = resultsRicercaUser.getString("dataNascita");
				codFisc = resultsRicercaUser.getString("codFisc");
				telefono = resultsRicercaUser.getString("telefono");
				email = resultsRicercaUser.getString("email");
				trovato = true;
			}

			Cliente c = new Cliente(user, pass, nome, cognome, sesso, luogo,
					dataNascita, codFisc, telefono, email);
			ApplicationController.risultati.add(c);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trovato;
	}

	/**
	 * Permette di ricercare un codice fiscale 
	 * @param cf
	 * 		il codice fiscale da ricercare 
	 * @return
	 * 		il risultato della ricerca
	 */
	public boolean cfEsistente(String cf) {
		PreparedStatement query = null;
		boolean esistente = false;
		try {

			query = connessione.prepareStatement(QUERY_CF_ESISTENTE);

			query.setString(1, cf);

			ResultSet resultsCFEsistente = query.executeQuery();

			if (resultsCFEsistente.next()) {
				esistente = true;

			} else {
				esistente = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esistente;
	}

	/**
	 * Permette di modificare i dati relativi a un cliente
	 */
	public void modifica() {
		PreparedStatement updateCliente = null;
		PreparedStatement updateAmm = null;

		try {
			if (Login.getAmmCliente() == Login.AMMINISTRATORE) {
				updateAmm = connessione.prepareStatement(QUERY_UPDATE_AMM);

				updateAmm.setString(1,
						(String) ApplicationController.params.get("nome"));
				updateAmm.setString(2,
						(String) ApplicationController.params.get("cognome"));
				updateAmm.setString(3,
						(String) ApplicationController.params.get("sesso"));
				updateAmm.setString(4, (String) ApplicationController.params
						.get("luogoDiNascita"));
				updateAmm.setString(5, (String) ApplicationController.params
						.get("dataDiNascita"));
				updateAmm.setString(6, (String) ApplicationController.params
						.get("codiceFiscale"));
				updateAmm.setString(7,
						(String) ApplicationController.params.get("password"));
				updateAmm.setString(8,
						(String) ApplicationController.params.get("email"));
				updateAmm.setString(9,
						(String) ApplicationController.params.get("telefono"));

				updateAmm.setString(10,
						(String) ApplicationController.params.get("username"));

				updateAmm.execute();

			} else {

				updateCliente = connessione
						.prepareStatement(QUERY_UPDATE_CLIENTE);
				updateCliente.setString(1,
						(String) ApplicationController.params.get("password"));

				updateCliente.setString(2,
						(String) ApplicationController.params.get("email"));

				updateCliente.setString(3,
						(String) ApplicationController.params.get("telefono"));

				updateCliente.setString(4,
						(String) ApplicationController.params.get("username"));

				updateCliente.execute();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Permette di eliminare i dati relativi a un cliente
	 * @throws SQLException
	 * 			se la connessione non è presente
	 */
	public void elimina() throws SQLException {
		PreparedStatement eliminaClienteCredenziali = null;
		PreparedStatement eliminaClienteClienti = null;

		try {

			eliminaClienteCredenziali = connessione
					.prepareStatement(ELIMINAZIONE_CREDENZIALI);

			eliminaClienteClienti = connessione
					.prepareStatement(ELIMINAZIONE_CLIENTI);

			eliminaClienteCredenziali.setString(1,
					(String) ApplicationController.params.get("username"));

			eliminaClienteClienti.setString(1,
					(String) ApplicationController.params.get("codiceFiscale"));

			eliminaClienteCredenziali.execute();

			eliminaClienteClienti.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
