package 剑指;

public class 剑指Offer04_二维数组中的查找 {
}

class Solution04 {
    //定义一个整型数组:3行4列
    int a[][] = new int[3][4];
    //获取行数---3行
    int lenY = a.length;
    //获取列数---4列
    int lenX = a[0].length;

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1; //最后一行
        int j = 0; //第0列
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}