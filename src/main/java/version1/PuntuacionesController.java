package version1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class PuntuacionesController {

	PuntuacionesModel modelPuntuaciones = new PuntuacionesModel();
	
    @FXML
    private GridPane view;
    
    @FXML
    private ListView<String> listaPuntuaciones;
    
    @FXML
    private Button setStagePalabras;

    @FXML
    private Button setStagePartida;

    @FXML
    private Button setStagePuntuaciones;
    
	public PuntuacionesController()  throws IOException  {
		
		URL fxml = getClass().getResource("/fxml/PuntuacionesView.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(fxml);
		fxmlLoader.setController(this);
		fxmlLoader.load();
		
		setStagePalabras.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {
		    	App.setStagePalabras();
		   }
		});
		setStagePartida.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {
		    	App.setStagePartida();
		   }
		});
		
		updatePuntuaciones();
	}
	
	public void updatePuntuaciones() throws FileNotFoundException {
		listaPuntuaciones.getItems().clear();
		listaPuntuaciones.getItems().addAll(modelPuntuaciones.getPuntuaciones());
	}
	
	public GridPane getView() {
		return view;
	}
	
	public void nuevaPuntuacion(int intentos) throws IOException {
		modelPuntuaciones.addPuntuacion(intentos);
	}

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}