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
public class TreeBFSListPractice {
    public static void main(String[] args) {

        // todo. 트리를 저장할 2차원 리스트 생성

        // todo. 리스트 초기화 (N+1개의 빈 리스트를 추가)

        // todo. 부모-자식 관계 설정 (간선 추가)

        // todo. bfs 실행
//        bfs(1, tree, maxNodeNumber);
        System.out.println();
//        bfs(1, tree);
    }


    // visited Array로 구현
    private static void bfs(int root, List<List<Integer>> tree, int n) {
        // todo. visited(array), queue 초기화

        // todo. queue 순회하며 bfs 실행

    }

    // visited Set으로 구현
    private static void bfs(int root, List<List<Integer>> tree) {
        // todo. visited(set), queue 초기화

        // todo. queue 순회하며 bfs 실행
    }


}
