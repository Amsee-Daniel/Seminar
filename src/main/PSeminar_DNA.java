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
    static File save = new File("DNA_Gesichert");
    static boolean ready = true;
    static String eingabe;
    static int startKodon;
   
    
    public static void main (String[] args) throws SlickException{
    	
    	save.mkdir();
        do{
        	ready = true;
            eingabe = JOptionPane.showInputDialog(null,"Geben Sie Ihre DNA ein",
                                                             "P-Sem",
                                                             JOptionPane.PLAIN_MESSAGE);
            
            
            startKodon = JOptionPane.showConfirmDialog(null,"Soll ein Startkodon eingefügt werden?", 
            													"Startkodon", 
            													 JOptionPane.YES_NO_OPTION);
            eingabe = eingabe.toUpperCase();
            
            if(eingabe.contains("B")||eingabe.contains("D")||eingabe.contains("E")||eingabe.contains("F")||eingabe.contains("H")||eingabe.contains("I")||eingabe.contains("J")||eingabe.contains("K")||eingabe.contains("L")||eingabe.contains("M")||eingabe.contains("N")||eingabe.contains("O")||eingabe.contains("P")||eingabe.contains("Q")||eingabe.contains("R")||eingabe.contains("S")||eingabe.contains("U")||eingabe.contains("V")||eingabe.contains("W")||eingabe.contains("X")||eingabe.contains("Y")||eingabe.contains("Z")){
            	ready = false;
            }
            
        }while(!ready);
                    
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
                
        app.setDisplayMode(1000,720,false);
        
        app.start();
    
    }
}
