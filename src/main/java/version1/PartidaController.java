package version1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class PartidaController {

	PartidaModel modelPartida = new PartidaModel();
	
    @FXML
    private TextField textInput;
    
    @FXML
    private GridPane view;
    
    @FXML
    private Button setStagePalabras;

    @FXML
    private Button setStagePartida;

    @FXML
    private Button setStagePuntuaciones;
    
    @FXML
    private Text palabra;
    
    @FXML
    private Text vidas;
    
	public PartidaController() throws IOException {
		
		URL fxml = getClass().getResource("/fxml/PartidaView.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(fxml);
		fxmlLoader.setController(this);
		fxmlLoader.load();
		
		setStagePalabras.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {
		    	App.setStagePalabras();
		   }
		});
		setStagePuntuaciones.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {
		    	App.setStagePuntuaciones();
		    	
		   }
		});
		
		
	}
	
    @FXML
    void letraButton(ActionEvent event) {
    	
    	if(textInput.getText().length() == 1) {
    		
    		System.out.println("Correcto");
    		modelPartida.comprobarLetra(textInput.getText());
    		mostrarVidas();
    		palabraEnPantalla();
    		
    	}else {
    	    Alert alert = new Alert(Alert.AlertType.WARNING);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Error");
    	    alert.setContentText("Debes introducir un caracter");
    	    alert.showAndWait();
    	}
    }

    @FXML
    void palabraButton(ActionEvent event) throws IOException {
    	modelPartida.comprobarPalabra(textInput.getText());
    	mostrarVidas();
    }
	
	public void setPalabra(String palabra) {
		modelPartida.setPalabra(palabra);
	}
	
	public void palabraEnPantalla() {
		palabra.setText(modelPartida.getPalabraFormat());
	}
	   
	public GridPane getView() {
		return view;
	}
	
	public void mostrarVidas() {
		vidas.setText("Vidas: " + String.valueOf(modelPartida.getVidas()));
	}
	

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		

	}
}
