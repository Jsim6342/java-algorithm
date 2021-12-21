package inflearn.ch8_DFS_BFS._11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 8-11. 미로의 최단거리 통로(BFS)

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {

    static int[][] board;
    static int[][] dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        board[x][y] = 1;
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(0 <= nx && nx <= 6 && 0 <= ny && ny <= 6 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.add(new Point(nx, ny));
                    dis[nx][ny] = dis[now.x][now.y] + 1;
               }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        board = new int[7][7];
        dis = new int[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        T.BFS(0, 0);
        if(dis[6][6] == 0) System.out.println(-1);
        else System.out.println(dis[6][6]);

    }
}
