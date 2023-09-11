package src.leetcode.topinterview150.minimum_absolute_difference_in_bst;

class Solution {

//    PriorityQueue<Integer> queue = new PriorityQueue<>();
//
//    public int getMinimumDifference(TreeNode root) {
//        insert(root);
//
//        int min = Integer.MAX_VALUE;
//        while (queue.size() > 1) {
//            int prev = queue.poll();
//            min = Math.min(min, queue.peek() - prev);
//        }
//
//        return min;
//    }
//
//    public void insert(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//
//        queue.add(node.val);
//
//        insert(node.left);
//        insert(node.right);
//    }

    TreeNode prevNode = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return min;
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        if (prevNode != null) {
            min = Math.min(min, Math.abs(node.val - prevNode.val));
        }
        prevNode = node;

        inOrderTraversal(node.right);
    }


    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}