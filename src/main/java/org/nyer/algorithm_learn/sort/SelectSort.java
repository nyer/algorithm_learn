package org.nyer.algorithm_learn.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * find the biggest or smallest one from the unsorted part and place it at first position.
 * @param <T>
 */
public class SelectSort<T> implements Sort<T> {

    @Override
    public List<T> sort(List<T> list, Comparator<T> cmp) {

        int ls = list.size();
        for (int i = 0, s = ls - 1; i < s; i++) {

            Integer mIdx = i;
            T mValue = list.get(i);
            for (int j = i + 1; j < ls; j++) {

                T cValue = list.get(j);
                if (cmp.compare(mValue, cValue) > 0) {

                    mIdx = j;
                    mValue = cValue;
                }
            }

            if (mIdx != i) {

                T temp = list.get(i);
                list.set(i, mValue);
                list.set(mIdx, temp);
            }
        }

        return list;
    }

    public static void main(String[] args) {

        Sort<Integer> sort = new SelectSort<>();

        Random random = new Random();

        int size = 10000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size ; i++) {

            list.add(random.nextInt(size));
        }

        sort.sort(list, Integer::compareTo);
        System.out.println(list);
    }
}
