package sorting.java.practice;

 class QuickSort<E extends Comparable<E>> {

	
	public  int split(E[] array,int p,int q){
		
		int left=p+1;
		int right=q;
		E pivot=array[p];
		
		
		while(true){
			
		while(left<=right){
			int cmp=array[left].compareTo(pivot);
			if(cmp < 0){
				left++;
			}else
			{
				break;
			}
			
		}
		
		while(right>left){
			int cmp=array[right].compareTo(pivot);
			if(cmp >= 0)
				right--;
			else
				break;
		}
		
		//swap aray[left and array[right] if left<right
		if(left<right){
			E temp;
			temp=array[left];
			array[left]=array[right];
			array[right]=temp;
			left++;
			right--;
		}
		
		// Break if the left > right
		if(left>=right){
			break;
		}
	}
		
		
		//swap left-1 with array[0]
		
		E x=null;
		x=array[p];
		array[p]=array[left-1];
		array[left-1]=x;
		
		return left-1;
		
		
		
	}

	public  void quicksort(E[] array,int low, int high){
		
		if(low<high){
			
			int pivot=split(array,low,high);
			quicksort(array, low, pivot-1);
			quicksort(array, pivot+1, high);
			
		}
		
	}
	
	
	
	

}
