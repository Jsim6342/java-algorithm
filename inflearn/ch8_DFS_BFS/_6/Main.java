package inflearn.ch8_DFS_BFS._6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 8-6. 순열 구하기
class Main {
    static int n;
    static int m;
    static int[] numbers;
    static ArrayList<Integer> answer;

    public void DFS(int level) {
        if(level == m) {
            for (int x : answer) System.out.print(x + " ");
            System.out.println();
        }
        else{
            for (int number : numbers) {
                if(answer.contains(number)) continue;
                answer.add(number);
                DFS(level + 1);
                answer.remove(Integer.valueOf(number));
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        for (int i = 0; i < n; i++) numbers[i] = sc.nextInt();
        answer = new ArrayList<>();

        T.DFS(0);
    }
}
