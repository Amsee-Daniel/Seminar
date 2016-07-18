package main;

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


public class GUI extends BasicGame{
	
	 	private String inputTXT = ("input.txt");
	    private Image auswahl = null;
	    private Image cursor = null;
	    private int curser_x;
	    private int cursor_y;
	    private int cursor_position;
	    private Read eingabe;
	    private String schowDNA = "";
	    private TrueTypeFont font2;
	    private FontChanger changeFont;
	    private Umsetzen umsetzer;
	    private String[] aminos;
	    private String[] aminos_Mut;
	    private int aminoposition = 0;
	    private int laenge_DNA = 0;
	    private int laenge_DNA_Zeichen = 0;
	    private Mutation mutieren = null;
	    private boolean setzerstmalum = false;
	    private String DNA_Mutiert = "";
	    private boolean showMutation = false;
	    
	    
	    public GUI(String title){
	        super(title);
	    }

	    @Override
	    public void init(GameContainer container) throws SlickException {
	    	
	    	mutieren = new Mutation();
	    	mutieren.setGUI(this);
	        auswahl = new Image("img/hauptbild.png");
	        cursor = new Image("img/Cursor.png");
	        curser_x = 0;
	        cursor_y = 0;
	        cursor_position = 1;
	        changeFont = new FontChanger();
	        font2 = changeFont.ChangeFont();
	        aminos = new String[1];
	        aminos[0] = "null";
	        aminos_Mut = new String[1];
	        aminos_Mut[0] = "null";
	        
	        
	        
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
	                    				aminos = umsetzer.amino(schowDNA, true);
	                    				break;
	                             }
	                    
	                    case 3 : {
	                    			if(aminos[0] != "null"){
	                    					mutieren.insert(laenge_DNA_Zeichen, schowDNA);
	                    					aminos_Mut = umsetzer.amino(DNA_Mutiert, false);
	                    					//System.out.println("Mut_1" + aminos_Mut[1]);
	                    					showMutation = true;
	                    						break;
	                    				}else{
	                    					setzerstmalum = true;
	                    						break;
	                    				}
	                    			}
	                }
	            }
	            
	            if(input.isKeyPressed(input.KEY_DOWN)){
	                if(cursor_position < 4){
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
	        
	        if(setzerstmalum){
	        	font2.drawString(300, 400, "DNA muss zuerst umgesetzt werden!", Color.black);
	        	try {
					Thread.sleep(999);
				} catch (InterruptedException e) {
					System.out.println("Ging wohl nicht");
				}
	        	setzerstmalum = false;
	        }
	        
	        if(showMutation){
	        	font2.drawString(300, 130, DNA_Mutiert, Color.black);
	        	try{
		            font2.drawString(300, 180, aminos_Mut[aminoposition], Color.black);
	        	}catch(ArrayIndexOutOfBoundsException ex){
	        		font2.drawString(300, 180, "ERROR", Color.black);
		        }
	        }
	        
	        
	    }
	    
	    public void setDNA(String obj_s){
	        schowDNA = obj_s;
	    }
	    
	    public void setRead(Read obj_r){
	        eingabe = obj_r;
	    }
	    
	    public void setUmsetzer(Umsetzen obj_u){
	        umsetzer = obj_u;
	    }
	    
	    public void setAminos(String[] obj_s){
	        aminos = new String[obj_s.length];
	        aminos = obj_s;
	    }
	    
	    public void setLaenge_DNA(int laeng_Obj){
	    	laenge_DNA = laeng_Obj;
	    }
	    
	    public void setLaenge_DNA_Zeichen(int laenge_Obj){
	    	laenge_DNA_Zeichen = laenge_Obj;
	    }
	    
	    public void setDNA_Mutiert(String DNA_Obj){
	    		DNA_Mutiert = DNA_Obj;
	    		aminos_Mut = new String[DNA_Mutiert.length()];
	    		System.out.println("Länge: " + aminos_Mut.length);
	    }
}
