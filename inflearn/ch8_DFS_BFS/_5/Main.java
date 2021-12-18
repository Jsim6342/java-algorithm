package inflearn.ch8_DFS_BFS._5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 8-5. 동전교환
class Main {
    static int n;
    static int m;
    static Integer[] coins;
    static int minCount = Integer.MAX_VALUE;

    public void DFS(int level, int sum) {
        if(sum > m || level >= minCount) return;
        if(sum == m) {
            minCount = Math.min(minCount, level);
        }
        else{
            for (int coin : coins) {
                DFS(level + 1, sum + coin);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        m = sc.nextInt();
        Arrays.sort(coins, Collections.reverseOrder());

        T.DFS(0, 0);
        System.out.println(minCount);
    }
}
