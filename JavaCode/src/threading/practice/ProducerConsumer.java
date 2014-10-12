package threading.practice;


class sharedData{
	private int x;
	
	public sharedData(int x){
		this.x=x;
	}
	
	
	public int getData(){
		return this.x;
	}
	
	//Synchronizing increment method such that
	public  synchronized void increment(){
		x++;
	}
	
	public synchronized void decrement(){
		x--;
	}
	
}


class consumer implements Runnable{
	sharedData data;
	
	public consumer(sharedData x){
		this.data=x;
		
	}
	
	public void run(){
	
		for (int i = 0; i < 10; i++) {
			
			
			try {
				data.decrement();
				System.out.println("Consumer counsuming "+data.getData());
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}

class producer implements Runnable{
	sharedData data;
	
	public producer(sharedData d){
		this.data=d;
	}
	@Override
	public void run() {
for (int i = 0; i < 10; i++) {
			
			
			try {
				data.increment();
				System.out.println("Producer producing "+data.getData());
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
}
	
}



public class ProducerConsumer {

	
	
	public static void main(String[] args) {
		sharedData share=new sharedData(1);
		consumer consume=new consumer(share);
		producer produce=new producer(share);
		
		Thread t1=new Thread(consume);
		Thread t2=new Thread(produce);
		
		try{
			
			t1.start();
			t2.start();
			
		}catch(Exception e){
			
		}
		
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Printing the value of shared data "+ share.getData());
		
	}
	
}
