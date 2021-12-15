package inflearn.ch7_Recursive_Tree_Graph._5;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int data) {
        this.data = data;
        this.lt = null;
        this.rt = null;
    }
}

// 7-5. 이진트리 순회(깊이우선탐색)
class Main {
    Node root;
    public void DFS(Node root) {
        if(root == null) return;

        // System.out.print(root.data + " "); // 전위 순회
        DFS(root.lt);
        // System.out.print(root.data + " "); // 중위 순회
        DFS(root.rt);
        // System.out.print(root.data + " "); // 후위 순회

    }

    public static void main(String[] args) {
       Main tree = new Main();
       tree.root = new Node(1);
       tree.root.lt = new Node(2);
       tree.root.rt = new Node(3);
       tree.root.lt.lt = new Node(4);
       tree.root.lt.rt = new Node(5);
       tree.root.rt.lt = new Node(6);
       tree.root.rt.rt = new Node(7);
       tree.DFS(tree.root);

    }
}
