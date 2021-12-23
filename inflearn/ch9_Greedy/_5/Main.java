package inflearn.ch9_Greedy._5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 9-5. 다익스트라 알고리즘
class Edge implements Comparable<Edge>{
    int vertex;
    int cost;

    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class Main {

    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;

    public void solution(int v)  {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge nowEdge = pQ.poll();
            int now = nowEdge.vertex;
            int nowCost = nowEdge.cost;
            if(nowCost > dis[now]) continue;
            for (Edge nextEdge : graph.get(now)) {
                if(dis[nextEdge.vertex] > nowCost + nextEdge.cost) {
                    dis[nextEdge.vertex] = nowCost + nextEdge.cost;
                    pQ.add(new Edge(nextEdge.vertex, nowCost + nextEdge.cost));
                }
            }
        }
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(start).add(new Edge(end, cost));
        }

        T.solution(1);
        for(int i=2; i<=n; i++){
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : impossible");
        }

    }
}
