package mydatastructure.setandmap;

import mydatastructure.linklist.LinkedList;

public class LinkedListSet<E> implements Set<E> {
    LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void add(E e) {
        if (!contains(e))
            list.addFirst(e);
    }

    @Override
    public void remove(E e) {
        list.removeElements(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }
}
