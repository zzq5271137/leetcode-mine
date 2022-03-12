package mydatastructure.stack;

/*
 * 使用自定义动态数组实现栈（LIFO）
 */

import mydatastructure.array.Array;

public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capability) {
        array = new Array<>(capability);
    }

    public ArrayStack() {
        array = new Array<>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    public int getCapability() {
        return array.getCapacity();
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
