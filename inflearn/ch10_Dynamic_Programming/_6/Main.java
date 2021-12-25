package inflearn.ch10_Dynamic_Programming._6;

import java.util.Arrays;
import java.util.Scanner;

// 10-6. 최대점수 구하기
class Main {

    static int n, m;
    static int[] coins;
    static int[] dy;

    public int solution() {

        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = coin; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin] + 1);
            }
        }

        return dy[m];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        dy = new int[m + 1];

        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            for (int j = m; j >= time; j--) {
                dy[j] = Math.max(dy[j], dy[j - time] + score);
            }
        }

        System.out.println(dy[m]);
    }
}
