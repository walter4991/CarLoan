package presentation;

import java.io.IOException;
import java.sql.SQLException;

 
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Classe che si occuppa delle gestione delle interfacce
 * @author Sergio
 *
 */
public class ViewDispatcher {

	public ViewDispatcher() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cambia l'interfaccia del sistema
	 * @param path il percorso della nuova interfaccia
	 * @param app_stage la scena attuale
	 * @throws IOException
	 * 		se il path è errato
	 */
	public void setInterface(String path, Stage app_stage) throws IOException {

		Parent home_page_parent = FXMLLoader.load(getClass().getResource(path));
		Scene home_page_scene = new Scene(home_page_parent);

		app_stage.setScene(home_page_scene);

		app_stage.show();
	}

	/**
	 * Cambia solamente il pane centrale nelle interfacce del sistema
	 * @param path il percorso della nuova interfaccia
	 * @throws IOException
	 * 			se il path è errato
	 * @throws SQLException
	 */
	public void setPane(String path) throws IOException, SQLException {

		AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(path));
		AnchorPane actual = (AnchorPane) Login.getStage().getScene().getRoot();
		actual.getChildren().remove(0);
		actual.getChildren().add(0, anchorPane);
	}
}
