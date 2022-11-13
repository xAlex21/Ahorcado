package version1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.collections.ObservableList;

public class PalabrasModel {
	
	List<String> list;

	public static String contenidoArchivo = "";
	public void updatePalabras() {
		
	}
	
	public List<String> getPalabras() throws FileNotFoundException {
		
		String[] parts = null;
        File doc = new File("src/main/resources/palabras.txt");
        Scanner obj = new Scanner(doc);
        
        if(obj.hasNextLine()) {

            contenidoArchivo = (obj.nextLine());
        }

        if(!contenidoArchivo.isEmpty()) {
        	parts = contenidoArchivo.split(",");

        }
        
        list = new ArrayList<String>();
        
        try {
            if(parts.length != 0) {
                for(int i=0;i<parts.length;i++)
                {
                    list.add(parts[i]);

                }
            }else {
            	System.out.println(parts.length);
            }
        }catch(Exception e){

        }


        
        return list;
	}
	
	public void addPalabras(String palabra) throws IOException {
		Writer doc = new FileWriter("src/main/resources/palabras.txt");
		BufferedWriter bw = new BufferedWriter(doc);
		PrintWriter wr = new PrintWriter(bw);
		
		if(list.size() == 0) {
			wr.append(palabra);
		}else {
			wr.append(contenidoArchivo + "," + palabra);
		}
		
		wr.close();
		bw.close();
		list.add(palabra);
	}
	
	public String getPalabraRandom() {
		
		int valorAleatorio = (int) Math.floor(Math.random()*list.size()+0);
		System.out.println(valorAleatorio);
		
		return list.get(valorAleatorio);
	}


}
