package inflearn.ch10_Dynamic_Programming._5;

import java.util.Arrays;
import java.util.Scanner;

// 10-5. 동전교환
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
        coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = sc.nextInt();

        m = sc.nextInt();
        dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        System.out.println(T.solution());

    }
}
