package mydatastructure.stack;

/*
 * 自定义栈接口
 */

public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();

}
