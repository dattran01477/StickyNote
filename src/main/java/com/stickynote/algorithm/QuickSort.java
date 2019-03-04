package com.stickynote.algorithm;

import java.util.List;

public class QuickSort<T> {

	
	public void quickSort(List<T> ls, int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(ls, begin, end);
	 
	        quickSort(ls, begin, partitionIndex-1);
	        quickSort(ls, partitionIndex+1, end);
	    }
	}
	
	protected int partition(List<T> ls, int begin, int end) {
	   return 0;
	}

}
