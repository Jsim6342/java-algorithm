package inflearn.ch7_Recursive_Tree_Graph._4_2;

import java.util.ArrayList;
import java.util.Scanner;

// 7-4. 피보나치 수열2
class Main {

    static int[] fibo;
    private int DFS(int n) {
        if(fibo[n] > 0) return fibo[n];
        if(n == 1) return fibo[n] = 1;
        if(n == 2) return fibo[n] = 1;
        return fibo[n] = DFS(n - 2) + DFS(n - 1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        fibo = new int[n + 1];
        T.DFS(n);
        for (int i = 1; i < n + 1 ; i++) System.out.print(fibo[i] + " ");

    }
}
