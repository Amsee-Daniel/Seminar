/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.seminar_dna;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author user
 */
public class read {
    
    private String zeile1;
    private GUI gui_read;
    
    public void auslesen(String input)throws IOException{
         
        FileReader fr = new FileReader(input);
        BufferedReader br = new BufferedReader(fr);
        zeile1 = br.readLine();
            gui_read.setDNA(zeile1);
        br.close();        
   
    
    }
    
    public void setgui(GUI obj_g){
        gui_read = obj_g;
    }
    
}
