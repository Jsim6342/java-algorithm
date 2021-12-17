package inflearn.ch7_Recursive_Tree_Graph._10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 7-10. 경로 탐색(인접행렬)
class Main {

    static int cnt = 0;
    static int n = 0;
    static int[][] graph;
    static ArrayList<Integer> check = new ArrayList<>();

    public void DFS(int start) {
        if(start == n) cnt++;
        for (int i = 1; i < n + 1; i++) {
            if(graph[start][i] == 1 && check.contains(i) == false) {
                check.add(i);
                DFS(i);
                check.remove(Integer.valueOf(i));
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
        }

        check.add(1);
        T.DFS(1);

        System.out.println(cnt);
    }
}
