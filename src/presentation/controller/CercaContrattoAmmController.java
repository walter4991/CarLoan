package presentation.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Controller per la schermata cerca di contratto
 * @author Sergio
 *
 */
public class CercaContrattoAmmController {

	private FrontController frontController;

	public CercaContrattoAmmController() {
		frontController = new FrontController();
	}

	@FXML
	public void visualizzaContratto(ActionEvent event) throws IOException {

		frontController.dispatchRequest("visualizzaContrattoAmm");
	}
}
