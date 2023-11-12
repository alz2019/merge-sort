package com.alz2019;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] array = {34, 4, 5, 3, 89, 7, 9, 3478, 45};
        ForkJoinPool forkJoinPool = new ForkJoinPool(6);
        forkJoinPool.invoke(new MergeSortTask(array));
        assertArrayEquals(array, new int[]{3, 4, 5, 7, 9, 34, 45, 89, 3478});
    }
}
