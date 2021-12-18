package inflearn.ch8_DFS_BFS._3;

import java.util.Scanner;

// 8-3. 최대점수 구하기(DFS)
class Main {
    static int n;
    static int m;
    static int maxScore = Integer.MIN_VALUE;
    static int[] scores;
    static int[] times;


    public void DFS(int level, int score, int time) {
        if(time > m) return;
        if(level == n) {
            if(score > maxScore) maxScore = score;
        }
        else {
            DFS(level + 1, score + scores[level], time + times[level]);
            DFS(level + 1, score, time);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        scores = new int[n];
        times = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }

        T.DFS(0, 0, 0);
        System.out.println(maxScore);
    }
}
