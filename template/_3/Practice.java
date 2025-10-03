package template._3;

import java.util.*;

/**
 * Java 그래프 정리
 * BFS, DFS 시간복잡도 - 인접리스트: O(V+E), 인접행렬: O(V^2)
 */
class Practice {
    public static void main(String[] args) {

    }

    // BFS
    // visited를 set으로 구현
    private static void bfsWithSet(List<List<Integer>> graph, int start) {
        // todo. 시작점 예약
        // todo. queue가 비어있을 때까지 반복
            // todo. 현재 노드 방문
            // todo. 다음 노드 예약
    }

    // BFS
    // visited를 array으로 구현
    private static void bfsWithArray(List<List<Integer>> graph, int start) {
        // todo. 선언 및 초기화
        // todo. 시작점 예약
            // todo. 현재 노드 방문
            // todo. 다음 노드 예약
    }


    // DFS
    // 재귀 활용
    // visited를 set으로 구현
    private static void dfsWithSet(List<List<Integer>> graph, int cur, Set<Integer> visited) {
        // todo. 현재 노드 방문
        // todo. 다음 노드 탐색
    }

    // DFS
    // 재귀 활용
    // visited를 array으로 구현
    private static void dfsWithArray(List<List<Integer>> graph, int cur, boolean[] visited) {
        // todo. 현재 노드 방문
        // todo. 다음 노드 탐색
    }

}
