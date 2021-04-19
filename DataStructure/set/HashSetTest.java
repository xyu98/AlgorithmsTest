package jihe;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class HashSetTest {
    public static void main(String[] args) {
        // Set类 无序不可重复 不可通过下标操作
        /*
            HashSet（HashMap的key）很重要的一点，如果存放的是自己定义的对象
            要同时重写hashCode和equals方法
         */

        /*
            通过集合的构造方法就可以完成集合的转换，比如
            HashSet(Collection<> E)，构造一个指定collection元素的set
            比如Map转换为Set可以调用方法Map.keySet()
         */


        HashSet<String> h1 = new HashSet<>();
        // 注意如果要存不同类型的元素比如String和Integer，则<Object>

        // 添加元素
        h1.add("renzhichu");
        h1.add("xingbenshan");
        h1.add("xingxiangjin");
        h1.add("xixiangyuan");

        // 没有取的方法

        // 遍历
        System.out.println("遍历方法1：迭代器");
        Iterator it1 = h1.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
        System.out.println("遍历方法2：foreach");
        for (String x: h1) {
            System.out.println(x);
        }

        // 测试其无序不可重复性
        h1.add("renzhichu");
        h1.add("renzhichu");
        System.out.println("添加相同元素");
        System.out.println(h1.size());
        for (String x: h1) {
            System.out.println(x);
        }

        // 测试存储Workers数据
        HashSet<Worker> workers = new HashSet<>();
        Worker w1 = new Worker("zhangsan",10000);
        Worker w2 = new Worker("lisi",10001);
        Worker w3 = new Worker("zhangsan",10002);
        Worker w4 = new Worker("zhangsan",10000);

        workers.add(w1);
        workers.add(w2);
        workers.add(w3);
        workers.add(w4);
        System.out.println("size: " + workers.size()); // 只有w1,w2,w3被添加

        System.out.println("遍历workers：");
        for (Worker x: workers) {
            System.out.println(x);
        }
    }
}

class Worker {
    String name;
    int no;

    public Worker(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public Worker() {
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker Worker = (Worker) o;
        return no == Worker.no && Objects.equals(name, Worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, no);
    }
}