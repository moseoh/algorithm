package src.개념.tree;

import java.util.Scanner;

class Node {
    int data; // 노드 값
    Node left; // 왼쪽 자식 노드 참조 값
    Node right; // 오른쪽 자식 노드 참조 값

    Node(int data) {
        this.data = data;
    }
}

class TreeOrder {
    public Node root;

    public void createNode(int data, int leftData, int rightData) {
        // 초기 상태 - 루트 노드 생성
        if (root == null) {
            root = new Node(data);

            // 좌우 값이 있는 경우, 즉 -1 이 아닌 경우 노드 생성
            if (leftData != -1) {
                // 왼쪽 자식 노드 값을 가지는 Node 생성
                root.left = new Node(leftData);
            }
            if (rightData != -1) {
                // 오른쪽 자식 노드 값을 가지는 Node 생성
                root.right = new Node(rightData);
            }
        } else {
            // 초기 상태가 아니라면, 루트 노드 생성 이후 만들어진 노드 중 어떤건지를 찾아야 함
            searchNode(root, data, leftData, rightData);
        }
    }

    // 매개변수로 들어온 root 노드를 시작으로 data 와 같은 값을 가진 node 를 찾는다.
    // 찾을 때까지 root 노드에서부터 왼쪽, 오른쪽으로 내려감
    public void searchNode(Node node, int data, int leftData, int rightData) {
        // 도착한 노드가 null 이면 재귀 종료 - 찾을(삽입할) 노드 x
        if (node != null) {
            // 들어갈 위치를 찾았다면
            if (node.data == data){
                // -1 이 아니고 값이 있는 경우, 좌우 노드 생성
                if(leftData != -1) {
                    node.left = new Node(leftData);
                }
                if(rightData != -1){
                    node.right = new Node(rightData);
                }
            } else {
                // 아직 탐색이 남아있다면
                // 왼쪽 재귀 탐색
                searchNode(node.left, data, leftData, rightData);
                // 오른쪽 재귀 탐색
                searchNode(node.right, data, leftData, rightData);
            }
        }
    }

    //전위순회 Preorder : Root -> Left -> Right
    public void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.data + " ");
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
        }
    }

    //중위 순회 Inorder : Left -> Root -> Right
    public void inOrder(Node node) {
        if(node != null) {
            if(node.left != null) inOrder(node.left);
            System.out.print(node.data + " ");
            if(node.right != null) inOrder(node.right);
        }
    }

    //후위순회 Postorder : Left -> Right -> Root
    public void postOrder(Node node) {
        if(node != null) {
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}

public class Tree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeOrder t = new TreeOrder();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            t.createNode(a, b, c);
        }

        System.out.println("전위 순회");
        t.preOrder(t.root);

        System.out.println("\n중위 순회");
        t.inOrder(t.root);

        System.out.println("\n후위 순회");
        t.postOrder(t.root);
    }
}
