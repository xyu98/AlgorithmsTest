package sggclasstest;

import java.util.Stack;

// 反向打印链表
// 栈的典型应用
public class ReversePrintList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode head = node1;
        reversePrint(head);
    }

    public static void reversePrint(ListNode head) {
        Stack stack = new Stack();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

class ListNode {
    int val;        // 当前节点的内容
    ListNode next;  // 下一个节点的指针
    ListNode() {}   // 无参构造方法
    ListNode(int val) { this.val = val; }  // 构造方法
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }  // 构造方法

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}