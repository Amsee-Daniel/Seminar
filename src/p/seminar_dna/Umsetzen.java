/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.seminar_dna;

/**
 *
 * @author user
 */
public class Umsetzen {
    
    private CodeSonne sonne;
    
    public void amino(String DNA_get){
    
        int laengeZeichen;
        String DNA = DNA_get;
        laengeZeichen = DNA.length();
        
        DNA=DNA.replaceAll("T", "U");
        
        String[] Codon = new String[laengeZeichen/3];
        
            for(int i=0;i<laengeZeichen/3;i++){
                String x;
                x=DNA.substring(0,3);
                Codon[i]=DNA.substring(0,3);
                DNA=DNA.replaceFirst(x, "");
                //System.out.println(Codon[i]);
            }
            
            
            
                sonne.sonne(Codon);
            
            //System.out.println("DNA");
    
}
    
    public void setSonne(CodeSonne obj_s){
        sonne = obj_s;
    }
}