/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.seminar_dna;

import AlgoTools.IO;

/**
 *
 * @author user
 */
public class PSeminar_DNA {

    /**
     * @param args the command line arguments
     */
    
    public static String DNA;
    
    
    public static void main(String[] args) {
        
        int laengeZeichen;
        
        DNA = IO.readString("Deine DNA: ");
        
        laengeZeichen = DNA.length();
        
        DNA=DNA.replaceAll("T", "U");
        
        String[] Codon = new String[laengeZeichen/3];
        
            for(int i=0;i<laengeZeichen/3;i++){
                String x;
                x=DNA.substring(0,3);
                Codon[i]=DNA.substring(0,3);
                DNA=DNA.replaceFirst(x, "");
                System.out.println(Codon[i]);
            }
            
            CodeSonne anwendung = new CodeSonne();
            
                anwendung.sonne(Codon);
            
            //System.out.println("DNA");
        
        
        
        
    }
    
}
