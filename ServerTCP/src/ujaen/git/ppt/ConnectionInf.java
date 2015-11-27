package ujaen.git.ppt;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;


public class ConnectionInf implements Runnable {

	Socket mSocket;
	public static String MSG_WELCOME = "OK Bienvenido al servidor de pruebas\r\n";

	public ConnectionInf(Socket s) {
		mSocket = s;
	}

	@Override
	public void run() {
		String inputData = null;
		String outputData = "";
		int estado = 0;
		int number=0;
		if (mSocket != null) {
			try {
				DataOutputStream output = new DataOutputStream(mSocket.getOutputStream());
				DataInputStream input = new DataInputStream(mSocket.getInputStream());
				output.writeUTF(MSG_WELCOME);
				output.flush();

				while (mSocket.isConnected()) {
					inputData = input.readUTF();
					number=input.readInt();
					System.out.println("Servidor [Recibido]> " + inputData +" "+number);
					
					

					output.writeUTF("OK "+inputData+" "+number);
					output.flush();

				}
				System.out.println(
						"Servidor [Finalizado]> " + mSocket.getInetAddress().toString() + ":" + mSocket.getPort());

				input.close();
				output.close();
				mSocket.close();
			} catch (SocketException se) {

				se.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
