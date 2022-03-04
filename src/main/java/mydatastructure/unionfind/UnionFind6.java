package mydatastructure.unionfind;

public class UnionFind6 implements UF {

    private int[] parent;
    private int[] rank;  // rank[i]表示以i为根的集合所表示的树的深度

    public UnionFind6(int size) {
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

        if (x != parent[x])
            parent[x] = find(parent[x]);  // 路径压缩，一次性的将路径上每个未指向跟节点的节点，都指向跟节点，使树的高度为2
        return parent[x];
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
