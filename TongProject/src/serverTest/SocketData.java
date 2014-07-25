package serverTest;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class SocketData implements Serializable {
	static final long serialVersionUID = 100000;
	
	String command; // 로그인, 로그아웃, 서버중지, 서버시작...	
	String user; 	// 메시지 작성자
	Object obj;
	ImageIcon img;
	String filename;

	public SocketData(String command, String user, Object obj) {
		this.command = command;
		this.user = user;
		this.obj = obj;
	}
	
	public SocketData(){
		
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
