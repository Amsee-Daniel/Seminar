package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JOptionPane;



public class MutationManuell {
	
private GUI gui_Mut;
private String preDef;
private boolean fertig;
private String input;
	
	public void mutierenManu() throws Exception{
		
		
		FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        preDef = br.readLine();
        br.close();
		
        do{
        	fertig = true;
        		input = (String)JOptionPane.showInputDialog(null, "Bitte Mutiere deine DNA",
        			"Mutation", JOptionPane.QUESTION_MESSAGE,null,null,preDef);
        		
        		System.out.println(input);
        		 input = input.toUpperCase();
        		System.out.println(input);
        	
        		if(input.contains("B")||input.contains("D")||input.contains("E")||input.contains("F")||input.contains("H")||input.contains("I")||input.contains("J")||input.contains("K")||input.contains("L")||input.contains("M")||input.contains("N")||input.contains("O")||input.contains("P")||input.contains("Q")||input.contains("R")||input.contains("S")||input.contains("V")||input.contains("W")||input.contains("X")||input.contains("Y")||input.contains("Z")){
                	//fertig = false;
        			System.out.println("Error");
                }
        	
        }while(!fertig);
        
			System.out.println(input);
		
		System.out.println(input);
		gui_Mut.setDNA_Mutiert(input);

}
	public void setGUI(GUI gui_Obj){
		gui_Mut = gui_Obj;
	}
}
