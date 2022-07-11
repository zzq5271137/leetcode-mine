package leetcode._贪心._字典序最小的字符串拼接;

import java.util.*;

public class Solution {

    /*
     * 解法一：列举出所有可能的排序结果，找到最小的一个
     */
    public static String lowestString1(String[] strs) {
        if (strs == null || strs.length == 0)
            return null;

        ArrayList<String> all = new ArrayList<>();
        process(strs, "", all, new HashSet<Integer>());
        String lowest = all.get(0);
        for (int i = 1; i < all.size(); i++) {
            String cur = all.get(i);
            if (cur.compareTo(lowest) < 0)
                lowest = cur;
        }
        return lowest;
    }

    /**
     * 将一个字符串数组中的所有字符串拼接成一个字符串，获得所有的拼接结果
     *
     * @param strs 字符串数组
     * @param path 目前的拼接结果
     * @param all  所有拼接完成的字符串
     * @param used 目前已经使用的字符串在字符串数组的下标
     */
    private static void process(String[] strs, String path, List<String> all, HashSet<Integer> used) {
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

    /*
     * 解法二：贪心算法
     */
    public static String lowestString2(String[] strs) {
        if (strs == null || strs.length == 0)
            return null;

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

}
