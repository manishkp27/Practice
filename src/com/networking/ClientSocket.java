package com.networking;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("client:Creating socket");
		Socket s = new Socket("local",6666);
		
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		dos.writeUTF("hellow server");
		System.out.println("client:send Data");
		dos.flush();
		
		dos.close();
		s.close();
	}

}
