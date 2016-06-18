/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.seminar_dna;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

/**
 *
 * @author user
 */
public class GUI extends BasicGame{
    
    private String inputTXT = ("input.txt");
    private Image auswahl = null;
    private Image cursor = null;
    private int curser_x;
    private int cursor_y;
    private int cursor_position;
    private read eingabe;
    private String schowDNA = "";
    private TrueTypeFont font2;
    private FontChanger changeFont;
    private Umsetzen umsetzer;
    private String[] aminos;
    private int aminoposition = 0;
    
    
    public GUI(String title){
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        auswahl = new Image("grafik/hauptbild.png");
        cursor = new Image("grafik/Cursor.png");
        curser_x = 0;
        cursor_y = 0;
        cursor_position = 1;
        changeFont = new FontChanger();
        font2 = changeFont.ChangeFont();
        aminos = new String[1];
        aminos[0] = "null";
        
        
        
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        
        Input input = container.getInput();
        
            if(input.isKeyPressed(input.KEY_ENTER)){
                switch(cursor_position){
                    case 1 : {
                                try {
                                  eingabe.auslesen(inputTXT);
                                } catch (IOException ex) {
                                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            }
                    
                    case 2 : {
                                umsetzer.amino(schowDNA);
                                    break;
                            }
                }
            }
            
            if(input.isKeyPressed(input.KEY_DOWN)){
                if(cursor_position < 3){
                    cursor_y = cursor_y + 100;
                    cursor_position = cursor_position +1;
                }
            }
            
            if(input.isKeyPressed(input.KEY_UP)){
                if(cursor_position >1){
                    cursor_y = cursor_y - 100;
                    cursor_position = cursor_position - 1;
                }
            }
            
            if(input.isKeyPressed(input.KEY_ESCAPE)){
                container.exit();
            }
            
            if(input.isKeyPressed(input.KEY_RIGHT)){
                if(aminoposition < aminos.length-1){
                    aminoposition = aminoposition + 1;
                }
            }
            
            if(input.isKeyPressed(input.KEY_LEFT)){
                if(aminoposition > 0){
                    aminoposition = aminoposition - 1;
                }
            }
        
            
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        
        auswahl.draw(0,0);
        cursor.draw(curser_x, cursor_y);
        font2.drawString(300, 20,schowDNA,Color.black);
        //g.drawString(schowDNA, 300, 20);
        if(aminos.length > 1){
            font2.drawString(300, 70, aminos[aminoposition], Color.black);
        }
        
        
    }
    
    public void setDNA(String obj_s){
        schowDNA = obj_s;
    }
    
    public void setRead(read obj_r){
        eingabe = obj_r;
    }
    
    public void setUmsetzer(Umsetzen obj_u){
        umsetzer = obj_u;
    }
    
    public void setAminos(String[] obj_s){
        aminos = new String[obj_s.length];
        aminos = obj_s;
    }
    
}
