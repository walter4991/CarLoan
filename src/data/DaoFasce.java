package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe che permette di manipolare i dati relativi a una fascia
 * @author Sergio
 *
 */
public class DaoFasce extends DaoService {
	private final String FASCE = "SELECT DISTINCT codFascia FROM CarLoan.Fasce; ";

	public DaoFasce() {
		super();
	}

	/**
	 * Permette di leggere i dati relativi alle fasce di autovetture
	 * @return
	 * 		la lista delle fasce
	 * @throws SQLException
	 * 			se la connessione non è presente
	 */
	public ArrayList<String> tutteFasce() throws SQLException {
		PreparedStatement fasce = null;
		ArrayList<String> fasceList = new ArrayList<String>();
		fasce = connessione.prepareStatement(FASCE);

		ResultSet risultati = fasce.executeQuery();

		while (risultati.next()) {
			fasceList.add(risultati.getString("codFascia"));
		}
		return fasceList;
	}
}
