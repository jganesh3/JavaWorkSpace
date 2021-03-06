package string.manipulation;
/*
 * 1 Reverse the individual word
 * 2 Reverse the whole string i.e String = Hello Java output = Java Hello 
 * 

*/
public class ReverseString {

	public static void reverseWord(char[] word){
		
		int start=0;
		int end=word.length-1;
		char temp;
		for(;start<end;start++,end--){
			temp=word[start];
			word[start]=word[end];
			word[end]=temp;
		
			
		}
		
		
		
		
	}
	
	
	
	public static String reverseString(String string)throws ArrayIndexOutOfBoundsException{
		
		
		

			
			int len=string.length()-1;
			if(len==0)return string;
			char[] reverse=new char[len+1];
			boolean isLastword=false;  // this flag will notify that this is the last word in the string
			
			//Initialization
			int ptr=len;
			int endword=len;
			int startword=len;
			int arrptr=0; //  this will store the index for new array;
			
			//check if the startptr is greater than 0
			while(startword>=0){
			
			while( startword>=0  && string.charAt(startword)!=' '){
				
				startword--;
			}
				
			// when startword goes below 0 , it indicate the last word in string
			//correct the startword ptr  
			//
			if(startword<0)
				{
				startword=0;
				isLastword=true;
				}
			//we found the word  at location startword+1 to endword
			//copy this word to new array
			int marker=startword;
			//if it is not last word , startword will point to ' ' hence increment it to get actual start of the word
			//if it is last word startword will be exactly on index 0 of the original string
			if(!isLastword)startword++;
			while(startword<=endword){
				reverse[arrptr++]=string.charAt(startword++);
			}
			if(!isLastword && arrptr!=len)
				reverse[arrptr++]=string.charAt(marker);
			
			// reset the end word
			startword=endword=marker-1;
			
			
			
			
			}
			
			
			return new String(reverse);
			
		
			
			
			
			
			
	
		
		
		
	}
	
	
	public static void display(char[] data){
		if(data.length==0)
			{
			System.out.println("Empty Array");
			return;
			}
		for(char c :data)
			System.out.print(c+" ");
		
		System.out.println();
	}
	
	
	
	
	public static void main(String[] args) {
		
		char[] data={'h','e','l','l','o'};
		
		/*display(data);
		reverseWord(data);
		display(data);*/
		
		
		String d1="Hello Chico how are you doing today ??";
		
		System.out.println(reverseString(d1));
		
		
	}
	
	
}
