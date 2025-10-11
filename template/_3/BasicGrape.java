package template._3;

import java.util.*;

/**
 * Java 그래프 정리
 * BFS, DFS 시간복잡도 - 인접리스트: O(V+E), 인접행렬: O(V^2)
 */
class BasicGrape {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>(){{
           add(List.of(3,1,6));
           add(List.of(0,3));
           add(List.of(3));
           add(List.of(2,7,1,0));
           add(List.of(5));
           add(List.of(6,7,4));
           add(List.of(0,5));
           add(List.of(3,5));
        }};

        System.out.println("bfsWithSet:");
        bfsWithSet(graph, 0);
        System.out.println();

        System.out.println("bfsWithArray:");
        bfsWithArray(graph, 0);
        System.out.println();

        System.out.println("dfsWithSet:");
        dfsWithSet(graph, 0, new HashSet<>());
        System.out.println();

        System.out.println("dfsWithArray:");
        dfsWithArray(graph, 0, new boolean[graph.size()]);
        System.out.println();
    }

    // BFS
    // visited를 set으로 구현
    private static void bfsWithSet(List<List<Integer>> graph, int start) {
        // 시작점 예약
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited.add(start);
        // queue가 비어있을 때까지 반복
        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int cur = queue.remove();
            System.out.print(cur + " ");
            // 다음 노드 예약
            for (int next : graph.get(cur)) {
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
    }

    // BFS
    // visited를 array으로 구현
    private static void bfsWithArray(List<List<Integer>> graph, int start) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        // 시작점 예약
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int cur = queue.remove();
            System.out.print(cur + " ");
            // 다음 노드 예약
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }


    // DFS
    // 재귀 활용
    // visited를 set으로 구현
    private static void dfsWithSet(List<List<Integer>> graph, int cur, Set<Integer> visited) {
        // 현재 노드 방문
        visited.add(cur);
        System.out.print(cur + " ");
        // 다음 노드 탐색
        for (int next : graph.get(cur)) {
            if (!visited.contains(next)) {
                dfsWithSet(graph, next, visited);
            }
        }
    }

    // DFS
    // 재귀 활용
    // visited를 array으로 구현
    private static void dfsWithArray(List<List<Integer>> graph, int cur, boolean[] visited) {
        // 현재 노드 방문
        visited[cur] = true;
        System.out.print(cur + " ");
        // 다음 노드 탐색
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfsWithArray(graph, next, visited);
            }
        }
    }

}
