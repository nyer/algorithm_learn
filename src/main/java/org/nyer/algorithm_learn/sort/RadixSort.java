package org.nyer.algorithm_learn.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RadixSort implements Sort<Integer> {

	@Override
	public List<Integer> sort(List<Integer> list, Comparator<Integer> cmp) {
		
		Integer max = null;
		for (Integer item : list) {
			
			if (max == null || cmp.compare(max, item) < 0) {
				
				max = item;
			}
		}
		
		int maxDigitCount = 1;
		while ((max = (max / 10)) > 1) {
			
			maxDigitCount ++;
		}
		
		for (int i = 0; i <= maxDigitCount; i ++) {
			
			List<Integer> tempList = new ArrayList<>(list);
			int[] countingArray = {0,0,0,0,0,0,0,0,0,0};
			for (Integer item : list) {
				
				countingArray[getDigitAt(item, i)] ++;
			}
			
			for (int m = 1; m < 10; m ++) {
				
				countingArray[m] += countingArray[m - 1];
			}
			
			for (int j = list.size() - 1; j >= 0; j --) {
			
				Integer item = list.get(j);
				int digit = getDigitAt(item, i);
				tempList.set(countingArray[digit] -1 , item);
				countingArray[digit] --;
			}
			
			list = tempList;
		}
		
		return list;
	}
	
	private int getDigitAt(Integer num, int pos) {
		int digit = 0;
		String itemString = String.valueOf(num);
		if (itemString.length() > pos) {
			digit = Character.digit(itemString.charAt(itemString.length() - pos - 1), 10);
		}
		
		return digit;
	}
	
	public static void main(String[] args) {
		
		Sort<Integer> sort = new RadixSort();

        Random random = new Random();

        int size = 10000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size ; i++) {

            list.add(random.nextInt(size));
        }
        
        list = sort.sort(list, Integer::compareTo);
        System.out.println(list);
	}
	
}
