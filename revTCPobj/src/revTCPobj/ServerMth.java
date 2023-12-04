package revTCPobj;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMth extends Thread{

	public static void main(String[] args) {
		
		new ServerMth().start();
		

	}
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(1237);
			System.out.println("en attend");
		
			while (true) {
			Socket s = ss.accept();
			Server server =new Server(s);
			
			Thread ClientThread = new Thread(server);
			ClientThread.start();
			s.close();
			}      	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
