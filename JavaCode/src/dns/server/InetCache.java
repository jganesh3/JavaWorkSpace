package dns.server;
/*
 * @Author: Ganesh Joshi
 * Date: 10/10/2014
*/
import java.net.InetAddress;
import java.net.URL;
import java.util.Hashtable;


//InetCache class object will be shared among the threads. This class will store the URL and InetAddress in HashTable
//So that we don't need to query it 


 class InetCache {
	 
	 
	  Hashtable<URL, InetAddress> lookup;
	
	  
	  public InetCache(){
		  lookup=new Hashtable<>();
		 
	  }
	  
	  
	  public boolean contains(URL url){
		  
		  return lookup.containsKey(url);
		  
	  }
	  
	  public InetAddress getInetAddress(URL url){
		  
		  return lookup.get(url);
	  }
	  
	  
	  //Hash Table is Synchronized 
	  public  void add(URL url,InetAddress add){
		  
		  //Validate the URL and add
		  if(url==null || add ==null)
			  return;
	
		  lookup.put(url, add);		  
		  
	  }
	 
	 

}
