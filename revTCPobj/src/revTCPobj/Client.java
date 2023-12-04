package revTCPobj;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import obj.Operation;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket s = new Socket("localhost",1237);
			System.out.println("connecté");
			Scanner sc = new Scanner (System.in);
			System.out.println("donner un entier ");
			int op1 =sc.nextInt();
			System.out.println("donner un entier ");
			int op2 = sc.nextInt();
			System.out.println("donner un operateur ");
			String oper =sc.next();
			Operation operation = new Operation(op1, op2, oper);
			OutputStream os = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(operation);
			InputStream is = s.getInputStream();
			int res = is.read();
			System.out.println("resultat="+res);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
