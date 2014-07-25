package imgTest;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TransparentWindowExample {
	public static void main(String[] args) {
		JFrame frame = new JFrame("배경이 투명한 윈도우");
		TransparentBackground bg = new TransparentBackground(frame);
		bg.setLayout(new BorderLayout());
		JButton button = new JButton("버튼 Component");
		bg.add("North", button);
		JLabel label = new JLabel("이것은 새로 생성한 윈도우에서 만든겁니다");
		bg.add("South", label);
		frame.getContentPane().add("Center", bg);
		frame.pack();
		frame.setSize(150, 100);
		frame.setVisible(true);
	}
}