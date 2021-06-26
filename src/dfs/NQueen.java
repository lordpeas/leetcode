package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/6/24 19:19
 */
public class NQueen {

    private List<List<String>> res = new ArrayList<>();


    int count = 0;


    public List<List<String>> solveNQueens(int n) {
        String[] board = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n - 1; i++) {
            sb.append(".");
        }
        Arrays.fill(board, sb.toString());
        backTrace(board, 0);
        return res;
    }

    public void backTrace(String[] board, int row) {

        printIndent(count++);
        System.out.println("row:"+row);

        if (row == board.length) {
            res.add(Arrays.asList(board));
            printIndent(--count);
            System.out.println("row:"+row);
            return;
        }

        int n = board.length;
        for (int col = 0; col <= n - 1; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }

            StringBuilder sb = new StringBuilder(board[row]);
            sb.replace(col, col+1, "Q");
            System.out.println("替换："+sb.toString());
            board[row] = sb.toString();
            backTrace(board, row + 1);
            sb.replace(col, col+1, ".");
            System.out.println("撤销："+sb.toString());
            board[row] = sb.toString();
        }

        res.add(new ArrayList<>(Arrays.asList(board)));
        printIndent(--count);
        System.out.println("row:"+row);
    }

    private boolean isValid(String[] board, int row, int col) {
        //判断列
        for (int i = 0; i <= row - 1; i++) {
            String s = board[i];
            if (s.charAt(col) == ('Q')) {
                return false;
            }
        }

        //判断左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            String s = board[i];
            if (s.charAt(j) == ('Q')) {
                return false;
            }
        }


        //判断右上
        for (int i = row - 1, j = col + 1; i >= 0 && j <= board.length - 1; i--, j++) {
            String s = board[i];
            if (s.charAt(j) == ('Q')) {
                return false;
            }
        }
        return true;
    }


    // 输入 n，打印 n 个 tab 缩进
    void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }


    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        List<List<String>> list = nQueen.solveNQueens(3);
        System.out.println(list);
    }
}
