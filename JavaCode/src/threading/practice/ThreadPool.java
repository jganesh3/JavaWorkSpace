package threading.practice;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Worker implements Runnable{
	
	
	LinkedList<Integer> data;
	
	//default constructor
	public Worker(LinkedList<Integer> l){
		this.data=l;
	}
	
	
	
	
	@Override
	public void run(){
		
			print();
			
		
	}
	
	
	public synchronized void print(){
		
		if(!data.isEmpty())
		{
			System.out.println(Thread.currentThread().getName()+"  "+data.poll());
			
			try{
				
				Thread.sleep(1000);
				
			}catch(Exception e){
				
			}
		}
			

	}
}





public class ThreadPool {
	
	LinkedList<Integer> Q=new LinkedList<>();
	
	public void generator(){
	
		for(int i=0;i<20;i++)
			{
			Random m=new Random();
			Q.add(m.nextInt());
			}
			
	
	}
	
	
	public boolean isEmpty(){
		return Q.isEmpty();
	}
	
	
	public LinkedList<Integer> getQ(){
		return this.Q;
	}
	
	
	
	
	public static void main(String[] args) {
		
		ThreadPool p=new ThreadPool();
		
		p.generator();
		ExecutorService exe=Executors.newFixedThreadPool(4);
		while(!p.isEmpty()){
			exe.submit(new Worker(p.getQ()));
		}
		
		
		
		
		exe.shutdown();
		
	}
	
	
	
	

}
