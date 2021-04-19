package jihe;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        // 创建Map集合
        Map<Integer,String> m1 = new HashMap<>();
        // 添加元素(key, value)
        m1.put(1000,"zhangsan");
        m1.put(1001,"lisi");
        m1.put(1002,"wangwu");
        m1.put(1000,"zhaoliu"); // key相同则覆盖
        System.out.println("size: " + m1.size());
        // 获取元素
        System.out.println(m1.get(1000));
        // 遍历（两个方法，很重要）
        System.out.println("遍历方法1：先获取key，然后foreach遍历key取元素");
        for (Integer x: m1.keySet()) {
            System.out.println(m1.get(x));
        }
        System.out.println("遍历方法2：将Map集合转换成Set集合");
        // 调用entrySet()方法，生成的Set集合中的元素是Map.Entry< , >类型
        for (Map.Entry<Integer, String> x: m1.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
}
