//package 携程;
//
//import java.util.Scanner;
//
//
///**
// * 建房问题
// * 时间限制： 3000MS
// * 内存限制： 589824KB
// * 题目描述：
// * 假设在一条无限长的道路上盖房子，第一个月在某个点盖一个红房子，之后每个月，都会在上一次盖的新房子的左边盖一个绿房子，
// *
// * 右边盖一个红房子。（假设两个房子之间的空间无限大，可以一直在中间盖房子）
// *
// * 用字符'R'表示红房子，用字符'G'表示绿房子。
// *
// * 输入一个n(1≤n≤12)，表示过了n个月，打印出当前道路上房子从左到右的排列。
// *
// * 要求：
// *
// * 1.    当输入非数字,输出：N
// *
// * 2.    当输入数字超出限制时，输出O
// *
// * 样例：
// *
// * 输入1
// *
// * 输出 R
// *
// * 输入2
// *
// * 输出 GRR
// *
// * 输入3
// *
// * 输出 GGRRGRR
// *
// * 输入5
// *
// * 输出 GGRGGRRGGGRRGRRRGGRGGRRRGGRRGRR
// */
//
//class Main {
//
//
//    /*请完成下面这个函数，实现题目要求的功能
//    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
//    ******************************开始写代码******************************/
//    static String buildingHouse(String n) {
//        int num = Integer.valueOf(n);
//        if (num < 0 || num > 12) return new String("O");
//        StringBuilder stringBuilder = new StringBuilder().append("R");
//        String G = "GGR";
//        String R = "GRR";
//        String replace2 = null;
//        for (int i = 0; i < num; i++) {
//            String replace1 = stringBuilder.;
//            replace2 = replace1.replaceAll("R", R);
//            replace2.replaceAll("g",G);
//        }
//        return replace2;
//    }
//
//    /******************************结束写代码******************************/
//
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String res;
//
//        String _n;
//        try {
//            _n = in.nextLine();
//        } catch (Exception e) {
//            _n = null;
//        }
//
//        res = buildingHouse(_n);
//        System.out.println(res);
//    }
//}
