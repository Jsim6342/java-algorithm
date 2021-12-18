package inflearn.ch8_DFS_BFS._4;

import java.util.Scanner;

// 8-4. 중복순열 구하기(DFS)
class Main {
    static int n;
    static int m;
    static int[] arr;


    public void DFS(int level) {
        if(level == m) {
            for (int x : arr) System.out.print(x + " ");
            System.out.println();
        }
        else {
            for (int i = 1; i < n + 1; i++) {
                arr[level] = i;
                DFS(level + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        T.DFS(0);
    }
}
