package revTCPobj;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import java.io.OutputStream;
import java.net.Socket;

import obj.Operation;


public class Server extends Thread {
	 	
	private Socket socket ;
	public Server (Socket socket){
		this.socket=socket;
		
	}
	
		@Override
		public void run() {
			try {
				InputStream is =socket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				Operation op =(Operation)ois.readObject();
				int op1 =op.getOp1();
				int op2 = op.getOp2();
				String  oper = op.getOper();
				int res= 0;
				switch (oper ) {
				case "+": res = op1 + op2 ;
				break;
				case"-": res = op1 - op2 ;
				break;
				case "*" : res = op1*op2;
				break;
				}
				OutputStream os =socket.getOutputStream();
				os.write(res);
			} catch (IOException e) {
		
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		
	}

