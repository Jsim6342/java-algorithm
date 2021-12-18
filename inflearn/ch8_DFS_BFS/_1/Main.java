package inflearn.ch8_DFS_BFS._1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 8-1. DFS, BFS 활용
class Main {
    static String answer = "NO";
    static int n = 0;
    static int total = 0;
    boolean flag = false;

    public void DFS(int level, int sum, int[] arr) {
        if(flag) return;
        if(sum > total / 2) return;
        if(level == n) {
            if((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        }
        else {
            DFS(level + 1, sum + arr[level], arr);
            DFS(level + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
