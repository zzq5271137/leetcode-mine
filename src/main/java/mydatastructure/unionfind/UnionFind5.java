package mydatastructure.unionfind;

public class UnionFind5 implements UF {

    private int[] parent;
    private int[] rank;  // rank[i]表示以i为根的集合所表示的树的深度

    public UnionFind5(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int x) {
        if (x < 0 || x >= parent.length)
            throw new IllegalArgumentException("Index is out of bound.");

        while (x != parent[x]) {
            parent[x] = parent[parent[x]];  // 路径压缩
            x = parent[x];
        }
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

        if (rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;
        else if (rank[qRoot] < rank[pRoot])
            parent[qRoot] = pRoot;
        else {  // rank[qRoot] == rank[pRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
