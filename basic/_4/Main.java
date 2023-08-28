package basic._4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DFS
 */
class Main {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        int N = 6;
        adjList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1 ; i <= N ; i ++) {
            adjList[i] = new ArrayList<Integer>();
        }

        adjList[1].add(2); adjList[1].add(3);
        adjList[2].add(5); adjList[2].add(4);
        adjList[3].add(4);
        adjList[4].add(1);

        dfs(1);
    }

    public static void dfs(int node) {
        if (visited[node] == true) return;

        System.out.print(node + " ");
        visited[node] = true;

        for (Integer nextNode : adjList[node]) {
            dfs(nextNode);
        }

    }

}
