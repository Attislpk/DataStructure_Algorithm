package 二分;

import java.text.NumberFormat;
import java.util.Scanner;

public class _求解一个数的立方根_带精度 {
}


class solutionDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input a number:");
        double target = sc.nextDouble();
        System.out.println("please define a scope: ");
        double e = sc.nextDouble();
        //String result = String.format("%.4f", num);
        //%.xf中%.表示小数点后任意位数, x表示x位小数,格式后的结果为f表示浮点型。
        //System.out.println(result);
        double res = myCube(target, e);
        String result = String.format("%.6f", res);
        System.out.println(result);
    }

    private static double myCube(double target, double e) {
        double left = 0;
        double right = target;
        while (left <= right) {
            double mid = left + (right - left) / 2;
            if (Math.abs(Math.pow(mid,3) - target) < e) {
                return mid;
            }else if (Math.pow(mid,3) > target) right = mid;
            else left = mid;
        }
        return right;
    }
}