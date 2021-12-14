package inflearn.ch7_Recursive_Tree_Graph._3;

import java.util.Scanner;

// 7-3. 팩토리얼
class Main {

    public int solution(int n) {
        return DFS(n);
    }

    private int DFS(int n) {
        if(n == 1) return 1;
        return n * DFS(n - 1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));

    }
}
