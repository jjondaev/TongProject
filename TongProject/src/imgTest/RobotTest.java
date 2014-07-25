package imgTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class RobotTest extends JFrame {

	private JFrame contentPane;

	private static Point point = new Point();
	int x = 0, y = 0, width = 0, height = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {  
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					
					RobotTest frame = new RobotTest();
					//MenuTest panel = new MenuTest(frame);
					
					frame.setVisible(true);
					//panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RobotTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JFrame();
		setLocationRelativeTo(null);

		setUndecorated(true); // 타이틀 바가 사라진다.
		//setOpacity(0.5f); // 투명도
		setBackground(new Color(0,0,0,0));

		setAlwaysOnTop(true); // 항상 위에 위치
		contentPane.setLayout(null);

		this.getRootPane().setBorder(new LineBorder(Color.RED, 3));
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);


		// 마우스 리스너를 통해서 프레임을 드래그 했을 때 이동하게 함.
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		});
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g.create();
		
		// 프레임 위치 찾기
		Point frameLocation = getLocationOnScreen();
		x = (int)frameLocation.getX();
		y = (int)frameLocation.getY();
		
		// 프레임창 크기
		Dimension frameSize = getSize();
		width = (int)frameSize.getWidth();
		height = (int)frameSize.getHeight();
		
		g2d.setColor(Color.RED);
		g2d.draw3DRect(0, 0, width-1, height-1, true);

		final int R = 0;
        final int G = 0;
        final int B = 0;

        Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0), 0.0f, getHeight(), new Color(R, G, B, 0), true);
        
        g2d.setPaint(p);
        g2d.fillRect(0, 0, width, height);
		g2d.dispose();
	}
}
