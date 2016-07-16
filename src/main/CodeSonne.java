package main;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 

public class CodeSonne {
	
	static GUI gui_sonne;  
	  static int laenge_exact=0;  
	  static String[] amino_kurz;  
	  
	    public String[] sonne(String[] sort){
	    	
	        int laenge = sort.length;
	        gui_sonne.setLaenge_DNA(laenge);
	        
	        String[] amino = new String[laenge];
	        int aminoAktuell=0;
	        for(int i=0;i<sort.length;i++){
	        
	            if(amino[0]==null){
	                switch(sort[i]){
	                    
	                    case "AUG": amino[0] = "Methionin";
	                                aminoAktuell++;
	                                break;
	                                
	                    default : break;
	                
	                
	                }
	            }else{
	            
	                switch(sort[i]){
	                    
	                    case "UUU": amino[aminoAktuell] = "Phenylalanin";
	                                aminoAktuell++;
	                                break;
	                              
	                    case "UUC": amino[aminoAktuell] = "Phenylalanin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "UUA": amino[aminoAktuell] = "Leucin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "UUG": amino[aminoAktuell] = "Leucin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "UCU": amino[aminoAktuell] = "Serin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "UCC": amino[aminoAktuell] = "Serin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "UCA": amino[aminoAktuell] = "Serin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "UCG": amino[aminoAktuell] = "Serin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "UAU": amino[aminoAktuell] = "Tyrosin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "UAC": amino[aminoAktuell] = "Tyrosin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "UAA": i=sort.length;
	                                break;
	                                
	                    case "UAG": i=sort.length;
	                                break;
	                                
	                    case "UGU": amino[aminoAktuell] = "Cystein";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "UGC": amino[aminoAktuell] = "Cystein";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "UGA": i=sort.length;
	                                break;
	                                
	                    case "UGG": amino[aminoAktuell] = "Tryptophan";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "CUU": amino[aminoAktuell] = "Leucin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "CUC": amino[aminoAktuell] = "Leucin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "CUA": amino[aminoAktuell] = "Leucin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "CUG": amino[aminoAktuell] = "Leucin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "CCU": amino[aminoAktuell] = "Prolin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "CCC": amino[aminoAktuell] = "Prolin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "CCA": amino[aminoAktuell] = "Prolin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "CCG": amino[aminoAktuell] = "Prolin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "CAU": amino[aminoAktuell] = "Histidin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "CAC": amino[aminoAktuell] = "Histidin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "CAA": amino[aminoAktuell] = "Glutamin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "CAG": amino[aminoAktuell] = "Glutamin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "AUU": amino[aminoAktuell] = "Isoleucin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "AUC": amino[aminoAktuell] = "Isoleucin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "AUA": amino[aminoAktuell] = "Isoleucin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "AUG": amino[aminoAktuell] = "Methionin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "ACU": amino[aminoAktuell] = "Threonin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "ACC": amino[aminoAktuell] = "Threonin";
	                                aminoAktuell++;
	                                break;
	                             
	                    case "ACA": amino[aminoAktuell] = "Threonin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "ACG": amino[aminoAktuell] = "Threonin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "AAU": amino[aminoAktuell] = "Asparagin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "AAC": amino[aminoAktuell] = "Asparagin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "AAA": amino[aminoAktuell] = "Lysin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "AAG": amino[aminoAktuell] = "Lysin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "AGU": amino[aminoAktuell] = "Serin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "AGC": amino[aminoAktuell] = "Serin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "AGA": amino[aminoAktuell] = "Arginin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "AGG": amino[aminoAktuell] = "Arginin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GUU": amino[aminoAktuell] = "Valin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GUC": amino[aminoAktuell] = "Valin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GUA": amino[aminoAktuell] = "Valin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GUG": amino[aminoAktuell] = "Valin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GCU": amino[aminoAktuell] = "Alanin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GCC": amino[aminoAktuell] = "Alanin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GCA": amino[aminoAktuell] = "Alanin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GCG": amino[aminoAktuell] = "Alanin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GAU": amino[aminoAktuell] = "Asparaginsäure";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GAC": amino[aminoAktuell] = "Asparaginsäure";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GAA": amino[aminoAktuell] = "Glutaminsäure";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GAG": amino[aminoAktuell] = "Glutaminsäure";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GGU": amino[aminoAktuell] = "Glycin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GGC": amino[aminoAktuell] = "Glycin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GGA": amino[aminoAktuell] = "Glycin";
	                                aminoAktuell++;
	                                break;
	                                
	                    case "GGG": amino[aminoAktuell] = "Glycin";
	                                aminoAktuell++;
	                                break;
	                                
	                                
	                    default : break;
	                }
	                
	            }
	        
	        }
	        
	        int laenge_exact=0;
	        
	        for(int i=0;i<amino.length;i++){
	            
	            if(amino[i]!=null){
	                laenge_exact++;
	            }else{
	                i=amino.length;
	            }
	            
	        }
	        String[] amino_kurz = new String[laenge_exact];
	        
	            System.out.println(amino.length);
	            System.out.println(amino_kurz.length);
	        
	        for(int z=0;z<amino_kurz.length;z++){
	        
	            amino_kurz[z]=amino[z];
	        
	        }
	        
	        for(int z=0;z<amino_kurz.length;z++){
	            System.out.println(amino_kurz[z]);
	        }
	        
	        return amino_kurz;
	        
	        
	        
	       // String name; 
	                
	       // name = IO.readString("Name: ");
	      //  speichern sichern = new speichern();
	      //  sichern.schreiben(laenge_exact , amino_kurz , name);
	        
	        
	        
//	        Schnittstelle test = new Schnittstelle();
//	        try{
//	            test.auslese();
//	        }
//	            catch(IOException e){
//	                e.printStackTrace();
//	                }
	        }
	        

	       public void setgui(GUI obj_g){
	           gui_sonne = obj_g;
	       }
}
