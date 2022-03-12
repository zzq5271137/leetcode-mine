package mydatastructure.setandmap;

/*
 * 自定义集合接口
 */

public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
