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
        //System.out.println(mySqrt(target, e));
        System.out.println(mySqrt(target, e));
    }
    private static double mySqrt(double target, double e) {
        double left = 0;
        double right = target;
        while (left <= right) {
            double mid = left + (right - left) / 2;
            if (Math.abs(mid * mid - target ) < e) {
                return mid;  //此处为什么left和right都不-1呢？ 因为是求平方根，不是整数！如果是在整数区间查找，区间就可以-1，否则不能-1
            }else if (mid * mid < target) left = mid;
            else right = mid;
        }
        return right;
    }

    private static double mySqrt2(double target, double e){
        double left = 0;
        double right = target;
        while (left <= right) {
            double mid = left + (right - left) / 2;
            if (Math.abs(mid * mid - target) < e){
                return mid;
            }else if (mid * mid < target) left = mid;
            else right= mid;
        }
        return right;
    }

}