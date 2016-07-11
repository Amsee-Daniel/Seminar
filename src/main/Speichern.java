package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Speichern {
	
	public void schreiben(int laenge_exact , String[] amino_kurz , String name) {
        
        PrintWriter pWriter = null;
    try {
        pWriter = new PrintWriter(new BufferedWriter(new FileWriter(name + ".txt")));
        pWriter.println(laenge_exact);
        for(int n=0;n<laenge_exact;n++){
        pWriter.println(amino_kurz[n]);
        }
    } catch (IOException ioe) {
        ioe.printStackTrace();
    } finally {
        if (pWriter != null){
            pWriter.flush();
            pWriter.close();
        }
    }
} 
}
