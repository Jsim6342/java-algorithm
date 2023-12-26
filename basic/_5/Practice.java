package basic._5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 * 1~5번 지점으로 구성된 그래프에서 1번에서 BFS 탐색
 */
public class Practice {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) {
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

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();

            System.out.print(node + " "); // 탐색 요구사항

            for(Integer nextNode : adjList[node]) {
                if (visited[nextNode]) continue; // 탐색 여부 확인
                q.add(nextNode);
                visited[nextNode] = true; // 탐색 체크
            }
        }

    }



}
