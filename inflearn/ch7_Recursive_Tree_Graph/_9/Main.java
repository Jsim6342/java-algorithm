package inflearn.ch7_Recursive_Tree_Graph._9;

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

// 7-9. Tree 말단 노드까지의 가장 짧은 경로(DFS)
class Main {
    Node root;
    public int DFS(int level, Node root) {
        if(root.lt == null && root.rt == null) return level;
        return Math.min(DFS(level + 1, root.lt), DFS(level + 1, root.rt));
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.DFS(0, tree.root));

    }
}
