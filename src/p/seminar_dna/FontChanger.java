/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.seminar_dna;

import java.awt.Font;
import java.io.InputStream;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author user
 */
public class FontChanger {
        TrueTypeFont font;
        TrueTypeFont font2;
    
    public TrueTypeFont ChangeFont(){
            
	 
	
	try {
		InputStream inputStream	= ResourceLoader.getResourceAsStream("Luna.ttf");
 
		Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
		awtFont2 = awtFont2.deriveFont(30f); // set font size
		font2 = new TrueTypeFont(awtFont2, false);
 
	} catch (Exception e) {
		e.printStackTrace();
	}
        return font2;
        
	}
    
}
