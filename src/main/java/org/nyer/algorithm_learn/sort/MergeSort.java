package org.nyer.algorithm_learn.sort;

import java.util.*;

public class MergeSort<T> implements Sort<T> {

    @Override
    public List<T> sort(List<T> list, Comparator<T> cmp) {

        splitAndMerge(list, 0, list.size(), cmp);

        return list;
    }

    void splitAndMerge(List<T> list, int start, int end, Comparator<T> cmp) {

        if (end - start <= 2) {
            T left = list.get(start);
            T right = null;
            if (start + 1 < end) {

                right = list.get(start + 1);
            }

            if (right != null) {

                if (cmp.compare(left, right) > 0) {

                    swap(list, start, start + 1);
                }
            }

            return;
        }

        int middle = (start + end) / 2;
        splitAndMerge(list, start, middle, cmp);
        splitAndMerge(list, middle, end, cmp);

        merge(list, start, middle, end, cmp);
    }

    void merge(List<T> list, int left, int middle, int right, Comparator<T> cmp) {

        List<T> leftCopy = new ArrayList<>(list.subList(left, middle));
        List<T> rightCopy = new ArrayList<>(list.subList(middle, right));

        int leftIdx = 0;
        int leftSize = leftCopy.size();
        int rightIdx = 0;
        int rightSize = rightCopy.size();
        int globalIdx = left;
        while (leftIdx < leftSize && rightIdx < rightSize) {

            T leftItem = leftCopy.get(leftIdx);
            T rightItem = rightCopy.get(rightIdx);

            if (cmp.compare(leftItem, rightItem) > 0) {

                list.set(globalIdx ++, rightItem);
                rightIdx ++;
            } else {

                list.set(globalIdx ++, leftItem);
                leftIdx ++;
            }
        }

        while (leftIdx < leftSize) {

            list.set(globalIdx ++, leftCopy.get(leftIdx ++));
        }

        while (rightIdx < rightSize) {

            list.set(globalIdx ++, rightCopy.get(rightIdx ++));
        }
    }

    private void swap(List<T> list, int i, int j) {

        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }


    public static void main(String[] args) {

        Sort<Integer> sort = new MergeSort<>();

        Random random = new Random();

        int size = 10000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size ; i++) {

            list.add(random.nextInt(size * 10));
        }

        sort.sort(list, Integer::compareTo);
        System.out.println(list);
        System.out.println(list.size());
    }
}
