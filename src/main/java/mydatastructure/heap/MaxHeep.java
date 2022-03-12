package mydatastructure.heap;

/*
 * 使用自定义动态数组实现大顶堆
 */

import mydatastructure.array.Array;

import java.util.Random;

public class MaxHeep<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeep(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeep() {
        data = new Array<>();
    }

    /**
     * heapify
     *
     * @param arr
     */
    public MaxHeep(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(data.getSize() - 1); i >= 0; i--)
            siftDown(i);
    }

    public int size() {
        return data.getSize();
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
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.isEmpty())
            throw new IllegalArgumentException("Heap is empty.");

        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j = j + 1;
            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;

            data.swap(k, j);
            k = j;
        }
    }

    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeep<Integer> maxHeep = new MaxHeep<>();
        Random random = new Random();
        for (int i = 0; i < n; i++)
            maxHeep.add(random.nextInt());

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = maxHeep.extractMax();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");
        }

        System.out.println("Test MaxHeap complete.");
    }

}
