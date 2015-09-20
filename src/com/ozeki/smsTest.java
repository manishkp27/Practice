package com.ozeki;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class smsTest {

	public static void main(String[] args) {
		 InitializeOutCall();
	}
	private static void InitializeOutCall() {
		try {
			URL url = new URL("http://ozekixepbx.ip:7780/?command=Call&"
					+ "Dialed=1001&" + "ApiExtension=9999&" + "CallerId=1000&"
					+ "CallerDisplayName=John+Smith&"
					+ "Url=http://yoursite.com/callconnected.php&"
					+ "ErrorUrl=http://yoursite.com/error.php");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			connection.connect();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	static void Initialize(){
		URL url;
		try {
			url = new URL("http://ozekixepbx.ip:7780/?command=SendSms&"
					+"ApiExtention=9999&"
					+ "Sender=%2b061554669&"
					+ "Recipient=%2b061554670&"
					+ "Recipient=%2b061554670&"
					+ "Message=Hello+Worl"
					+ "DeliveryReportURL=http://yoursite.com/smsdelivered.php");
		
		
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
