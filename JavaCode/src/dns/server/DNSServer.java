package dns.server;
/*
 * @Author: Ganesh Joshi
 * Date: 10/10/2014
*/
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DNSServer {

	
	
	public static void main(String[] args){
	
		
		ServerSocket conection=null;
		Socket server=null;
		//create new Executor Service
		ExecutorService exe=Executors.newFixedThreadPool(20);
		try {
			
			
			conection=new ServerSocket(8080);
			while(true){
				server=conection.accept();
				//System.out.println("Welcome to DNS Server!!");
				exe.submit(new DNSResoler(server,new InetCache()));
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
			try {
				conection.close();
				exe.shutdownNow();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
	
		
		
	}
	
	
	
}
