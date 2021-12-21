package inflearn.ch8_DFS_BFS._10;

import java.util.Scanner;

// 8-10. 미로탐색
class Main {

    static int[][] board;
    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void DFS(int x, int y) {
        if(x == 6 && y == 6) answer += 1;
        else{
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx <= 6 && 0 <= ny && ny <= 6 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        board = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        board[0][0] = 1; // 시작 지점 1로 초기화
        T.DFS(0, 0);
        System.out.println(answer);

    }
}
