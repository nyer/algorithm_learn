package org.nyer.algorithm_learn.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * Find a position from the sorted part whose element is bigger or smaller than the one
 * that is at the first position of unsorted part.
 * @param <T>
 */
public class InsertSort<T> implements Sort<T> {


    @Override
    public List<T> sort(List<T> list, Comparator<T> cmp) {

        int s = list.size();
        for (int i = 1; i < s; i++) {

            T curValue = list.get(i);
            for (int j = 0; j < i; j++) {

                T value = list.get(j);
                if (cmp.compare(value, curValue) > 0) {

                    for (int k = i; k > j; k--) {

                        list.set(k, list.get(k - 1));
                    }
                    list.set(j, curValue);

                    break;
                }
            }
        }

        return list;
    }


    public static void main(String[] args) {

        Sort<Integer> sort = new InsertSort<>();

        Random random = new Random();

        int size = 10000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size ; i++) {

            list.add(random.nextInt(size * 10));
        }

        sort.sort(list, Integer::compareTo);
        System.out.println(list);
    }
}
