package inflearn.ch7_Recursive_Tree_Graph._8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 7-8. 송아지 찾기(BFS)
class Main {
    static int s;
    static int e;
    static int[] check;
    static int[] dir = {-1, 1, 5};

    public void BFS(int level) {
        check = new int[10001];
        Queue<Integer> q = new LinkedList<>();
        check[s] = 1;
        q.offer(s);
        while(!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int now = q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = now + dir[j];
                    if(nx == e) {
                        System.out.println(level + 1);
                        return;
                    }
                    if(1 <= nx && nx <= 10000 && check[nx] == 0) {
                        q.offer(nx);
                        check[nx] = 1;
                    }

                }
            }
            level++;
        }

    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        s = sc.nextInt();
        e = sc.nextInt();


        T.BFS(0);

    }
}
