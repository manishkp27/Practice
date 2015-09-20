package com.networking;

import java.net.*;
public class DatagramSocket {

	public static void main(String[] args) {
		SktServer server = new SktServer();
		server.start();

		SktClient client = new SktClient();
		client.start();
		
		
	}

}

class SktServer extends Thread {
	
	public void run(){
		System.out.println("SocketServer runing");
		
		DatagramSocket ds = new DatagramSocket();  
	    String str = "Welcome java";  
	    InetAddress ip = null;
		try {
			ip = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}  
	     
	    DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);  
	   /* ds.send(dp);  
	    ds.close();*/  
	}
}

class SktClient extends Thread{
	
	public void run(){
		System.out.println("SocketClient runing");
	}
}
