/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.seminar_dna;

import AlgoTools.IO;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;




/**
 *
 * @author user
 */
public class speichern {
      
    
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
