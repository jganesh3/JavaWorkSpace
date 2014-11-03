package graph.builder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
	Simple Web Crawler 
	Algorithm used BFS
*/

class WebCrawler {
	
	private LinkedList<String> Q=new LinkedList<>();
	
	String root="http://www.cnn.com";
	HashSet<String> list=new HashSet<>();
	
	
	
	public static void main(String[] args) {
		try{
		URL u = new URL("http://www.cnn.com");
		URLConnection conn = u.openConnection();
		BufferedReader in = new BufferedReader(
		                        new InputStreamReader(
		                            conn.getInputStream()));
		StringBuffer buffer = new StringBuffer();
		String inputLine;
		while ((inputLine = in.readLine()) != null) 
		    buffer.append(inputLine);
		in.close();
		System.out.println(buffer.toString());
		
		String regexe="http://(\\w+\\.)*(\\w+)";
		Pattern patern=Pattern.compile(regexe);
		Matcher matcher=patern.matcher(buffer);
		while(matcher.find()){
			String w=matcher.group();
			System.out.println(w);
		}
		
	}catch(Exception e){
		
	}
	
	
	}

	}
