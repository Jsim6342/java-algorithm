package inflearn.ch9_Greedy._7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 9-7. 원더랜드(크루스칼)
class Edge implements Comparable<Edge> {
    public int v1;
    public int v2;
    public int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
class Main {
    static int v, e;
    static int[] unf;
    static ArrayList<Edge> graph = new ArrayList<>();
    public static int Find(int v) {
        if(v == unf[v]) return unf[v];
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int findA = Find(a);
        int findB = Find(b);
        if(findA != findB) unf[findA] = findB;
    }

    public int solution() {
        int answer = 0;
        int cnt = 0;
        Collections.sort(graph);
        for (Edge edge : graph) {
            if(cnt == v - 1) break; // 트리 간선 n - 1개임을 활용한 최적화.(트리가 완성되면 로직 중단)
            if(Find(edge.v1) != Find(edge.v2)) {
                Union(edge.v1, edge.v2);
                answer += edge.cost;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        unf = new int[v + 1];
        for (int i = 1; i < v + 1; i++) unf[i] = i;

        graph = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            graph.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        System.out.println(T.solution());

    }
}
