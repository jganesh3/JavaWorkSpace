package leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;

public class FizzBuzz {

	
	

	
	
	public static void main(String[] args){
		
		
		
		/*try{
		FileWriter f=new FileWriter("C:\\Users\\GJ\\Documents\\GitHub\\JavaWorkSpace\\JavaCode\\src\\data1.txt");
		if(f!=null)
		{
			BufferedWriter buffer=new BufferedWriter(f);
		
		buffer.write("this is test");
		buffer.close();
		
		}
		
		
		
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		File file = new File(args[0]);
	    BufferedReader in;
	    BufferedWriter out;
	    //FileWriter f=new FileWriter(args[0]);
	    PrintWriter printer;
		try {
			in = new BufferedReader(new FileReader(file));
			out=new BufferedWriter(new FileWriter(args[0]));
			//printer=new PrintWriter(out);
			 String line;
			    while ((line = in.readLine()) != null) {
			        String[] lineArray = line.split("\\s");
			        if (lineArray.length > 0) {
			            
			        	int div1=Integer.parseInt(lineArray[0]);
			        	int div2=Integer.parseInt(lineArray[1]);
			        	int count=Integer.parseInt(lineArray[2]);
			        	
			        	
			        	int i=0;
			        	
			        	//printer.print("Testing write file operation");
			        	while(i<count){
			        		
			        		if(i%div1==0 && i%div2==0){
			        			out.write("FB");
			        			i++;
			        		}else if(i%div1==0){
			        			out.write("F");
			        			i++;
			        		}else if(i%div2==0){
			        			out.write("B");
			        			i++;
			        			}
			        		else
			        			out.write(i);
			        			i++;
			        		}
			        		
			        		
			        	}
			        	
			        
			        	
			        }
			    
			    
			    
			    out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	   
		
	}
	
	
}
