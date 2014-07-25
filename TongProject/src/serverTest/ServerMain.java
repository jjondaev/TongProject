package serverTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain extends Thread {
	int port = 4444;
	ServerSocket server;
	Socket socket;
	boolean flag = true; 
	
	ServerThread st;
	
	public ServerMain(){
		try {
			server = new ServerSocket(port);
			
			Thread t = new Thread(this);
			t.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			System.out.println("서버가 시작되었습니다.");
			
			flag = true;
			while(flag){
				socket = server.accept();
				
				st = new ServerThread(socket, this);
				st.start();
				
				System.out.println("클라이언트가 접속했습니다.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerMain sm = new ServerMain();
	}
	
}
