package inflearn.ch7_Recursive_Tree_Graph._10_2;

import java.util.ArrayList;
import java.util.Scanner;

// 7-10. 경로 탐색(인접리스트)
class Main {

    static int cnt = 0;
    static int n = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<Integer> check = new ArrayList<>();

    public void DFS(int start) {
        if(start == n) cnt++;
        for (Integer integer : graph.get(start)) {
            if(check.contains(integer) == false) {
                check.add(integer);
                DFS(integer);
                check.remove(Integer.valueOf(integer));
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
        }

        check.add(1);
        T.DFS(1);

        System.out.println(cnt);
    }
}
