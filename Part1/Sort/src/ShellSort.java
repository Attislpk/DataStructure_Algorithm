import java.util.Arrays;

public class ShellSort {

    private ShellSort() {
    }

    //希尔排序算法实际上就是间距不同分组的插入排序
    public static <E extends Comparable<E>> void sort(E[] arr) {
        // h代表同组中各个元素之间的间隔, 间隔从大到小，直到h=1，对于同组间的各个元素均采用插入排序
        int h = arr.length / 2; //分成两组

        while (h >= 1) {
            //不同区间的元素进行插入排序, 组1，组2，组3... 不同组间的元素的距离是1， 同组间元素的距离为h
            for (int start = 0; start < h; start++) {
                //对区间内的元素[start, start+h, start+2h...]进行插入排序, 从第二个元素开始到最后一个元素截止,每个元素和它之前的元素比较
                //对不同区间中的元素进行分别处理，A区间处理完毕后再处理B区间,c,d...
                for (int i = start + h; i < arr.length; i += h) {
                    //插入排序逻辑
                    E temp = arr[i];
                    int j;
                    for (j = i; j - h >= 0 && arr[j-h].compareTo(temp) > 0; j -= h) {
                        arr[j]=arr[j-h];
                    }
                    arr[j]=temp;
                }
            }
            h /= 2; //元素间的间隔继续减小
        }
    }




    //代码格式优化
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        int h = arr.length / 2;
        while (h >= 1) {
            //不同区间的元素进行插入排序, 组1，组2，组3... 不同组间的元素的距离是1， 同组间元素的距离为h
                //从每组的第二个元素开始，按照顺序比较大小, 根据j的循环自动会匹配到各自的区间
                for (int i = h; i < arr.length; i ++) {
                    //插入排序逻辑
                    E temp = arr[i];
                    int j;
                    for (j = i; j - h >= 0 && arr[j-h].compareTo(temp) > 0; j -= h) {
                        arr[j]=arr[j-h];
                    }
                    arr[j]=temp;
                }
            h /= 2; //元素间的间隔继续减小
            }
        }

    //步长序列调整
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        //将步长设置为1,4,13,40...
        int h = 1;
        //计算出最大步长
        while (h < arr.length) h = h * 3 +1; //大于arr.length的最小步长

        while (h >= 1) {
            for (int i = h; i < arr.length; i ++) {  //第一次判断时，h肯定是大于arr.length的，不进入循环，区间根据规则进行缩小
                //插入排序逻辑
                E temp = arr[i];
                int j;
                for (j = i; j - h >= 0 && arr[j-h].compareTo(temp) > 0; j -= h) {
                    arr[j]=arr[j-h];
                }
                arr[j]=temp;
            }
            h /= 3; //利用整除特性，元素间的间隔减小
        }
    }
}
