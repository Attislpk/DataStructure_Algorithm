package 二分;

import java.util.Scanner;

public class _求解一个数的平方根_带精度 {
}

class solutionDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数: ");
        double target = sc.nextDouble();
        System.out.println("请输入要求的精度范围：");
        double e = sc.nextDouble();
        System.out.println(mySqrt(target, e));
    }
    private static double mySqrt(double target, double e) {
        double left = 0;
        double right = target;
        while (left <= right) {
            double mid = left + (right - left) / 2;
            if (Math.abs(mid * mid - target ) < e) {
                return mid;
            }else if (mid * mid < target) left = mid;
            else right = mid;
        }
        return right;
    }
}