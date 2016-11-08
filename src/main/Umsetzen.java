package main;

public class Umsetzen {

	private CodeSonne sonne;
	String[] Codon = null;
    
    public String[] amino(String DNA_get, boolean mut_nonMut){
    
        int laengeZeichen;
        String DNA = DNA_get;
        laengeZeichen = DNA.length();
        
        DNA=DNA.replaceAll("T", "U");
        
        Codon = new String[laengeZeichen/3];
        //Einteilung der DNA in Codons
            for(int i=0;i<laengeZeichen/3;i++){
                String x;
                x=DNA.substring(0,3);
                Codon[i]=DNA.substring(0,3);
                DNA=DNA.replaceFirst(x, "");
                //System.out.println(Codon[i]);
            }
            
            
            //Weitergabe an CodeSonne/R�ckgabe an GUI
                return sonne.sonne(Codon, mut_nonMut,laengeZeichen);
            
            //System.out.println("DNA");
    
}
    
    public void setSonne(CodeSonne obj_s){
        sonne = obj_s;
    }
    
    public String[] getCodons(){
    	return Codon;
    }
}
