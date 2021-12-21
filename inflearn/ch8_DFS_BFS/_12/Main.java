package inflearn.ch8_DFS_BFS._12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 8-12. 토마토
class Main {

    static int n, m;
    static int[][] board;
    static int day = 0;
    static boolean check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int BFS(Queue<Point> q) {

        while (!q.isEmpty()){
            check = false;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point now = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if(0<= nx && nx < n && 0<= ny && ny < m && board[nx][ny] == 0) {
                        check = true;
                        board[nx][ny] = 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
            if(check == true) day += 1;
        }
        return day;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        board = new int[n][m];
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) q.add(new Point(i, j));
            }
        }

        T.BFS(q);
        check = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 0) check = false;
            }
        }

        if(check) System.out.println(day);
        else System.out.println(-1);
    }
}
