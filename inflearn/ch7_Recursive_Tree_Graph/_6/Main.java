package inflearn.ch7_Recursive_Tree_Graph._6;

import java.util.ArrayList;
import java.util.Scanner;

// 7-6. 부분집합 구하기(DFS)
class Main {
    static int n;
    static int[] arr;

    public void DFS(int level) {
        if(level == n + 1) {
            String answer = "";
            for (int i = 1; i < n + 1; i++) {
                if(arr[i] == 1) answer += i;
            }
            System.out.println(answer);
            return;
        }
        arr[level] = 1;
        DFS(level + 1);
        arr[level] = 0;
        DFS(level + 1);

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr= new int[n + 1];

        T.DFS(1);

    }
}
