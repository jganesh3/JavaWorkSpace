package sorting.java.practice;

public class MainSort {
	
	
	public static void main(String[] args) {
		QuickSort<Integer> sort=new QuickSort<>();
		Integer []array={ 10,20,1,4,2};
		System.out.println("Array Before Sorting: ");
		for (int i = 0; i < array.length; i++) {
			
			System.out.print(array[i]+" ");
		}
				
		sort.quicksort(array, 0, array.length-1);
		
		System.out.println("Array After Sorting: ");
		for (int i = 0; i < array.length; i++) {
			
			System.out.print(array[i]+" ");
		}
		
	
	}

}
