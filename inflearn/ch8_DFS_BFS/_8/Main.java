package inflearn.ch8_DFS_BFS._8;

import java.util.Scanner;

// 8-8. 수열 추측하기
class Main {
    static int[] b, p, ch;
    static int n, f;
    boolean flag = false;
    int[][] dy = new int[35][35];

    // 미리 조합 수를 구해놓음.
    public int combi(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];
        if(n == r || r == 0) return 1;
        else return dy[n][r] = combi(n -1, r - 1) + combi(n - 1, r);
    }


    public void DFS(int level, int sum) {
        if(flag) return;
        if(level == n) {
            if(sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                    flag = true;
                }
            }
        }
        else{
            for (int i = 1; i < n + 1; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    p[level] = i;
                    DFS(level + 1, sum + (p[level] * b[level]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();

        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];

        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }
        T.DFS(0, 0);
    }
}
