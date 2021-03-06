package string.manipulation;

import java.util.Hashtable;
/*
 * Write a function which will remove the duplicate characters in String
 * e.g. "aaab" ==> "ab" 
 * 
 * Write algorithm using extra memory and without using extra memory
*/
public class RemoveDupsChar {

	/*
	 * Algo which uses Extra memory
	*/
	
	public static StringBuilder removeDupsI(String input){
		
		//Create an lookup HashTable which will indicate if the character is duplicate or not
		Hashtable<Character,Boolean> lookup=new Hashtable<>();
		
		StringBuilder correctedString=new StringBuilder();
		
		//iterate over the String
		for(int i=0;i<input.length();i++){
			
			//check if the HashTable already contains this character
			//if the look up table does't contain the character append that to string builder and update the look
			//up table
			if(!lookup.containsKey(input.charAt(i)))
			{
				lookup.put(input.charAt(i), true);
				correctedString=correctedString.append(input.charAt(i));
			}else
			{
				//if lookup already contains this character just just continue the loop
				continue;
			}
			
		}
		
		
		return correctedString;
		
		
	}
	
	
	/*
	 * Algo without use of Extra memory
	*/
	
	
	public static char[] rermoveDups2(char[] data){
		
		if(data.length==0) return data;
		if(data.length<2) return data;
		int tail=1;
		int j;
		
		for(int i=0;i<data.length;i++){
			
			for(j=0;j<tail;j++){
				
				if(data[i]==data[j])
					break;
					
			}
			if(j==tail){
				data[tail]=data[i];
				++tail;
			}
			
		}
		
		data[tail]=0;
		
		
		return data;
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		String x="aaaab";
		//System.out.println(removeDupsI(x).toString());
		char[] d2={'a','a','b','b','c','c'};
		d2=rermoveDups2(d2);
		
		for(char a:d2){
			System.out.println(a);
		}
		
	}
	
	
}
