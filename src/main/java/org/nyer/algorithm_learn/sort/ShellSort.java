package org.nyer.algorithm_learn.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ShellSort<T> implements Sort<T> {

    @Override
    public List<T> sort(List<T> list, Comparator<T> cmp) {

        int size = list.size();
        int gap = size;
        while ((gap = gap / 2) > 0) {

            for (int i = gap; i < size; i++) {

                int j = i;
                while (j - gap >= 0 && cmp.compare(list.get(j - gap), list.get(j)) > 0) {

                    T temp = list.get(j);
                    list.set(j, list.get(j - gap));
                    list.set(j - gap, temp);
                    j = j - gap;
                }
            }
        }

        return list;
    }


    public static void main(String[] args) {

        Sort<Integer> sort = new ShellSort<>();

        Random random = new Random();

        int size = 10000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {

            list.add(random.nextInt(size * 10));
        }

        sort.sort(list, Integer::compareTo);
        System.out.println(list);
    }
}
