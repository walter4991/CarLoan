package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Classe principale peemette l'esecuzione del sistema
 * @author Sergio
 *
 */
public class Login extends Application {

	/**
	 * Serve per tenere traccia della scena corrente
	 */
	private static Stage scena = null;
	/**
	 * Intero che indica chi è loggato nel sistema
	 * 0 se è amministratore
	 * 1 se è cliente
	 * -1 default
	 */
	private static int ammCliente = -1;
	/**
	 * String per tenere traccia dello stato della ricerca ovvero se stiamo visualizzando, 
	 * eliminando o modificando
	 */
	private static String statoRicerca = null;
	/**
	 * Un numero intero che rappresenta un' amministratore nel sistema
	 */
	public static final int AMMINISTRATORE = 0;
	/**
	 * Un numero intero che rappresenta un cliente nel sistema
	 */
	public static final int CLIENTE = 1;

	/**
	 * Lancia in esecuzione il sistema
	 */
	public void show() {
		launch();
	}

	/**
	 * Carica la schermtata principale, setta la scena corrente,
	 * imposta i vari attributi e infine la mostra 
	 */
	@Override
	public void start(Stage stage) throws IOException {
		Login.setScena(stage);

		Parent root = FXMLLoader.load(getClass().getResource(
				"schermate/Login.fxml"));

		Scene scene = new Scene(root);

		stage.setTitle("Benvenuto in CarLoan");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * restuisce la scena corrente
	 * @return
	 * 		la scena corrente
	 */
	public static Stage getStage() {
		return getScena();
	}

	/**
	 * setta la scena in modo da tenerla sempre aggiornata
	 * @param stage
	 * 		la scena corrente
	 */
	public static void setStage(Stage stage) {
		Login.setScena(stage);
	}

	/**
	 * restituisce l'utente loggato nel sistema
	 * @return
	 * 		1 se è cliente
	 * 		0 se è amministratore
	 * 		-1 default
	 */
	public static int getAmmCliente() {
		return ammCliente;
	}

	/**
	 * setta la variabile di log in base a chi è loggato nel sistema
	 * @param ammCliente
	 * 		1 se è cliente
	 * 		0 se è amministratore
	 * 		-1 default
	 */
	public static void setAmmCliente(int ammCliente) {
		Login.ammCliente = ammCliente;
	}

	/**
	 * restituisce la scena corrente
	 * @return
	 * 		la scena corrente
	 */
	public static Stage getScena() {
		return scena;
	}

	/**
	 * setta la scena corrente
	 * @param scena
	 * 		la scena corrente
	 */
	public static void setScena(Stage scena) {
		Login.scena = scena;
	}

	/**
	 * restituisce lo stato della ricerca: 
	 * visualizza, modifica o elimina in base all'azione che stiamo compiendo
	 * @return
	 * 		l'azione da compiere
	 */
	public static String getStato() {
		return statoRicerca;
	}

	/**
	 * setta lo stato della ricerca: 
	 * visualizza, modifica o elimina in base all'azione che stiamo compiendo
	 * @param stato
	 * 		l'azione da compiere
	 */
	public static void setStato(String stato) {
		statoRicerca = stato;
	}
}
