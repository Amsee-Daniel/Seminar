package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {
	
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
