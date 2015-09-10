package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import presentation.controller.ApplicationController;

/**
 * Classe che permette di manipolare i dati relativi alle autovetture
 * @author Sergio
 *
 */
public class DaoVetture extends DaoService {

	private final String QUERY_TARGA_ESISTENTE = "SELECT * FROM vetture WHERE targa = ?;";
	//private final String REGISTRAZIONE_VETTURA = "INSERT INTO `CarLoan`.`vetture` (`targa`, `marca`, `modello`, `cilindrata`, `cambio`, `ac`, `posti`, `dataImm`, `scadAssicur`, `alimentazione`, `stato`, `km`, `FascecodFascia`, `AgenziecodAgenzia`) VALUES ('AS178DC', 'FIAT', 'PUNTO', '2.0', 'MANUALE', 'SI', '5', '1999-05-20', '2015-10-10', 'DIESEL', 'DISPONIBILE', '12000', 'A', '1');";
	private final String REGISTRAZIONE = "INSERT INTO `CarLoan`.`vetture` (`targa`, `marca`, `modello`, `cilindrata`, `cambio`, `ac`, `posti`, `dataImm`, `scadAssicur`, `alimentazione`, `stato`, `km`, `AgenziecodAgenzia`, `FascecodFascia`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	public DaoVetture() {
		super();
	}

	/**
	 * Permette di inserire una nuova vettura 
	 * @throws SQLException
	 * 		se la connessione non è presente
	 */
	public void registrazione() throws SQLException {

		PreparedStatement registrazione = null;

		try {
			registrazione = connessione.prepareStatement(REGISTRAZIONE);
			
			int index = 1;
			registrazione.setString(index++, (String) ApplicationController.params.get("targa"));
			registrazione.setString(index++, (String) ApplicationController.params.get("marca"));
			registrazione.setString(index++, (String) ApplicationController.params.get("modello"));
			registrazione.setString(index++, (String) ApplicationController.params.get("cilindrata"));
			registrazione.setString(index++, (String) ApplicationController.params.get("cambio"));
			registrazione.setString(index++, (String) ApplicationController.params.get("ac"));
			registrazione.setString(index++, (String) ApplicationController.params.get("posti"));
			registrazione.setString(index++, (String) ApplicationController.params.get("dataImm"));
			registrazione.setString(index++, (String) ApplicationController.params.get("dataScadenzaAss"));
			registrazione.setString(index++, (String) ApplicationController.params.get("alimentazione"));
			registrazione.setString(index++, (String) ApplicationController.params.get("stato"));
			registrazione.setString(index++, (String) ApplicationController.params.get("km"));
			registrazione.setString(index++, (String) ApplicationController.params.get("agenzia"));
			registrazione.setString(index++, (String) ApplicationController.params.get("fascia"));
			

			registrazione.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Permette di ricercare una targa nel DB
	 * @param targa
	 * 		la targa da ricercare
	 * @return
	 * 		il risultato della ricerca
	 */
	public boolean targaEsistente(String targa) {
		PreparedStatement query = null;
		boolean esistente = false;
		try {

			query = connessione.prepareStatement(QUERY_TARGA_ESISTENTE);

			query.setString(1, targa);

			ResultSet results = query.executeQuery();

			if (results.next()) {
				esistente = true;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return esistente;
	}
}
