package imgTest;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class MenuTest extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JSpinner spinner;
	private JLayeredPane layeredPane;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton button;
	
	
	private GradientTransLucentWindowDemo frame;
	
	private static Point point = new Point();
	int x = 0, y = 0, width = 0, height = 0;

	public MenuTest(GradientTransLucentWindowDemo frame) {
		super("Tong");
		this.frame = frame;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setAlwaysOnTop(true); // 항상 위에 위치
		
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getLayeredPane_1());
		
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
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("전송");
			btnNewButton.setOpaque(false);
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					try{
						
						// 스크린 크기
						Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

						// 프레임 위치 찾기
						Point frameLocation = frame.panel.getLocationOnScreen();
						x = (int)frameLocation.getX();
						y = (int)frameLocation.getY();
						
						// 프레임창 크기
						Dimension frameSize = frame.panel.getSize();
						width = (int)frameSize.getWidth();
						height = (int)frameSize.getHeight();		
						
						// robot 객체를 이용해서 캡쳐할 사이즈를 지정
						Robot robot = new Robot();
						BufferedImage img = robot.createScreenCapture(new Rectangle(x, y, width, height));
						 
						
						

						// A4 용지 사이즈 = 210mm x 297mm (21cm x 29.7cm)
						// A4 용지 픽셀 = 595 x 842
						// A4 용지 사이즈로 버퍼이미지 줄이기						
					    int w = img.getWidth();  
					    int h = img.getHeight();  
					    int newW = 842;
					    int newH = 595;
					    BufferedImage dimg = new BufferedImage(newW, newH, img.getType());  
					    Graphics2D g = dimg.createGraphics();  
					    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
					    g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);  
					    g.dispose();  

					    
					    
						
						// 캡쳐한 이미지를 .png file로 저장
						File file = new File("C:\\test.png");
						ImageIO.write(dimg, "png", file);
						
						
						
						
//						// 캡쳐한 이미지를 .jpg file로 저장
//						File file1 = new File("C:\\test.jpg");
//						ImageIO.write(img, "jpg", file1);

						
						
						
						// JAI를 이용해서 이미지파일 저장방법
//						RenderedOp src = JAI.create("fileload", "C:\\test.png");  
//						
//						OutputStream os = new FileOutputStream("C:\\test1.png");
//						PNGEncodeParam.RGB param = new PNGEncodeParam.RGB();
//						
//						ImageEncoder enc = ImageCodec.createImageEncoder("png", os, param);    // ( 파일포맷, 출력파일, 인코더 )
//						
//						enc.encode(src);
//						os.close();
					
						

						// itext를 이용해 pdf로 저장하기
						Document document = new Document(PageSize.A4.rotate(), 0, 0, 0, 0);
						PdfWriter.getInstance(document, new FileOutputStream("C:/test.pdf"));
						document.open();
						Image image = Image.getInstance(getClass().getResource("test.png"));
						document.add(image);
						document.close();

					}catch(Exception ex){
						ex.getStackTrace();
					}finally{
						//setVisible(true);
						//frame.setOpacity(0.5f);
					}
				}
			});
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnNewButton.setBounds(12, 219, 212, 56);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("등록");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton_1.setBounds(12, 10, 100, 56);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("종료");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int y = JOptionPane.showConfirmDialog(MenuTest.this, "강의를 홈페이지에 등록하시겠습니까?");
					if(y == JOptionPane.OK_OPTION){
						
					}else{
						
					}
					
					frame.dispose();
					dispose();
				}
			});
			btnNewButton_2.setBounds(124, 10, 100, 56);
		}
		return btnNewButton_2;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("초마다");
			lblNewLabel.setBounds(161, 60, 39, 18);
		}
		return lblNewLabel;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setEnabled(false);
			spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinner.setBounds(10, 58, 140, 22);
		}
		return spinner;
	}
	private JLayeredPane getLayeredPane_1() {
		if (layeredPane == null) {
			layeredPane = new JLayeredPane();
			layeredPane.setBorder(new TitledBorder(null, "\uC790\uB3D9\uC804\uC1A1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			layeredPane.setBounds(12, 78, 212, 129);
			layeredPane.setLayout(null);
			layeredPane.add(getChckbxNewCheckBox());
			layeredPane.add(getSpinner());
			layeredPane.add(getLblNewLabel());
			layeredPane.add(getBtnNewButton_3());
			layeredPane.add(getBtnNewButton_4());
			layeredPane.add(getButton());
		}
		return layeredPane;
	}
	private JCheckBox getChckbxNewCheckBox() {
		if (chckbxNewCheckBox == null) {
			chckbxNewCheckBox = new JCheckBox("자동전송");
			chckbxNewCheckBox.setBounds(7, 24, 77, 26);
		}
		return chckbxNewCheckBox;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("▶");
			btnNewButton_3.setEnabled(false);
			btnNewButton_3.setBounds(10, 92, 70, 28);
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("■");
			btnNewButton_4.setEnabled(false);
			btnNewButton_4.setBounds(153, 92, 50, 28);
		}
		return btnNewButton_4;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("∥");
			button.setEnabled(false);
			button.setBounds(91, 92, 50, 28);
		}
		return button;
	}
}
