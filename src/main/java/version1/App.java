package version1;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private static PartidaController controllerPartida;
	private static PalabrasController controllerPalabras;
	private static PuntuacionesController controllerPuntuaciones;
	private static Stage stages;
	@Override
	public void start(Stage stage) throws Exception {
		stages = new Stage();
		controllerPartida = new PartidaController();
		controllerPalabras = new PalabrasController();
		controllerPuntuaciones = new PuntuacionesController();
		
		

		stages.setScene(new Scene(controllerPartida.getView()));
		stages.setTitle("Ss");
		stages.sizeToScene();
		stages.show();
		controllerPartida.setPalabra(controllerPalabras.palabraRandom());
		controllerPartida.palabraEnPantalla();

	}

	public static void main(String[] args) {
		launch();
	}
	
	public static void setStagePalabras() {
		stages.setScene(new Scene(controllerPalabras.getView()));
		stages.show();
		System.out.println("App.setStagePalabras");
	}
	
	public static void setStagePuntuaciones() {
		stages.setScene(new Scene(controllerPuntuaciones.getView()));
		stages.show();
		System.out.println("App.setStagePalabras");
	}
	public static void setStagePartida() {
		stages.setScene(new Scene(controllerPartida.getView()));
		stages.show();
		System.out.println("App.setStagePalabras");
	}

	public static void nuevaPuntuacion(int intentos) throws IOException {
		controllerPuntuaciones.nuevaPuntuacion(intentos);
	}
}
