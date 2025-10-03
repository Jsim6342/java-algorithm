package template._4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Java 그래프 정리
 * BFS, DFS 시간복잡도 - 인접리스트: O(V+E), 인접행렬: O(V^2)
 */
class BFSPractice {

    // 8방향 (상, 하, 좌, 우 + 대각선)
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};

    static int n;
    static int m;
    static boolean[][] visited;

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1},
                {0, 1, 0, 1},
                {0, 1, 0, 1},
                {1, 0, 1, 1}
        };
        solution(grid, 0, 0);
        System.out.println(Arrays.deepToString(visited));
    }

    private static void solution(int[][] grid, int startRow, int startCol) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        bfs(grid, startRow, startCol);
    }

    // BFS 탐색
    private static void bfs(int[][] grid, int startR, int startC) {
      // todo. 구현
    }
}
