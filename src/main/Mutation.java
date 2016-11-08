package main;

import javax.swing.JOptionPane;

public class Mutation {
	
	private String DNA_Mutiert;
	private GUI gui_Mut;
	
	public void insert(int laenge, String DNA){
		System.out.println(laenge);
		//Zuf�llige auswahl der Stelle, an der Basen eingef�gt werden.
			int random_Stelle = ((int)(Math.random()*laenge));
				System.out.println("Random, inti: " + random_Stelle);
				if(random_Stelle < 4){
					random_Stelle = random_Stelle + (4-random_Stelle);
				}
			System.out.println("Random, final: " + random_Stelle);
		
		//int random_base = ((int)(Math.random()*4));
		//Verk�rzung des DNA strings bis zu der zu Mutierenden stelle
		try{
			DNA_Mutiert = DNA.substring(0, random_Stelle +1);
		}catch(StringIndexOutOfBoundsException ex){
			DNA_Mutiert = DNA.substring(0, DNA.length());
		}
		//Abfrage nach der anzahl an einzuf�genden Basen
		String mutationsParameter = JOptionPane.showInputDialog(null,"Wie viele Basen sollen eingef�gt werden?",
                "P-Sem",
                JOptionPane.PLAIN_MESSAGE);
		
		if(mutationsParameter == null){
			mutationsParameter = "1";
		}
		//Basen werden an der zu mutierenden stelle eingef�gt, und der rest der DNA wieder angehangen
		int anzahl = Integer.parseInt(mutationsParameter);
		
		for(int i = 0; i<=anzahl; i++){
			
			int random_base = ((int)(Math.random()*4));
			
			switch(random_base){
		
								case 1 :  DNA_Mutiert = DNA_Mutiert + "A";
											break;
										
								case 2 :  DNA_Mutiert = DNA_Mutiert + "U";
											break;
										
								case 3 :  DNA_Mutiert = DNA_Mutiert + "G";
											break;
										
								case 0 :  DNA_Mutiert = DNA_Mutiert + "C";
											break;
		
			}
		}
	
	try{
		DNA_Mutiert = DNA_Mutiert +  DNA.substring(random_Stelle + 1 , DNA.length());
	}catch(StringIndexOutOfBoundsException ex){
		
	}
		
	System.out.println(DNA_Mutiert);
	gui_Mut.setDNA_Mutiert(DNA_Mutiert);	
		
		
	}
	
	public void delet(int laenge, String DNA){
		String mutationsParameter = JOptionPane.showInputDialog(null,"Wie viele Basen sollen gel�scht werden?",
                "P-Sem",
                JOptionPane.PLAIN_MESSAGE);
		
		if(mutationsParameter == null){
			mutationsParameter = "1";
		}
		
		int anzahl = Integer.parseInt(mutationsParameter);
		
		int random_Stelle = ((int)(Math.random()*laenge));
		System.out.println("Random, inti: " + random_Stelle);
			if(random_Stelle < 4){
				random_Stelle = random_Stelle + (4-random_Stelle);
			}if((random_Stelle + anzahl) > DNA.length()){
				random_Stelle = random_Stelle - (random_Stelle - DNA.length());
			}
		
		try{
			DNA_Mutiert = DNA.substring(0, random_Stelle +1) + DNA.substring(random_Stelle + 1 + anzahl, DNA.length());
		}catch(StringIndexOutOfBoundsException ex){
			DNA_Mutiert = "ERROR";
		}
		
		System.out.println(DNA_Mutiert);
		gui_Mut.setDNA_Mutiert(DNA_Mutiert);
		
	}
	
	public void setGUI(GUI gui_Obj){
		gui_Mut = gui_Obj;
	}

}
