package main;

public class Mutation {
	
	private String DNA_Mutiert;
	private GUI gui_Mut;
	
	public void insert(int laenge, String DNA){
		
		int random_Stelle = ((int)(Math.random()*laenge));
		int random_base = ((int)(Math.random()*4));
		
		DNA_Mutiert = DNA.substring(0, random_Stelle);
		
		switch(random_base){
		
							case 1 :  DNA_Mutiert = DNA_Mutiert + "A" + DNA.substring(random_Stelle+1 , DNA.length());
										break;
										
							case 2 :  DNA_Mutiert = DNA_Mutiert + "U" + DNA.substring(random_Stelle+1 , DNA.length());
										break;
										
							case 3 :  DNA_Mutiert = DNA_Mutiert + "G" + DNA.substring(random_Stelle+1 , DNA.length());
										break;
										
							case 4 :  DNA_Mutiert = DNA_Mutiert + "C" + DNA.substring(random_Stelle+1 , DNA.length());
										break;
		
		}
		
		
		
	}
	
	public void setGUI(GUI gui_Obj){
		gui_Mut = gui_Obj;
	}

}
