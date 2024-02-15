package leetcode._79;/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int nRows = board.length;
        int nCols = board[0].length;
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (found(board, word, 0, i, j, new HashSet<>()))
                    return true;
            }
        }
        return false;
    }

    private boolean found(char[][] board, String word, int wordI, int rowI, int colI, Set<Integer> visted) {
        if (board[rowI][colI] != word.charAt(wordI))
            return false;

        if (wordI == word.length() - 1)
            return true;

        int nRows = board.length;
        int nCols = board[0].length;
        int visitMark = rowI * nCols + colI;
        visted.add(visitMark);
        int[][] newPos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean found = false;
        for (int[] np : newPos) {
            int newRowI = rowI + np[0];
            int newColI = colI + np[1];
            int toVisitMark = newRowI * nCols + newColI;
            if (!visted.contains(toVisitMark)) {
                if (newRowI >= 0 && newRowI < nRows && newColI >= 0 && newColI < nCols) {
                    found = found(board, word, wordI + 1, newRowI, newColI, visted);
                    if (found)
                        break;
                }
            }
        }
        visted.remove(visitMark);  // 清除现场
        return found;
    }

}
// @lc code=end
