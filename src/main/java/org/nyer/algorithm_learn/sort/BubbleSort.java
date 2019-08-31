package org.nyer.algorithm_learn.sort;

import java.util.*;

/**
 *
 * compare adjacent elements and swap them if necessary.
 * @param <T>
 */
public class BubbleSort<T> implements Sort<T>{

    public List<T> sort(List<T> list, Comparator<T> cmp) {

        int s = list.size();
        while (s > 1) {

            for (int i = 1; i < s;i ++) {

                T left = list.get(i - 1);
                T right = list.get(i);

                if (cmp.compare(left, right) > 0) {

                    T temp = right;
                    list.set(i, left);
                    list.set(i -1, temp);
                }
            }

            s --;
        }

        return list;
    }

    public static void main(String[] args) {

        Sort<Integer> sort = new BubbleSort<>();

        Random random = new Random();

        int size = 100;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size ; i++) {

            list.add(random.nextInt(10000));
        }

        sort.sort(list, Integer::compareTo);
        System.out.println(list);
    }
}
