package leetcode._88;/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newArr = new int[nums1.length];
        int i = 0, j = 0;
        while (i != m || j != n) {
            if (i == m) {
                newArr[i + j] = nums2[j];
                j++;
                continue;
            }

            if (j == n) {
                newArr[i + j] = nums1[i];
                i++;
                continue;
            }

            if (nums1[i] < nums2[j]) {
                newArr[i + j] = nums1[i];
                i++;
            } else {
                newArr[i + j] = nums2[j];
                j++;
            }
        }

        System.arraycopy(newArr, 0, nums1, 0, nums1.length);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        new Solution().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
// @lc code=end

