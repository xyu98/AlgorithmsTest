package jihe;

import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        // Properties类，是一个Map集合，继承自HashTable。只支持String格式
        // 注意HashTable不允许有null键和null值；HashMap允许存在1个null键，可以存在多个null值
        Properties pro = new Properties();
        pro.setProperty("username", "zhansgan");
        pro.setProperty("password", "1123456");
        // 取元素
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
        System.out.println(username + " " + password);
    }
}
