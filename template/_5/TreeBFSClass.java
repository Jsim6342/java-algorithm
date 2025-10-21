package template._5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Java 트리 정리 - BFS Class 활용
 * 일반트리, 이진트리를 구분하여 구현
 *
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 */
public class TreeBFSClass {
    public static void main(String[] args) {

        System.out.println("일반트리 BFS 실행");

        // 각 노드 생성
        Node root = new Node(1); // 루트 노드 (1)
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        // 부모-자식 관계 설정
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);

        bfs(root);

        System.out.println();
        System.out.println("이진트리 BFS 실행");

        // 2. 각 노드 생성
        BinaryNode binaryRoot = new BinaryNode(1); // 루트 노드 (1)
        BinaryNode binaryNode2 = new BinaryNode(2);
        BinaryNode binaryNode3 = new BinaryNode(3);
        BinaryNode binaryNode4 = new BinaryNode(4);
        BinaryNode binaryNode5 = new BinaryNode(5);

        // 3. 부모-자식 관계 설정
        // root(1)의 자식 설정
        binaryRoot.left = binaryNode2;
        binaryRoot.right = binaryNode3;

        // node2의 자식 설정
        binaryNode2.left = binaryNode4;
        binaryNode2.right = binaryNode5;

        bfs(binaryRoot);


    }

    // 일반트리 노드
    public static class Node {
        int value;
        List<Node> children = new ArrayList<>();
        Node(int value) {
            this.value = value;
        }
    }

    // 이진트리 노드
    public static class BinaryNode {
        int value;
        BinaryNode left;
        BinaryNode right;
        BinaryNode(int value) {
            this.value = value;
        }
    }

    // 일반 트리 bfs
    private static void bfs(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.print(cur.value + " ");
            for (Node child : cur.children) {
                queue.add(child);
            }
        }
    }

    // 이진트리 bfs
    private static void bfs(BinaryNode root) {
        Queue<BinaryNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode cur = queue.remove();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


}
