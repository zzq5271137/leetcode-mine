package leetcode._暴力递归._字符串数组的全部排列组合;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    /**
     * 将一个字符串数组中的所有字符串拼接成一个字符串，获得所有的拼接结果
     *
     * @param strs 字符串数组
     * @param path 目前的拼接结果
     * @param all  所有拼接完成的字符串
     * @param used 目前已经使用的字符串在字符串数组的下标
     */
    static void process(String[] strs, String path, List<String> all, HashSet<Integer> used) {
        if (used.size() == strs.length) {
            all.add(path);
        } else {
            for (int i = 0; i < strs.length; i++) {
                if (!used.contains(i)) {
                    used.add(i);
                    process(strs, path + strs[i], all, used);
                    used.remove(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        process(new String[]{"a", "b", "c"}, "", all, new HashSet<>());
        System.out.println(all);
    }
}
