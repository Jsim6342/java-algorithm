package inflearn.ch7_Recursive_Tree_Graph._11;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 7-11. 그래프 최단거리(BFS)
class Main {

    static int cnt = 0;
    static int n = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check;
    static int[] dis;

    public void BFS(int start) {
        Queue<Integer> q = new LinkedList();

        check[start] = 1;
        dis[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (Integer next : graph.get(now)) {
                if (check[next] == 0) {
                    check[next] = 1;
                    q.add(next);
                    dis[next] = dis[now] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        check = new int[n + 1];
        dis = new int[n + 1];

        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
        }

        T.BFS(1);

        for (int x : dis) System.out.println(x);
    }
}
