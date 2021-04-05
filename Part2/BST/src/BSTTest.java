import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

class BSTTest {
    public static void main(String[] args) {
//        test1();
        test2();
        test3();
    }

    public static void test1() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        bst.preOrder();
        System.out.println("-----------");
        bst.preOrderNR();
    }

    @Test
    public static void test2() {
        BST<Integer> bst = new BST<>();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(new Random().nextInt(10000));
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!bst.isEmpty()) {
            arrayList.add(bst.removeMin());
        }
        System.out.println(arrayList);

        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) < arrayList.get(i - 1)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("MinTest passed");
    }

    @Test
    public static void test3() {
        BST<Integer> bst = new BST<>();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(new Random().nextInt(10000));
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!bst.isEmpty()) {
            arrayList.add(bst.removeMax());
        }
        System.out.println(arrayList);

        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) > arrayList.get(i - 1)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("MaxTest passed");
    }
}


