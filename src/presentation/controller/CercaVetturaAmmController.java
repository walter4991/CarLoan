package presentation.controller;

import java.io.IOException;

import presentation.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Controller per la schermata cerca di vettura 
 * @author Sergio
 *
 */
public class CercaVetturaAmmController {

	private FrontController frontController;

	public CercaVetturaAmmController() {
		frontController = new FrontController();
	}

	@FXML
	public void visualizza(ActionEvent event) throws IOException {

		if (Login.getStato().equals("visualizza"))
			frontController.dispatchRequest("visualizzaVetturaAmm");
		else if (Login.getStato().equals("modifica"))
			frontController.dispatchRequest("modificaVettura");
		else if (Login.getStato().equals("elimina"))
			frontController.dispatchRequest("eliminaVettura");
	}
}
