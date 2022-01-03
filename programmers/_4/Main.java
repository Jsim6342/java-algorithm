package programmers._4;

import java.util.*;

// 카카오프렌즈 컬러링 북
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main {

    Set<Integer> countArea = new HashSet<>();
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][] check;


    public int[] solution(int m, int n, int[][] picture) {
        check = new int[m][n];

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        // 영역 갯수 카운트(종류)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] == 0) check[i][j] = 1;
            }
        }

        // 최대 영역 갯수 카운트
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(check[i][j] == 1) continue;

                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(i, j));
                check[i][j] = 1;
                int count = 1;
                numberOfArea++;

                while(!queue.isEmpty()) {
                    Point now = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = now.x + dx[k];
                        int ny = now.y + dy[k];
                        if(0 <= nx && nx < m && 0 <= ny && ny < n
                                && picture[now.x][now.y] == picture[nx][ny] && check[nx][ny] == 0) {
                            check[nx][ny] = 1;
                            count++;
                            queue.add(new Point(nx, ny));
                        }
                    }
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int m = 6;
        int n = 4;

        System.out.println(Arrays.toString(T.solution(m, n, picture)));
    }
}
