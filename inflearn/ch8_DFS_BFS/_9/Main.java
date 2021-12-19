package inflearn.ch8_DFS_BFS._9;

import java.util.Scanner;

// 8-9. 조합 구하기
class Main {
    static int n, m;
    static int[] answer;

    public void DFS(int level, int start) {
        if(level == m) {
            for (int num : answer) System.out.print(num + " ");
            System.out.println();
        }else {
            for (int i = start; i < n + 1; i++) {
                answer[level] = i;
                DFS(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        answer = new int[m];

        T.DFS(0, 1);

    }
}
