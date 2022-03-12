package mydatastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class JavaPriorityQueueTest {

    /*
     * PriorityQueue默认是小顶堆
     */
    private static void minHeapTest() {
        int n = 1000000;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0; i < n; i++)
            minHeap.add(random.nextInt());

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = minHeap.remove();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) // 比较
                throw new IllegalArgumentException("Error");
        }

        System.out.println("Test MinHeap complete.");
    }

    /*
     * 创建对象的时候传入自定义比较器，实现大顶堆
     */
    private static void maxHeapTest() {
        int n = 1000000;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {  // 创建对象的时候传入自定义比较器，实现大顶堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        Random random = new Random();
        for (int i = 0; i < n; i++)
            maxHeap.add(random.nextInt());

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = maxHeap.remove();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i])  // 比较
                throw new IllegalArgumentException("Error");
        }

        System.out.println("Test MaxHeap complete.");
    }


    public static void main(String[] args) {
        minHeapTest();
        maxHeapTest();
    }
}
