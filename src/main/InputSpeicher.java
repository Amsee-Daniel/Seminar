package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InputSpeicher {
	
	public void speichern(String eingabe) {
        
        PrintWriter pWriter = null;
    try {
        pWriter = new PrintWriter(new BufferedWriter(new FileWriter("input.txt")));
        pWriter.println(eingabe);
        
    } catch (IOException ioe) {
        ioe.printStackTrace();
    } finally {
        if (pWriter != null){
            pWriter.flush();
            pWriter.close();
        }
    }
}
}
