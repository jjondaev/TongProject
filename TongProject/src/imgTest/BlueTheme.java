package imgTest;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

public class BlueTheme extends DefaultMetalTheme
{
    //frame 테두리 out color
    private final ColorUIResource primary1 = new ColorUIResource(0xd9, 0xe7, 0xff);
    //frame 테두리 in color
    private final ColorUIResource primary2 = new ColorUIResource(0x4c, 0xb1, 0xe5);
    //title bar color
    private final ColorUIResource primary3 = new ColorUIResource(0xd4, 0xec, 0xf9);  
    
    //button outter
    private final ColorUIResource secondary1 = new ColorUIResource(0x8c, 0xbd, 0x47);
    //button inner(click event)
    private final ColorUIResource secondary2 = new ColorUIResource(0x8c, 0xbd, 0x47);
    //main color
    private final ColorUIResource secondary3 = new ColorUIResource(0xf7, 0xfa, 0xff);
         
    protected ColorUIResource getPrimary1() { return primary1; }  
    protected ColorUIResource getPrimary2() { return primary2; } 
    protected ColorUIResource getPrimary3() { return primary3; } 
    
    protected ColorUIResource getSecondary1() { return secondary1; }
    protected ColorUIResource getSecondary2() { return secondary2; }
    protected ColorUIResource getSecondary3() { return secondary3; }

}
