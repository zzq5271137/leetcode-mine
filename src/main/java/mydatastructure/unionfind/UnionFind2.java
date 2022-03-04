package mydatastructure.unionfind;

public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int x) {
        if (x < 0 || x >= parent.length)
            throw new IllegalArgumentException("Index is out of bound.");

        while (x != parent[x])
            x = parent[x];
        return x;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;

        parent[pRoot] = qRoot;
    }
}
