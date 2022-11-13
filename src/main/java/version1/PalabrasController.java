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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PalabrasController {

	PalabrasModel modelPalabras = new PalabrasModel();
	
    @FXML
    private TextField fieldAddPalabra;
    
    @FXML
    private GridPane view;
    
    @FXML
    private ListView <String> listViewPalabras;
    
    @FXML
    private Button setStagePalabras;

    @FXML
    private Button setStagePartida;

    @FXML
    private Button setStagePuntuaciones;
    
	public PalabrasController() throws IOException {
		
		URL fxml = getClass().getResource("/fxml/PalabrasView.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(fxml);
		fxmlLoader.setController(this);
		fxmlLoader.load();
		
		setStagePartida.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {
		    	App.setStagePalabras();
		    	
		   }
		});
		setStagePuntuaciones.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {
		    	App.setStagePuntuaciones();
		   }
		});
		
		
		updatePalabras();
		
	}
	

    @FXML
    void addPalabra(ActionEvent event) throws IOException {
    	System.out.println(fieldAddPalabra.getText());
    	modelPalabras.addPalabras(fieldAddPalabra.getText());
    	updatePalabras();
    }
    
    public String palabraRandom() {
    	return modelPalabras.getPalabraRandom();
    }
    
	public GridPane getView() {
		return view;
	}

	public void updatePalabras() throws FileNotFoundException {
		listViewPalabras.getItems().clear();
		listViewPalabras.getItems().addAll(modelPalabras.getPalabras());
	}
	public void initialize(URL location, ResourceBundle resources) {

		

	}
}