package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeTest01 {
    public static void main(String[] args) {
        InorderTree01 s = new InorderTree01();
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        tn1.left = null;
        tn1.right = tn2;
        tn2.left = tn3;
        tn2.right = null;
        System.out.println(s.inorderTraversal(tn1));
    }
}

// LC 144 时间100% 空间96.03%
// 时间O(N) 空间O(N)
class PreorderTree01 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.left != null) preOrder(root.left, list);
            if (root.right != null) preOrder(root.right, list);
        }
    }
}

// LC 94
class InorderTree01 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) inOrder(root.left, list);
            list.add(root.val);
            if (root.right != null) inOrder(root.right, list);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
