package inflearn.ch8_DFS_BFS._7;

import java.util.ArrayList;
import java.util.Scanner;

// 8-7. 조합의 경우수(메모이제이션)
class Main {
    static int[][] memory;

    public int DFS(int n, int r) {
        if(memory[n][r] != 0) return memory[n][r];
        if(r == 0 || n == r) {
            memory[n][r] = 1;
            return 1;
        }
        else{
            return memory[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        memory = new int[n + 1][r + 1];

        System.out.println(T.DFS(n, r));
    }
}
