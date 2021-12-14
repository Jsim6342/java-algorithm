package inflearn.ch7_Recursive_Tree_Graph._2;

import java.util.ArrayList;
import java.util.Scanner;

// 7-2. 재귀함수를 이용한 이진수 출력
class Main {

    public void solution(int n) {
        DFS(n);
    }

    private void DFS(int n) {
        if(n == 0) return;
        DFS(n / 2);
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.solution(n);

    }
}
