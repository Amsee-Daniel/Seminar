/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.seminar_dna;

import AlgoTools.IO;
import java.io.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


/**
 *
 * @author user
 */
public class PSeminar_DNA {
    
    static GUI gui = new GUI("P-Sem");
    static read reader = new read();
    static CodeSonne sonne = new CodeSonne();
    static Umsetzen umsetzer = new Umsetzen();

    public static void main (String[] args) throws SlickException{
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
