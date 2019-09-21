package org.nyer.algorithm_learn.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CountingSort implements Sort<Integer> {

    @Override
    public List<Integer> sort(List<Integer> list, Comparator<Integer> cmp) {

        Integer max = null;
        Integer min = null;
        for (Integer element :
                list) {
            if (max == null || cmp.compare(max, element) < 0) {

                max = element;
            }

            if (min == null || cmp.compare(min, element) > 0) {

                min = element;
            }
        }

        int[] countingArray = new int[max.intValue() - min.intValue() + 1];
        for (int i = 0; i < list.size(); i++) {

            Integer e = list.get(i);

            countingArray[e.intValue() - min.intValue()] ++;
        }

        List<Integer> result = new ArrayList<>(list.size());
        for (int i = 0; i < countingArray.length; i++) {

            int j = 0;
            while (j < countingArray[i]) {

                result.add(i + min);
                j ++;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        Sort<Integer> sort = new CountingSort();

        Random random = new Random();

        int size = 100;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size ; i++) {

            list.add(random.nextInt(10000));
        }

        list = sort.sort(list, Integer::compareTo);
        System.out.println(list.size());
        System.out.println(list);
    }
}
