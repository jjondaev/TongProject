package serverTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;

public class ServerThread extends Thread {
	Socket socket;
	ServerMain sm;
	
	ObjectOutputStream send;
	ObjectInputStream receive;
	
	SocketData sd = new SocketData();
	boolean flag = true;
	
	public ServerThread(Socket socket, ServerMain sm){
		 this.socket = socket;
		 this.sm = sm;
	}

	@Override
	public void run() {
		try{
			System.out.println("파일 전송 준비");
			send = new ObjectOutputStream(socket.getOutputStream());
			receive = new ObjectInputStream(socket.getInputStream());
			
			// ImageIcon을 이용해 Socket통신해 이미지 전송
//			ImageIcon img = new ImageIcon("c:/test.png");
//			send.writeObject(img);
			
			// BufferedImage를 ImageIO를 이용해 이미지 전송
			BufferedImage img =  ImageIO.read(new File("c:/test.png"));
			ImageIO.write(img,"png", socket.getOutputStream());
			
			System.out.println("서버에서 클라이언트로 파일 전송");
			flag = true;
			while(flag){
				System.out.println("서버 대기");
				sd = (SocketData) receive.readObject();
			}
			
		}catch(Exception e){
			e.getStackTrace();
		}
	}
	
	
}
