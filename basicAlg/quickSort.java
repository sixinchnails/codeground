package ax;

import java.util.Arrays;

public class QuickSort {
	static int[] arr;
	static int pivot;
	
	static void quickSort(int[] arr, int low, int high) throws Exception{
		if(high<=low) return;
		
		pivot = partition(arr, low, high);

		quickSort(arr, low, pivot-1);
		quickSort(arr, pivot+1, high);
	}
	
	static int partition(int[] arr, int low, int high) {
		int left = low, right = high;
		pivot = low;
		while(left<right) {
			left = low;
			right = high;
			
			for(int i=right;i>=low;i--) {
				if(arr[pivot]>=arr[i]) {
					right = i;
					break;
				}
			}
			
			for(int i=low+1;i<=high;i++) {
				if(arr[pivot]<=arr[i]) {
					left = i;
					break;
				}
			}
			
			if(left<right) {
				int tmp = arr[right];
				arr[right] = arr[left];
				arr[left] = tmp;
			}
		}
		
		if(left>=right) {
			int tmp = arr[right];
			arr[right] = arr[pivot];
			arr[pivot] = tmp;
			
			return right;
		}
		
		return pivot;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 4, 5, 2, 3, 7, 10, 8, 4};
		
		System.out.println(Arrays.toString(arr));
		
		try {
			quickSort(arr, 0, arr.length-1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
