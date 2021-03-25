package src.swexpertacademy.d4.중위순회;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class TreeOrder {
    public Node root;

    public void createNode(int data, int leftData, int rightData) {
        if (root == null) {
            root = new Node(data);
            if (leftData != -1) root.left = new Node(leftData);
            if (rightData != -1) root.right = new Node(rightData);
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    public void searchNode(Node node, int data, int leftData, int rightData) {
        if (node != null) {
            if (node.data == data) {
                if (leftData != -1) node.left = new Node(leftData);
                if (rightData != -1) node.right = new Node(rightData);
            } else {
                searchNode(node.left, data, leftData, rightData);
                searchNode(node.right, data, leftData, rightData);
            }
        }
    }

    //중위 순회 Inorder : Left -> Root -> Right
    public StringBuilder inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            if (node.left != null) inOrder(node.left, sb);
            sb.append(node.data);
            if (node.right != null) inOrder(node.right, sb);
        }
        return sb;
    }

}

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d4/중위순회/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            Map<Integer, String> wordMap = new HashMap<>();
            sb.append("#").append(test_case).append(" ");
            TreeOrder t = new TreeOrder();
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int data = Integer.parseInt(st.nextToken());
                String word = st.nextToken();
                int leftData = -1;
                int rightData = -1;

                if (st.hasMoreTokens()) {
                    leftData = Integer.parseInt(st.nextToken());
                }
                if (st.hasMoreTokens()) {
                    rightData = Integer.parseInt(st.nextToken());
                }
                wordMap.put(data, word);
                t.createNode(data, leftData, rightData);
            }
            StringBuilder answer = new StringBuilder();
            String[] temp = t.inOrder(t.root, new StringBuilder()).toString().split("");
            for (String s : temp)
                answer.append(wordMap.get(Integer.parseInt(s)));
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }


}