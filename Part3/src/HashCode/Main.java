package HashCode;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = -10;
        System.out.println(((Integer) a).hashCode()); //10
        System.out.println(((Integer) b).hashCode()); //-10  整型的hash值就是其本身

        double c = 3.14;
        System.out.println(((Double) c).hashCode()); //300063655

        Student student1 = new Student(10,100,"Liu","Pengkun");
        System.out.println(student1.hashCode()); //189568618 没有重写object中的hashCode方法   984919704重写hashCode()方法后的hash值

        Student student2 = new Student(10,100,"Liu","Pengkun");
        System.out.println(student2.hashCode()); //793589513 没有重写object中的hashCode方法    984919704 重写hashCode()方法后的hash值
        //按照Object类中自定义的hashCode()方法，是按照对象的地址进行hash计算的，只要地址不同其hash值就不同
        //当hash值相同时并不代表两个对象的值相同，因为有可能发生了hash冲突，因此还需要重写equals方法进行二次判断

        //底层基于hash的实现
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(student1);

        HashMap<Student, Integer> hashMap = new HashMap<>();
        hashMap.put(student1,1);
    }
}
