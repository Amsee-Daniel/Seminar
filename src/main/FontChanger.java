package main;

import java.awt.Font;
import java.io.InputStream;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;


public class FontChanger {
	
	TrueTypeFont font;
    TrueTypeFont font2;

public TrueTypeFont ChangeFont(){
        
 

try {
	InputStream inputStream	= ResourceLoader.getResourceAsStream("img/Story.ttf");

	Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
	awtFont2 = awtFont2.deriveFont(30f); // set font size
	font2 = new TrueTypeFont(awtFont2, false);

} catch (Exception e) {
	e.printStackTrace();
}
    return font2;
    
}
}
