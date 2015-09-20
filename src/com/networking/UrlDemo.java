package com.networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlDemo {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.javatpoint.com/java-tutorial");
			
			/*URLConnection urlcon = url.openConnection();
			InputStream iStream = urlcon .getInputStream();
			int i;
			while((i=iStream.read())!=-1)
				System.out.print((char)i);*/
			
			/*HttpURLConnection hurlcon = (HttpURLConnection)url.openConnection();
			String key;
			int i=1;
			while((key=hurlcon.getHeaderFieldKey(i))!=null){  
				System.out.println(key+"==>"+hurlcon.getHeaderField(i));
				i++;
			}*/
			
			InetAddress ipnetaddr = InetAddress.getByName("www.javatpoint.com");
			//InetAddress ipnetaddr = InetAddress.getByName("localhost:8080");
			System.out.println(ipnetaddr.getHostName()+", "+ipnetaddr.getHostAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
