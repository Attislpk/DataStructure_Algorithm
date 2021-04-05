

class Solution {
    public static int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k ; i++){
            priorityQueue.enqueue(arr[i]);
        }

        for (int i = k; i < arr.length; i++){
            if (!priorityQueue.isEmpty() && priorityQueue.getFront() > arr[i]){
                priorityQueue.dequeue();
                priorityQueue.enqueue(arr[i]);
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; i++){
            ret[i] = priorityQueue.dequeue();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,6,7,1,2};
        int[] leastNumbers = getLeastNumbers(arr, 5);
        for (int num: leastNumbers){
            System.out.print(num);
        }
    }
}