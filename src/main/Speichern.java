package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Speichern {
	
	public void schreiben(int laengeDNA, String DNA, String[] amino_DNA, int laengeDNA_Mut, String DNA_Mut, String[] amino_DNA_Mut) {
        
        String name = JOptionPane.showInputDialog(null,"ateiname",
                "P-Sem",
                JOptionPane.PLAIN_MESSAGE);
		
        PrintWriter pWriter = null;
    try {
        pWriter = new PrintWriter(new BufferedWriter(new FileWriter("DNA_Gesichert//" + name + ".txt")));
        pWriter.println("Eingabe Material:");
        pWriter.println(DNA);
        pWriter.println(laengeDNA);
        for(int n=0;n<laengeDNA;n++){
        	pWriter.println(amino_DNA[n]);
        }
        pWriter.println("------------------------------------------");
        pWriter.println("Mutation:");
        pWriter.println(DNA_Mut);
        pWriter.println(laengeDNA_Mut);
        for(int n=0;n<laengeDNA_Mut;n++){
        	try{
        		pWriter.println(amino_DNA_Mut[n]);
        	}catch(Exception ex){}
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
