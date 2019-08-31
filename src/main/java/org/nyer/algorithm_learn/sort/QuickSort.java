package org.nyer.algorithm_learn.sort;

import java.util.*;

public class QuickSort<T> implements Sort {

    @Override
    public List sort(List list, Comparator cmp) {

        quickSort(list, 0, list.size() - 1, cmp);
        return list;
    }

    void quickSort(List<T> list, int start, int end, Comparator<T> cmp) {

        if (start >= end) {

            return;
        }

        T pivot = list.get(start);
        int from = start;
        int to = end;
        while (from < to) {

            while (from < to && cmp.compare(pivot, list.get(to)) <= 0) {

                to--;
            }

            list.set(from, list.get(to));
            while (from < to && cmp.compare(pivot, list.get(from)) >= 0) {

                from++;
            }

            list.set(to, list.get(from));
        }

        list.set(from, pivot);

        quickSort(list, start, from - 1, cmp);
        quickSort(list, from + 1, end, cmp);
    }


    public static void main(String[] args) {

        Sort<Integer> sort = new QuickSort<>();

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
