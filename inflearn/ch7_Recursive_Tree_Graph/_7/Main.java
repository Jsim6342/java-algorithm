package inflearn.ch7_Recursive_Tree_Graph._7;

import java.util.LinkedList;
import java.util.Queue;
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

// 7-7. 이진트리 순회(넓이우선탐색 : 레벨탐색)
class Main {
    Node root;
    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int level = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(level + " : ");
            for (int i = 0; i < len; i++) {
                Node now = Q.poll();
                System.out.print(now.data + " ");
                if(now.lt != null) Q.offer(now.lt);
                if(now.rt != null) Q.offer(now.rt);
            }
            level++;
            System.out.println();
        }

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
        tree.BFS(tree.root);

    }
}
