package basic._4;

import java.util.ArrayList;

/**
 * DFS
 * 1~5번 지점으로 구성된 그래프에서 1번에서 BFS 탐색
 */
public class Practice {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        // 1~5번 지점 연결리스트 갱신
        int N = 6;
        adjList = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        adjList[1].add(2); adjList[1].add(3);
        adjList[2].add(5); adjList[2].add(4);
        adjList[3].add(4);
        adjList[4].add(1);

        dfs(1);
    }

    private static void dfs(int node) {
        if(visited[node]) return; // 탐색 여부 확인

        System.out.print(node + " "); // 탐색 요구사항
        visited[node] = true; // 탐색 체크

        for(Integer nextNode : adjList[node]) {
            dfs(nextNode);
        }
    }

}
