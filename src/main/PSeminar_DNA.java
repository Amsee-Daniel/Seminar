package main;

import java.io.*;
import javax.swing.JOptionPane;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class PSeminar_DNA {
	
	InputStream is = getClass().getClassLoader().getResourceAsStream("grafik/Cursor.png");
    InputStream is_2 = getClass().getClassLoader().getResourceAsStream("grafik/hauptbild.png");
    static GUI gui = new GUI("P-Sem");
    static Read reader = new Read();
    static CodeSonne sonne = new CodeSonne();
    static Umsetzen umsetzer = new Umsetzen();
    static InputSpeicher speichern = new InputSpeicher();

    public static void main (String[] args) throws SlickException{
        
            String eingabe = JOptionPane.showInputDialog(null,"Geben Sie Ihre DNA ein",
                                                             "P-Sem",
                                                             JOptionPane.PLAIN_MESSAGE);
            
            int startKodon = JOptionPane.showConfirmDialog(null,"Soll ein Startkodon eingefügt werden?", 
            													"Startkodon", 
            													 JOptionPane.YES_NO_OPTION);
                    
            if(startKodon == JOptionPane.YES_OPTION){
            	speichern.speichern("AUG" + eingabe);
            }else{                   
            	speichern.speichern(eingabe);
            	}
               
            
        gui.setRead(reader);
        reader.setgui(gui);
        sonne.setgui(gui);
        umsetzer.setSonne(sonne);
        gui.setUmsetzer(umsetzer);
        AppGameContainer app = new AppGameContainer(gui);  
                
        app.setDisplayMode(800,600,false);
        
        app.start();
    
    }
}
