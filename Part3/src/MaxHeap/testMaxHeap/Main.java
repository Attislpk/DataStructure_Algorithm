import java.util.Random;

class Main1 {

    public static double Heapify(Integer[] arr, boolean isHeapify) {
        long startTime = System.nanoTime();
        double totalTime;
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(arr); //O(n)
        } else {
            maxHeap = new MaxHeap<>(); //空二叉堆
            for (int num : arr) {
                maxHeap.add(num); //O(n*log(n));
            }
        }
        long endTime = System.nanoTime();
        totalTime = (endTime - startTime) / 1000000000.0;
        return totalTime;
    }


    public static void maxHeapTest() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        int n = 1000000;

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println("11111");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("success!");
    }

    public static void main(String[] args) {
        int n = 10000000;
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double heapify = Heapify(arr, true);
        double nheapify = Heapify(arr, false);
        System.out.println("heapify : " + heapify + "s");
        System.out.println("nheapify : " + nheapify + "s");
        //heapify : 0.1141807s
        //nheapify : 0.9603299s
    }
}
