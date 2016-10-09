package main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

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
	    private String[] codons_DNA = null;
	    private String[] codons_DNA_Mut = null;
	    private int laengeCodonArray = 0;
	    private Speichern Save = new Speichern();
	    private boolean ausgelesen = false;
	    private MutationManuell manuell = new MutationManuell(); 
	    
	    
	    public GUI(String title){
	        super(title);
	    }

	    @Override
	    public void init(GameContainer container) throws SlickException {
	    	
	    	manuell.setGUI(this);
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
	                                  ausgelesen = true;
	                                } catch (IOException ex) {
	                                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
	                                }
	                                break;
	                            }
	                    
	                    case 2 : {
	                    				aminos = umsetzer.amino(schowDNA, true);
	                    				codons_DNA = umsetzer.getCodons();
	                    				laengeCodonArray = aminos.length;
	                    				break;
	                             }
	                    
	                    case 3 : {
	                    			if(aminos[0] != "null"){
	                    				
	                    				int eigen = JOptionPane.showConfirmDialog(null,"Manuelle Mutation?", 
												"Mutation", 
												 JOptionPane.YES_NO_OPTION);
	                    						
	                    				if(eigen == JOptionPane.YES_OPTION){
                							try {
												manuell.mutierenManu();
											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
                						}else{                   
                							
                						
	                    				
	                    				int startKodon = JOptionPane.showConfirmDialog(null,"Insertion = JA, Deletion = Nein", 
												"Mutation", 
												 JOptionPane.YES_NO_OPTION);
    
	                    						if(startKodon == JOptionPane.YES_OPTION){
	                    							mutieren.insert(laenge_DNA_Zeichen, schowDNA);
	                    						}else{                   
	                    							mutieren.delet(laenge_DNA_Zeichen, schowDNA);
	                    						}
                						}
	                    					//mutieren.insert(laenge_DNA_Zeichen, schowDNA);
	                    					aminos_Mut = umsetzer.amino(DNA_Mutiert, false);
	                    					//System.out.println("Mut_1" + aminos_Mut[1]);
	                    					showMutation = true;
	                    					codons_DNA_Mut = umsetzer.getCodons();
	                    						if((codons_DNA_Mut.length) < (codons_DNA.length)){
	                    							laengeCodonArray = codons_DNA.length;
	                    						}else{
	                    							laengeCodonArray = codons_DNA_Mut.length;
	                    						}
	                    						break;
	                    				}else{
	                    					setzerstmalum = true;
	                    						break;
	                    				}
	                    			}
	                    case 4 : {
	                    			Save.schreiben(codons_DNA.length,schowDNA , aminos, aminos_Mut.length, DNA_Mutiert, aminos_Mut);	                    	
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
	                if(aminoposition < laengeCodonArray-1){
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
	    	
	    	if(ausgelesen){
	    		font2.drawString(100, 500, schowDNA, Color.black);
	    	}
	    	
	        
	        cursor.draw(curser_x, cursor_y);
	        if(codons_DNA != null){
	        	try{
	        		font2.drawString(500, 20,codons_DNA[aminoposition],Color.black);
	        	}catch(ArrayIndexOutOfBoundsException ex){
	        	}
	        	try{
	        		font2.drawString(600, 20,codons_DNA[aminoposition +1],Color.black);
	        	}catch(ArrayIndexOutOfBoundsException ex){
	        		font2.drawString(600, 20,"",Color.black);
	        	}
	        	try{
	        		font2.drawString(700, 20,codons_DNA[aminoposition +2],Color.black);
	        	}catch(ArrayIndexOutOfBoundsException ex){
	        		font2.drawString(700, 20,"",Color.black);
	        	}
	        	try{
	        		font2.drawString(400, 20,codons_DNA[aminoposition -1],Color.black);
	        	}catch(ArrayIndexOutOfBoundsException ex){
	        		font2.drawString(400, 20,"",Color.black);
	        	}
	        	try{
	        		font2.drawString(300, 20,codons_DNA[aminoposition -2],Color.black);
	        	}catch(ArrayIndexOutOfBoundsException ex){
	        		font2.drawString(300, 20,"",Color.black);
	        	}
	        }
	        //g.drawString(schowDNA, 300, 20);
	        if(aminos.length > 1){
	            try{
	            	font2.drawString(300, 70, aminos[aminoposition], Color.black);
	            }catch(ArrayIndexOutOfBoundsException ex){
	            	font2.drawString(300, 70, "", Color.red);
	            }
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
	        	//font2.drawString(300, 130, DNA_Mutiert, Color.black);
	        	if(codons_DNA_Mut != null){
		        	try{
		        		font2.drawString(500, 130,codons_DNA_Mut[aminoposition],Color.black);
		        	}catch(ArrayIndexOutOfBoundsException ex){
		        	}
		        	try{
		        		font2.drawString(600, 130,codons_DNA_Mut[aminoposition +1],Color.black);
		        	}catch(ArrayIndexOutOfBoundsException ex){
		        		font2.drawString(600, 130,"",Color.black);
		        	}
		        	try{
		        		font2.drawString(700, 130,codons_DNA_Mut[aminoposition +2],Color.black);
		        	}catch(ArrayIndexOutOfBoundsException ex){
		        		font2.drawString(700, 130,"",Color.black);
		        	}
		        	try{
		        		font2.drawString(400, 130,codons_DNA_Mut[aminoposition -1],Color.black);
		        	}catch(ArrayIndexOutOfBoundsException ex){
		        		font2.drawString(400, 130,"",Color.black);
		        	}
		        	try{
		        		font2.drawString(300, 130,codons_DNA_Mut[aminoposition -2],Color.black);
		        	}catch(ArrayIndexOutOfBoundsException ex){
		        		font2.drawString(300, 130,"",Color.black);
		        	}
		        }
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
	    		System.out.println("L�nge: " + aminos_Mut.length);
	    }
}
