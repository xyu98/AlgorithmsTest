package jihe;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest01 {
    public static void main(String[] args) {
        /*
            TreeSet没有下标，不可重复，但是对集合遍历时会自动排序，是一个有序集合
            如果是自定义类型，要实现排序功能有两种方法：
            1. 实现lang包下comparable接口 implements comparable<T>并将compareTo方法重写。
                适合于比较规则只有一个或者较少发生改变的情况。
            2. 单独写一个比较器实现util的Comparator接口，并将compare方法重写。在new的时候传一个比较器进去。
                适合多个比较规则或比较规则经常发生变化的情况。
            若要降序排列，改变比较规则即可。
         */

        // 方法1：
        TreeSet<Student> students = new TreeSet<>();
        // 方法2：
        // TreeSet<Student> students = new TreeSet<>(new StudentComparator());
        students.add(new Student(202000, 20, "zhangsan"));
        students.add(new Student(202009, 27, "lisi"));
        students.add(new Student(202006, 20, "wangwu"));
        students.add(new Student(202006, 20, "zhaoliu"));

        for (Student x: students) {
            System.out.println(x);
        }
    }
}

// 排序方法1：直接在这里继承Comparable接口
class Student implements Comparable<Student> {
    int no;
    int age;
    String name;

    public Student() {
    }

    public Student(int no, int age, String name) {
        this.no = no;
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return ("Student name: " + name + ", no: " + no + ", age: " + age);
    }

    @Override
    public int compareTo(Student o) {
        if (this.age != o.age) {
            return this.age - o.age;
        }
        else {
            return this.no - o.no;
        }
    }
}


/*
// 排序实现方法2：
class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.age != s2.age) {
            return s1.age - s2.age;
        }
        else {
            return s1.no - s2.no;
        } //如果两个都相等，则覆盖掉
    }
}

 */

