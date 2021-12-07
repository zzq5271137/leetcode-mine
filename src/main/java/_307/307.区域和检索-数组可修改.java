package _307;/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {

    int[] data;
    int n;
    int[] tree;

    public NumArray(int[] nums) {
        data = nums;
        n = data.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++)
            add(i + 1, data[i]);
    }

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i))
            tree[i] += u;
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i))
            ans += tree[i];
        return ans;
    }

    public void update(int i, int val) {
        add(i + 1, val - data[i]);
        data[i] = val;
    }

    public int sumRange(int l, int r) {
        return query(r + 1) - query(l);
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(data);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

