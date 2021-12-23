package inflearn.ch9_Greedy._8;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// 9-8. 원더랜드(프림)
class Edge implements Comparable<Edge> {
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

    static int[] check;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        check = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(v1).add(new Edge(v2, cost));
            graph.get(v2).add(new Edge(v1, cost));
        }
        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(1, 0));
        while(!pQ.isEmpty()) {
            Edge now = pQ.poll();
            if(check[now.vertex] == 0) {
                check[now.vertex] = 1;
                answer += now.cost;
                for (Edge next : graph.get(now.vertex)) {
                    if(check[next.vertex] == 0) pQ.add(next);
                }
            }
        }

        System.out.println(answer);
    }
}
