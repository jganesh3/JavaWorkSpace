package sorting.java.practice;

import java.util.ArrayList;

public class HeapSort {
	
	
	ArrayList<Integer> array=new ArrayList<>();
	
	
	public void HeapSort(){
		
		
			
		
		
	}
	
	
	public int Parent(int i){
		
		return (i/2);
		
	}
	
	
	public int left(int i){
		return 2*i;
	}
	
	public int right(int i){
		return (2*i+1);
	}
	
	
	
	// Max heapify will be used to max hipify the ArrayList
	// We are passing the index of the last added element in the ArrayList.
	public void max_heapify(int i){
		
		
		int l=left(i);
		int r=right(i);
		int largest;
		
		if(l<=array.size() && array.get(l) > array.get(i)){
			largest=l;
		}else
		{
			largest=i;
		}
		
		
		if(largest!=i)
		{
			// exchange a[i] with a[largest]
			int temp;
			temp=array.get(i);
			array.add(i,array.get(largest));
			max_heapify(largest);
		}
		
			
		
	}
	
	
	
	public void buildMaxHeap()
	{
		
		array.add(20);
		array.add(3);
		array.add(90);
		array.add(75);
		array.add(10);
		array.add(15);
		array.add(55);
	
		
		
		for(int i=array.size()/2;i>=1;i--)
		{
			max_heapify(i);
		}
	}
	
	
	public void display(){
		for (Integer i:array){
			System.out.print(i+"   ");
		}
	}
	
	
	public static void main(String[] args) {
		HeapSort heap=new HeapSort();
		
		
		heap.buildMaxHeap();
		
		heap.display();
		
	}

}
