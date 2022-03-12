package mydatastructure.heap;

/*
 * 测试自定义大顶堆的heapify
 */

import java.util.Random;

public class TestHeapify {
    private static double testMaxHeap(Integer[] testData, boolean useHeapify) {
        long start = System.nanoTime();

        MaxHeep<Integer> maxHeep;
        if (useHeapify)
            maxHeep = new MaxHeep<>(testData);
        else {
            maxHeep = new MaxHeep<>();
            for (int num : testData)
                maxHeep.add(num);
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = maxHeep.extractMax();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");
        }

        System.out.println("Test MaxHeap complete.");

        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Random r = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++)
            testData[i] = r.nextInt(Integer.MAX_VALUE);

        double t1 = testMaxHeap(testData, false);
        System.out.println("Without heapify: " + t1);

        double t2 = testMaxHeap(testData, true);
        System.out.println("With heapify: " + t2);
    }
}
