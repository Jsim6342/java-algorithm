package template._4;

import java.util.Arrays;

/**
 * Java 그래프 정리
 * BFS, DFS 시간복잡도 - 인접리스트: O(V+E), 인접행렬: O(V^2)
 */
class DFSPractice {

    // 4방향 (우, 하, 좌, 상)
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

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

        dfs(grid, startRow, startCol);
    }

    // BFS 탐색
    private static void dfs(int[][] grid, int r, int c) {
       // todo. 구현
    }
}
