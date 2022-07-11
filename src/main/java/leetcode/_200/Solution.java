package leetcode._200;/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */


import mydatastructure.linklist.LinkedList;

// @lc code=start
class Solution {

    public int numIslands(char[][] grid) {
//        return usingUnionFind(grid);
//        return usingBFS(grid);
        return usingDFS(grid);
    }

    private int usingBFS(char[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        int nRow = grid.length;
        int nCol = grid[0].length;
        int count = 0;

        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (grid[i][j] == '1') {
                    queue.addLast(new int[]{i, j});
                    count++;
                    while (!queue.isEmpty()) {
                        int[] cord = queue.removeFirst();
                        int row = cord[0];
                        int col = cord[1];
                        grid[row][col] = '0';
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            grid[row - 1][col] = '0';
                            queue.addLast(new int[]{row - 1, col});
                        }
                        if (row + 1 < nRow && grid[row + 1][col] == '1') {
                            grid[row + 1][col] = '0';
                            queue.addLast(new int[]{row + 1, col});
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            grid[row][col - 1] = '0';
                            queue.addLast(new int[]{row, col - 1});
                        }
                        if (col + 1 < nCol && grid[row][col + 1] == '1') {
                            grid[row][col + 1] = '0';
                            queue.addLast(new int[]{row, col + 1});
                        }
                    }
                }
            }
        }

        return count;
    }

    private int usingDFS(char[][] grid) {
//        return dfsUsingStack(grid);
        return dfsUsingRecursion(grid);
    }

    private int dfsUsingStack(char[][] grid) {
        LinkedList<int[]> stack = new LinkedList<>();
        int nRows = grid.length;
        int nCols = grid[0].length;
        int count = 0;
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    stack.addFirst(new int[]{i, j});
                    while (!stack.isEmpty()) {
                        int[] cords = stack.removeFirst();
                        int row = cords[0];
                        int col = cords[1];
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            stack.addFirst(new int[]{row, col});
                            grid[row - 1][col] = '0';
                            stack.addFirst(new int[]{row - 1, col});
                            continue;
                        }
                        if (row + 1 < nRows && grid[row + 1][col] == '1') {
                            stack.addFirst(new int[]{row, col});
                            grid[row + 1][col] = '0';
                            stack.addFirst(new int[]{row + 1, col});
                            continue;
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            stack.addFirst(new int[]{row, col});
                            grid[row][col - 1] = '0';
                            stack.addFirst(new int[]{row, col - 1});
                            continue;
                        }
                        if (col + 1 < nCols && grid[row][col + 1] == '1') {
                            stack.addFirst(new int[]{row, col});
                            grid[row][col + 1] = '0';
                            stack.addFirst(new int[]{row, col + 1});
                        }
                    }
                }
            }
        }
        return count;
    }

    private int dfsUsingRecursion(char[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;
        int count = 0;

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[0].length
                || grid[row][col] != '1')
            return;

        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    private int usingUnionFind(char[][] grid) {
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    if (i - 1 >= 0 && grid[i - 1][j] == '1')
                        uf.union((i - 1) * cols + j, i * cols + j);
                    if (i + 1 < rows && grid[i + 1][j] == '1')
                        uf.union((i + 1) * cols + j, i * cols + j);
                    if (j - 1 >= 0 && grid[i][j - 1] == '1')
                        uf.union(i * cols + j - 1, i * cols + j);
                    if (j + 1 < cols && grid[i][j + 1] == '1')
                        uf.union(i * cols + j + 1, i * cols + j);
                }
            }
        }
        return uf.getCount();
    }

    class UnionFind {
        int[] parents;
        int[] rank;
        int count;

        public UnionFind(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            parents = new int[rows * cols];
            rank = new int[rows * cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        parents[i * cols + j] = i * cols + j;
                        count++;
                    }
                }
            }
        }

        private int find(int a) {
            while (parents[a] != a) {
                a = parents[a];
            }
            return a;
        }

        public void union(int a, int b) {
            int aP = find(a);
            int bP = find(b);
            if (aP != bP) {
                if (rank[aP] > rank[bP]) {
                    parents[bP] = aP;
                } else if (rank[bP] > rank[aP]) {
                    parents[aP] = bP;
                } else {
                    parents[bP] = aP;
                    rank[aP] += 1;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

}
// @lc code=end
