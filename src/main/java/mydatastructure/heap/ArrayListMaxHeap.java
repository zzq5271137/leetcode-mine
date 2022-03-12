package mydatastructure.heap;

/*
 * 使用ArrayList实现大顶堆
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayListMaxHeap<E extends Comparable<E>> {
    private ArrayList<E> data;

    public ArrayListMaxHeap() {
        data = new ArrayList<>();
    }

    public ArrayListMaxHeap(E[] arr) {
        data = new ArrayList<>();
        data.addAll(Arrays.asList(arr));
        for (int i = parent(data.size() - 1); i >= 0; i--)
            siftDown(i);
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    private void swap(int i, int j) {
        E iData = data.get(i);
        E jData = data.get(j);
        data.set(i, jData);
        data.set(j, iData);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    public E element() {
        if (data.isEmpty())
            throw new IllegalArgumentException("Heap is empty.");
        return data.get(0);
    }

    public E remove() {
        E ret = element();
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.size()) {
            int i = leftChild(k);

            if ((i + 1) < data.size() && data.get(i + 1).compareTo(data.get(i)) > 0)
                i = i + 1;

            if (data.get(k).compareTo(data.get(i)) >= 0)
                break;

            swap(i, k);
            k = i;
        }
    }

    public E replace(E e) {
        E ret = element();
        data.set(0, e);
        siftDown(0);
        return ret;
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

    private static double testMaxHeap(Integer[] testData, boolean useHeapify) {
        long start = System.nanoTime();

        ArrayListMaxHeap<Integer> maxHeep;
        if (useHeapify)
            maxHeep = new ArrayListMaxHeap<>(testData);
        else {
            maxHeep = new ArrayListMaxHeap<>();
            for (int num : testData)
                maxHeep.add(num);
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = maxHeep.remove();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");
        }

        System.out.println("Test MaxHeap complete.");

        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

}
