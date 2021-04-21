package 分治与回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _51_N皇后 {
}

class Solution51 {
    public static int totalNQueens(int n) {
        if (n < 1 || n > 32) return 0;
        //target代表最终要达到的二进制数的效果，00000.....1111,1代表对应位置摆放了皇后, 如果是n皇后，就有n个1
        // -1是什么含义？ 人为规定32个1就是-1
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process(limit, 0, 0, 0);
    }

    private static int process(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        //如果能够到最后一层，结果+1
        if (colLim == limit) return 1;

        //每次的可选位置, 为什么需要使用target&一次？ target截掉左侧超出范围的1，避免斜线limit造成的干扰
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        //可选的其中一个位置
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne; //移除已经选择的位置
            //递归调用，直到最后一层
            res += process(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueens2(4));
    }


    private static final List<List<String>> results = new ArrayList<>();
    public static List<List<String>> totalNQueens2(int n) {
        if (n < 1 || n > 32) return results;
        //target代表最终要达到的二进制数的效果，00000.....1111,1代表对应位置摆放了皇后, 如果是n皇后，就有n个1
        // -1是什么含义？ 人为规定32个1就是-1
        int limit = n == 32 ? -1 : (1 << n) - 1;
        //用于记录每一行皇后所在的列数, row用于表示每一行，queue[row]表示第row行的皇后摆放的列位置
        int[] queue = new int[n];
        process2(limit, queue, 0, 0, 0, 0);
        return results;
    }

    private static void process2(int limit, int[] queue, int row, int colLim, int leftDiaLim, int rightDiaLim) {
        //如果能够到最后一层, 结果+1
        if (row == queue.length) {
            //添加一种可行的摆放位置
            results.add(generateQueue(queue));
        };
        //每次的可选位置, 为什么需要使用target&一次？ target截掉左侧超出范围的1，避免斜线limit造成的干扰
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        //可选的其中一个位置
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            //选择的最后一位1，也就是要摆放的皇后对应的列
            mostRightOne = pos & (~pos + 1);
            //将mostRightOne转换为对应的第几列，1-->第0列，2-->第1列
            int colNumber = Integer.bitCount(mostRightOne - 1);
            queue[row] = colNumber;
            pos = pos - mostRightOne; //移除已经选择的位置
            //递归调用，直到最后一层, 传入queue，row到下一行+1
            process2(limit, queue,row + 1 ,colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
    }

    private static List<String> generateQueue(int[] queue) {
        List<String> result = new ArrayList<>();
        //nxn的表格
        for (int i : queue) {
            char[] chars = new char[queue.length];
            Arrays.fill(chars, '.');
            chars[i] = 'Q';
            //将每一行的结果都添加到res中
            result.add(String.valueOf(chars));
        }
        return result;
    }
}