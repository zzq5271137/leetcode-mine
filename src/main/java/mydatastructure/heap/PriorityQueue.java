package mydatastructure.heap;

/*
 * 使用自定义大顶堆实现优先队列
 */

import mydatastructure.queue.Queue;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeep<E> heap;

    public PriorityQueue() {
        heap = new MaxHeep<>();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int getSize() {
        return heap.size();
    }

    @Override
    public E getFront() {
        return heap.findMax();
    }

    @Override
    public void enqueue(E e) {
        heap.add(e);
    }

    @Override
    public E dequeue() {
        return heap.extractMax();
    }

}
