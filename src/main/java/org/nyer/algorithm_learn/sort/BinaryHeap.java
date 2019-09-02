package org.nyer.algorithm_learn.sort;

import java.util.Arrays;
import java.util.Comparator;

public class BinaryHeap<T> {
	
	private T[] array;
	
	private int size;
	
	private Comparator<T> comparator;
	
	@SuppressWarnings("unchecked")
	public BinaryHeap(int initialCapacity, Comparator<T> comparator) {
		
		this.array = (T[]) new Object[initialCapacity];
		this.comparator = comparator;
	}
	
	public void add(T e) {
		
		if (size >= array.length) {
			
			growUp();
		}

		int i = size;
		size ++;
		siftUp(i, e);
	}
	
	void growUp() {
		
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) new Object[array.length * 2];
		System.arraycopy(array, 0, newArray, 0, array.length);
		this.array = newArray;
	}
	
	void siftUp(int i , T e) {
		
		while (i > 0) {
			
			int parent = (i - 1) >>> 1;
			T c = array[parent];
			if (comparator.compare(c, e) <= 0) {
				break;
			}
			
			array[i] = c;
			i = parent;
		}
		
		array[i] = e;
	}
	
	public T remove() {
		
		if (size <= 0) {
			
			return null;
		}
		
		T v = array[0];
		int i = --size;
		T e = array[i];
		array[i] = null;
		
		siftDown(0, e);
		
		return v;
	}
	
	void siftDown(int i , T e) {
		
		int half = size >>> 1;
		while (i < half) {
			
			int child = (i << 1) + 1;
			T c = array[child];
			if (child + 1 < size && comparator.compare(array[child + 1], c) < 0) {
				
				c = array[child = child + 1];
			}
			
			if (comparator.compare(c, e) >= 0) {
				
				break;
			}
			
			array[i] = c;
			i = child;
		}
		
		array[i] = e;
	}
	
	public static void main(String[] args) {
		
		BinaryHeap<Integer> heap = new BinaryHeap<>(100, Integer::compareTo);
		Arrays.asList(2,3,5,6,7,26,16,1,122,512,125,-1,12,-22).forEach(e -> heap.add(e));
		
		Integer element = null;
		while ((element = heap.remove()) != null) {
			
			System.out.println(element);
		}
	}
}
