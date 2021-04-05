package HashCode;

public class Student {
    private int age;
    private int score;

    private String firstName;
    private String lastName;

    public Student(int age, int score, String firstName, String lastName) {
        this.age = age;
        this.score = score;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        int B = 31;
        hash = hash * B + age;
        hash = hash * B + score; //对于age和score整型而言，其hash值就是数值
        hash = hash * B + firstName.hashCode(); //对于字符串而言，hashCode()方法会将字符串转换为整型，并输出其hash值
        hash = hash * B + lastName.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true; //地址相同没得说，肯定是相同
        }
        if (obj == null){
            return false; //空对象
        }
        if (obj.getClass() != this.getClass()){
            return false; //类型不同
        }
        //类型相同，向进行类型转换
        Student another = ((Student)obj);
        //进行属性比较, 对于整型数据放置在常量池中的，可以直接进行地址比较；字符串重写了Object中的equals()
        if (another.age == this.age && another.score == this.score && another.firstName.equals(this.firstName) &&
        another.lastName.equals(lastName)){
            return true;
        }
        return false;
    }
}
