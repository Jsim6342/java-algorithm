package inflearn.ch7_Recursive_Tree_Graph._9_2;

import java.util.LinkedList;
import java.util.Queue;

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

// 7-9. Tree 말단 노드까지의 가장 짧은 경로(BFS)
class Main {
    Node root;
    public int BFS(int level, Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node now = q.poll();
                if(now.rt == null && now.lt == null) return level;
                if(now.lt != null) q.offer(root.lt);
                if(now.rt != null) q.offer(root.rt);
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(0, tree.root));

    }
}
