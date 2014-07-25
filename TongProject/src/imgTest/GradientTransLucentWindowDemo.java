package imgTest;

import static java.awt.GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GradientTransLucentWindowDemo extends JFrame {
	
	JPanel panel;
	
    public GradientTransLucentWindowDemo() {
        super("강의 제목 : OOOOOOOOOO  강의자 : OOO");

        setBackground(new Color(0,0,0,0));
        setSize(new Dimension(500,400));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true); // 항상 위에 위치
        
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    final int R = 0;
                    final int G = 0;
                    final int B = 0;

                    Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0), 0.0f, getHeight(), new Color(R, G, B, 0), true);
                    Graphics2D g2d = (Graphics2D)g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        setContentPane(panel);
        setLayout(new GridBagLayout());
    }

    public static void main(String[] args) {
        // Determine what the GraphicsDevice can support.
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        boolean isPerPixelTranslucencySupported = gd.isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);

        //If translucent windows aren't supported, exit.
        if (!isPerPixelTranslucencySupported) {
            System.out.println("Per-pixel translucency is not supported");
            System.exit(0);
        }
               
        JFrame.setDefaultLookAndFeelDecorated(true);
//      Toolkit.getDefaultToolkit().setDynamicLayout(true);
//		System.setProperty("sun.awt.noerasebackground", "true");
//		MetalTheme[] themes = { new DefaultMetalTheme(), new BlueTheme() };
//		MetalTheme selectedTheme = themes[Integer.parseInt("1")];
//		MetalLookAndFeel.setCurrentTheme(selectedTheme);
		
        // Create the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	try{
	            	GradientTransLucentWindowDemo gtw = new GradientTransLucentWindowDemo();
	            	MenuTest menu = new MenuTest(gtw);
	            	
	                // Display the window.
	                gtw.setVisible(true);
	                menu.setVisible(true);
            	} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
    }
}