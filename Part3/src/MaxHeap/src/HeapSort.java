import java.util.Random;

public class HeapSort {

    //私有化构造方法，外界无法创建实例对象，只能调用其静态方法进行操作
    private HeapSort(){};

    //静态方法，无序通过对象进行访问，直接通过类名进行访问，避免外界创建对象
    public static<E extends Comparable<E>> void sort(E[] data){
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e:data){
            maxHeap.add(e);
        }
        for (int i = data.length - 1; i >= 0; i--){
            data[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Random random = new Random();
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++){
            data[i]= random.nextInt(n);
        }
        long startTime = System.nanoTime();
        sort(data);
        long endTime = System.nanoTime();
        System.out.println("HeapSort: "+(endTime-startTime)/1000000000.0 + "s");
    }
}
