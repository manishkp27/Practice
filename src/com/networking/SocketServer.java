package com.networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class SocketServer {

	public static void main(String[] args) throws IOException {
		
		URL url=new URL("http://www.javatpoint.com/java-tutorial");  
		  
		System.out.println("Protocol: "+url.getProtocol());  
		System.out.println("Host Name: "+url.getHost());  
		System.out.println("Port Number: "+url.getPort());  
		System.out.println("File Name: "+url.getFile());  
		
		/*System.out.println("Server:Creating socket");
		ServerSocket ss = new ServerSocket(6666);
		System.out.println("Socket Accpet, establishes connection");
		Socket s=ss.accept();
		
		System.out.println("get input stream");
		DataInputStream dis = new DataInputStream(s.getInputStream());
		System.out.println("message= "+(String)dis.readUTF());
		
		dis.close();
		ss.close();
		System.out.println("ServerSocket Closed");*/
	}

}
