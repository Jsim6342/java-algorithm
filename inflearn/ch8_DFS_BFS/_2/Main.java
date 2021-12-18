package inflearn.ch8_DFS_BFS._2;

import java.util.Scanner;

// 8-2. 바둑이 승차(DFS)
class Main {
    static int c;
    static int n;
    static int maxSum = Integer.MIN_VALUE;
    static int[] arr;


    public void DFS(int level, int sum) {
        if(sum > c) return;
        if(level == n) {
            if(sum > maxSum) maxSum = sum;
        }
        else {
            DFS(level + 1, sum + arr[level]);
            DFS(level + 1, sum);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        T.DFS(0, 0);
        System.out.println(maxSum);
    }
}
