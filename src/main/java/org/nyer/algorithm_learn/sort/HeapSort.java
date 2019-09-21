package org.nyer.algorithm_learn.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class HeapSort<T> implements Sort<T> {

    @Override
    public List<T> sort(List<T> list, Comparator<T> cmp) {

        BinaryHeap<T> heap = new BinaryHeap<>(list.size(), cmp);
        list.forEach(e -> heap.add(e));

        List<T> result = new ArrayList<>(list.size());
        T head;
        while ((head = heap.remove()) != null) {

            result.add(head);
        }

        return result;
    }

    public static void main(String[] args) {

        Sort<Integer> sort = new HeapSort<>();

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
