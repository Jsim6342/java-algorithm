package template._5;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 트리 정리 - DFS Class 활용
 * 일반트리, 이진트리를 구분하여 구현
 *
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 */
public class TreeDFSClass {
    public static void main(String[] args) {

        System.out.println("일반트리 DFS 실행");

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

        dfs(root);

        System.out.println();
        System.out.println("이진트리 DFS 실행");

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

        dfs(binaryRoot);


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

    // 일반 트리 dfs
    private static void dfs(Node node) {
        System.out.print(node.value + " ");
        for (Node child : node.children) {
            dfs(child);
        }
    }

    // 이진트리 dfs
    private static void dfs(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " "); // 전위순회: 부모 노드 방문 → 자식 노드 모두 방문 (1 2 4 5 3 )
        dfs(node.left);
//        System.out.print(node.value + " "); // 중위순회: 왼쪽 자식 방문 → 부모 → 오른쪽 자식 방문 (4 2 5 1 3)
        dfs(node.right);
//        System.out.print(node.value + " "); // 후회순회: 자식 노드 모두 방문 → 부모 노드 방문 (4 5 2 3 1)
    }


}
