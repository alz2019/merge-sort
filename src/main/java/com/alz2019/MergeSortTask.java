package com.alz2019;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortTask extends RecursiveAction {
    private int[] array;
    private int n;

    public MergeSortTask(int[] array) {
        this.array = array;
        this.n = array.length;
    }

    @Override
    protected void compute() {
        if (array.length == 1) {
            return;
        }
        int[] left = Arrays.copyOfRange(array, 0, n / 2);
        int[] right = Arrays.copyOfRange(array, n / 2, n);
        MergeSortTask leftTask = new MergeSortTask(left);
        MergeSortTask rightTask = new MergeSortTask(right);
        leftTask.fork();
        rightTask.compute();
        leftTask.join();
        merge(array, left, right);
    }

    private void merge(int[] array, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[i + j] = left[i++];
            } else {
                array[i + j] = right[j++];
            }
        }
        System.arraycopy(left, i, array, i + j, left.length - i);
        System.arraycopy(right, j, array, i + j, right.length - j);
    }
}
