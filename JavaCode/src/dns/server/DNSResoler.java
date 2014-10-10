package dns.server;
/*
 * @Author: Ganesh Joshi
 * Date: 10/10/2014
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

 class DNSResoler implements Runnable{
	 
	 private Socket server=null;
	 private InetCache cache;
	 
	 private InputStream in;
	 private OutputStream out;
	 private BufferedReader buffer=null;
	 private PrintStream print=null;
	 private InetAddress address=null;
	 
	 public DNSResoler(Socket serv,InetCache cache){
		 this.cache=cache;
		 this.server=serv;
	 }
	 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		String Line;
		System.out.println("Welcome ... Please key in the URL");
		
		
		
		try{
			
			in=server.getInputStream();
			out=server.getOutputStream();
			buffer=new BufferedReader(new InputStreamReader(in));
			print=new PrintStream(out);
			
			while((Line=buffer.readLine())!=null){
				//System.out.println(Line);
				//Step 1 check if the URL is already present in the cache table
				URL temp=null;
				try{
					temp=new URL("http://"+Line);
				
				if(cache.contains(temp)){
					// URL already present 
					//get the InetAddress
					address=cache.getInetAddress(temp);
					print.println("IP address:-" +address.getHostAddress());
					
				}else{
					
					//URL is not in cache
					address = InetAddress.getByName(new URL("http://"+Line).getHost());
					cache.add(temp, address);
					print.println("IP address:-" +address.getHostAddress());
				}
				
				}catch(Exception e){
					print.println("Please enter valid URL  e.g. www.testurl.com");
					e.printStackTrace();
					
				}
			    
			  
				
				
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	
		
		
		//Ok ending the telnet session here
		//release all resources
		in=null;
		out=null;
		buffer=null;
		print=null;
		cache=null;
		
	}

}
