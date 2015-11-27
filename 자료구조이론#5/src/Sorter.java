/*
 * CSE2010 Homework #5: Sorter.java
 * 
 * Complete this file!
 * 
 */

public class Sorter {
	
	public static void selectionSort(int[] entry) {
		// Your code goes here!
		
		int temp = 0;
		int min = 0;
		
		for(int i = 0 ; i < entry.length ; i++){
			min = 0;
			for(int j = i+1 ; j <entry.length ; j++){
				if(entry[j]<entry[min]){
					min = j;
				}
			}
			temp = entry[i];
			entry[i] = entry[min];
			entry[min] = temp;
			System.out.println(entry[i]);
		}
		
		
	}
	
	public static void insertionSort(int[] entry) {
		// Your code goes here!
		int temp;
		int set;
		for(int i = 1 ; i < entry.length; i++){
			set = i;
			
			for(int j = i-1; j > -1; j--){
				if(entry[j]>entry[set]){
					entry[j+1] += entry[j];
				}else{
					entry[j] = entry[set];
					break;
				}
			}
			System.out.println(entry[i]);
		}
	}
	
	
	
	public static void heapSort(int[] entry) {
		// Your code goes here!
		int[] heaps = new int[entry.length];
		
		
	}
}