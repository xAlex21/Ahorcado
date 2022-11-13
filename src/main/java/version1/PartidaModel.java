package version1;

import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.control.Alert;

public class PartidaModel {

	private String palabra;
	private String palabraFormat = "";
	private int vidas = 11;
	private int intentos = 0;
	public void setPalabra(String palabra) {
		this.palabra = palabra;
		this.formatPalabra();
	}
	
	public String getPalabra() {
		return this.palabra;
	}
	
	public String getPalabraFormat() {
		return this.palabraFormat;
	}
	
	public void comprobarPalabra(String palabra) throws IOException {
		if(palabra.equalsIgnoreCase(this.palabra)) {
			App.nuevaPuntuacion(intentos);
		    Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    alert.setHeaderText(null);
		    alert.setTitle("Info");
		    alert.setContentText("Has ganado la partida");
		    alert.showAndWait();
		    System.exit(0);
		}else {
			restarVida();
			aumentarIntentos();
		}
	}
	
	public boolean comprobarLetra(String letra) {
		String caracter;
		if(this.palabra.toLowerCase().contains(letra.toLowerCase())) {
			System.out.println("Contiene La letra");
			ArrayList prueba = new ArrayList();
			char caract = letra.charAt(0);
			for(int i = 0; i < this.palabra.length(); i++) {
				
				System.out.println(palabra.charAt(i));
				
				caracter = "" + palabra.charAt(i);
				
				if(caracter.equalsIgnoreCase(letra.toLowerCase())){
					prueba.add(i);
					System.out.println("Agregando a array");
				}
			}
			aumentarIntentos();
			reformatPalabra(prueba, caract);
			System.out.println(prueba);
			return true;
		}else {
			
			restarVida();
			aumentarIntentos();
			if(vidas == 0) {
			    Alert alert = new Alert(Alert.AlertType.WARNING);
			    alert.setHeaderText(null);
			    alert.setTitle("Info");
			    alert.setContentText("Has perdido la partida");
			    alert.showAndWait();
			    System.exit(0);
			}
			System.out.println(vidas);
			return false;
		}
	}
	
	public String formatPalabra() {
		System.out.println(this.palabra.length());
		for(int i=0; i < this.palabra.length(); i++) {
			
			System.out.println("-");
			
			if(i == 0) {
				this.palabraFormat += "_";
			}else if(i == this.palabra.length()){
				this.palabraFormat += "_";
			}
			else {
				this.palabraFormat += "_";
			}
			
			
		}
		System.out.println(palabraFormat);
		return palabraFormat;
	}
	
	public void reformatPalabra(ArrayList xd, char caracter) {
		
		StringBuilder newString = new StringBuilder(palabraFormat);
		
		for(int i=0; i < xd.size(); i++) {
			newString.setCharAt((Integer) xd.get(i), caracter);
			
		}
		palabraFormat = newString.toString();

	}
	
	public void restarVida(){
		vidas -=1;
	}
	
	public void aumentarIntentos() {
		intentos += 1;
	}
	
	public int getVidas() {
		return vidas;
	}
}
