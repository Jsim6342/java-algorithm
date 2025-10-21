package template._5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Java 트리 정리 - DFS List 활용
 * 일방향 트리, 양방향 트리 (Tree는 2차원리스트로 구현, visited 구현)
 *
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 */
public class TreeDFSList {
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


        dfs(1, new boolean[maxNodeNumber], tree);
        System.out.println();
        dfs(1, new HashSet(), tree);
    }


    // visited Array로 구현
    private static void dfs(int cur, boolean[] visited, List<List<Integer>> tree) {
        System.out.print(cur + " ");
        visited[cur] = true;
        for (int child : tree.get(cur)) {
            if (!visited[child]) {
                dfs(child, visited, tree);
            }
        }
    }

    // visited Set으로 구현
    private static void dfs(int cur, Set<Integer> visited, List<List<Integer>> tree) {
        System.out.print(cur + " ");
        visited.add(cur);
        for (int child : tree.get(cur)) {
            if (!visited.contains(child)) {
                dfs(child, visited, tree);
            }
        }
    }


}
