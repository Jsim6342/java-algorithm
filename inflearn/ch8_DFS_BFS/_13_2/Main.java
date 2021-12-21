package inflearn.ch8_DFS_BFS._13_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 8-13. 섬나라 아일랜드(BFS)
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static int n;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};

    public void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        while(!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(0<= nx && nx < n && 0<= ny && ny < n && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    q.add(new Point(nx, ny));
                }
            }
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    T.BFS(i, j);

                }
            }
        }

        System.out.println(answer);

    }
}
