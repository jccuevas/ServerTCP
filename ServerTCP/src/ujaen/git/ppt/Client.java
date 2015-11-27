package ujaen.git.ppt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread {

	Socket mSocket = null;
	public static final String ball="ball";
	private int number=0;

	public Client(String host,int port) throws UnknownHostException, IOException {
		mSocket = new Socket(host,port);
		this.start();
	}

	public void run() {
		if (mSocket != null) {
			try {
				String input="";
				DataInputStream dis = new DataInputStream(mSocket.getInputStream());
				DataOutputStream dos = new DataOutputStream(mSocket.getOutputStream());
				input=dis.readUTF();
				System.out.println("CLIENTE [RECIBIDO]: "+input);
				while (true) {
					
					dos.writeUTF(ball);
					dos.writeInt(number);
					dos.flush();
					number++;
					input=dis.readUTF();
					System.out.println("CLIENTE [RECIBIDO]: "+input);
					sleep(5000);
				

				}
			} catch (IOException ex) {
				System.err.println("CLIENTE [ERROR]: "+ex.getMessage());
				ex.printStackTrace();
			} catch (InterruptedException e) {
				System.err.println("CLIENTE [ERROR]: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
