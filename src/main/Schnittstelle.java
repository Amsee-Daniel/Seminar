package main;

import java.io.*;

public class Schnittstelle {
	
	public static void auslese() throws IOException{
        
        FileReader fr = new FileReader("test.txt");
    BufferedReader br = new BufferedReader(fr);

    String zeile1 = br.readLine();
    System.out.println(zeile1);
    String zeile2 = br.readLine();
    System.out.println(zeile2);
    String zeile3 = br.readLine();
    System.out.println(zeile3);

    br.close();
        
    }
}
