package LinkedListTest;

import java.util.*;

public class LinkedListTest01 {
    public static void main(String[] args) {
        var a = new LinkedList<String>(); //var是动态类型，编译器根据变量所赋的值来推断类型
        a.add("Amy");
        a.add("Dell");
        a.add("Evil");
        a.add("Fby");

        var b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");

        //ListIterator是Iterator的子接口
        //既可以用前者的listIterator方法(可以反向遍历),也可以用后者的iterator方法(只能正向遍历)
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        //将a，b合并
        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        aIter = a.listIterator();  //重新获取a的迭代器
        //再将b移除
        while (aIter.hasNext()) {
            if (b.contains(aIter.next())) {
                aIter.remove();
            }
        }

        System.out.println(a);
    }
}
