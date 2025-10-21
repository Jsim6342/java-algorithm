package template._5;

import java.util.*;

/**
 * Java 트리 정리 - BFS List 활용
 * 일방향 트리, 양방향 트리 (Tree는 2차원리스트로 구현, visited 구현)
 *
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 */
public class TreeBFSList {
    public static void main(String[] args) {

        // 1. 트리를 저장할 2차원 리스트 생성
        // 노드가 5개 (1~5) 있으므로, 0번 인덱스는 비워두고
        // 1~5번 인덱스를 사용하기 위해 크기를 6으로 설정합니다.
        int maxNodeNumber = 6;
        List<List<Integer>> tree = new ArrayList<>();

        // 2. 리스트 초기화 (N+1개의 빈 리스트를 추가)
        for (int i = 0; i < maxNodeNumber; i++) {
            tree.add(new ArrayList<>());
        }

        // 3. 부모-자식 관계 설정 (간선 추가)
        tree.get(1).add(2);
        tree.get(1).add(3);
        tree.get(2).add(4);
        tree.get(2).add(5);


        bfs(1, tree, maxNodeNumber);
        System.out.println();
        bfs(1, tree);
    }


    // visited Array로 구현
    private static void bfs(int root, List<List<Integer>> tree, int n) {
        boolean[] visited = new boolean[n];
        visited[root] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            System.out.print(cur + " ");
            for (int child : tree.get(cur)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }
    }

    // visited Set으로 구현
    private static void bfs(int root, List<List<Integer>> tree) {
        Set<Integer> visited = new HashSet<>();
        visited.add(root);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            System.out.print(cur + " ");
            for (int child : tree.get(cur)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(child);
                }
            }
        }
    }


}
