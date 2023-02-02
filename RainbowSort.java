package test;

import java.util.*;

public class RainbowSort {
	static int[] arr = new int[] {4, 2, 8, 6, 0, 5, 1, 7, 3, 9};
	
	static void initialize(int[] init_arr) {
		for(int i = 0; i < arr.length; i++) {
			init_arr[i] = arr[i];
		}
	}
	
	static void swap(int[] arr, int first, int later) {
		if (first < 0 || first >= arr.length || later < 0 || later >= arr.length) {
			System.out.println("인덱스가 범위를 벗어남.");
			return;
		}
		
		int tmp = arr[first];
		arr[first] = arr[later];
		arr[later] = tmp;
	}
	
	static void insertSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int idx = i;
			
			for(int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[idx]) {
					int tmp = arr[idx];
					arr[idx] = arr[j];
					arr[j] = tmp;
					idx = j;
				}else break;
			}
		}
	}
	
	static void bubbleSort(int[] arr) {
		for(int i = arr.length; i > 1; i--) {
			for(int j = 1; j < i; j++) {
				if (arr[j] < arr[j - 1]) swap(arr, j - 1, j);
			}
		}
	}
	
	static void mergeSort(int left, int right, int[] arr) {
	}
	
	public static void main(String[] args) {
		int[] main_arr = new int[arr.length];
		
		initialize(main_arr);
		System.out.println("Insertion Sort");
		System.out.println("Before: "+Arrays.toString(main_arr));
		insertSort(main_arr);
		System.out.println("After: "+Arrays.toString(main_arr));
		System.out.println();
		
		initialize(main_arr);
		System.out.println("Bubble Sort");
		System.out.println("Before: "+Arrays.toString(main_arr));
		bubbleSort(main_arr);
		System.out.println("After: "+Arrays.toString(main_arr));
		System.out.println();
		
		initialize(main_arr);
		System.out.println("Merge Sort");
		System.out.println("Before: "+Arrays.toString(main_arr));
		mergeSort(0, main_arr.length, main_arr);
		System.out.println("After: "+Arrays.toString(main_arr));
		System.out.println();
	}
}
