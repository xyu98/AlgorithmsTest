package jihe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayListTest {
    public static void main(String[] args) {
        // ArrayList是数组的结构，LinkedList是双向链表，都是有序可重复的
        /*
            LinkedList的方法和ArrayList基本是一样的
            List用于随机访问的方法：add，remove，get，set，但是一般ArrayList用比较合适
            LinkedList一般不使用以上方法和for循环（效率极低），因为它们本质都是下标遍历
            LinkedList的索引（访问）效率比较低，一般要使用ListIterator（可以双向遍历）
            LinkedList改变头尾的元素可以直接用addFirst,addLast,getFirst,getLast,removeFirst,removeLast
            LinkedList唯一的优势是插入或者删除的开销比较小
        */

        // 存取元素
        ArrayList<String> a1 = new ArrayList<>(8); // 可以指定初始容量
        LinkedList<String> l1 = new LinkedList<>();  // 这里不能加参数指定容量
        a1.add("zhangsan"); // 当添加第一个元素的时候，自动初始化容量10
        a1.add("lisi");
        a1.add("wangwu");
        a1.add("zhaoliu");
        a1.add("lisi");
        a1.add(3,"zhouqi"); //将zhouqi添加到下标3的位置，原来的zhaoliu顺延下标变成4
        System.out.println(a1.get(4));
        a1.set(4,"zhaoshiyi"); // set修改指定位置元素

        // 遍历方法1：foreach
        System.out.println("遍历方法1");
        for (String x: a1) {
            System.out.println(x); // toString已经重写了
        }
        // 遍历方法2：普通for循环（下标遍历）
        System.out.println("遍历方法2");
        int i;
        for (i = 0; i < a1.size(); i++) {
            System.out.println(a1.get(i));
        }
        // 遍历方法3：使用迭代器（通用，所有Collection都能用）
        // 3.1 while循环
        Iterator<String> it1 = a1.iterator();
        /*
            a1.ListIterator也可以
            ListIterator是一个功能更加强大的迭代器, 它继承于Iterator接口,只能用于各种List类型的访问
            ListIterator可以用来反向遍历链表
         */
        System.out.println("遍历方法3.1");
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
        // 3.2 for循环（使用较少，不如直接foreach）
        System.out.println("遍历方法3.2");
        for (Iterator<String> it2 = a1.iterator(); it2.hasNext(); ) {
            System.out.println(it2.next());
        }

        // 删除
        a1.remove("lisi");  // 只删除了第一个“lisi”
        a1.remove(3);
        System.out.println("删除");
        for (String x: a1) {
            System.out.println(x); // toString已经重写了
        }
    }
}
