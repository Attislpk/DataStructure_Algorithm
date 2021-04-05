import java.security.cert.CertPathBuilderResult;

public class Student implements Comparable<Student> {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    @Override
    public String toString(){
        return String.format("Student: name: %s, age: %d", name, age);
    }

    @Override
    public int compareTo(Student another) {
        return this.age - another.age;
    }
}
