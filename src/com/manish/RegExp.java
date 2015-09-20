package com.manish;

import java.util.regex.*;

public class RegExp {

	public static void main(String[] args) {
		/*Pattern pt = Pattern.compile("(.*)(\\d+)(.*)");
		Matcher matcher = pt.matcher("This order was placed for QT3000! OK?");
		
		while(matcher.find()){
			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
		}*/
		
		Pattern pt = Pattern.compile("a*b");
		Matcher matcher = pt.matcher("aabfooaabfooabfoob");
		StringBuffer sb = new StringBuffer();
		while(matcher.find()){
			matcher.appendReplacement(sb, "-");
			System.out.println(sb+" ["+matcher.start()+","+matcher.end()+"]");
		}
		matcher.appendTail(sb);
		System.out.println(sb);
	}

}
