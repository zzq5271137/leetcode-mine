package mydatastructure.setandmap;

/*
 * 自定义映射接口
 */

public interface Map<K, V> {

    int getSize();

    boolean isEmpty();

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

}
