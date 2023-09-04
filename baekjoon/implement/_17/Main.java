package baekjoon.implement._17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 문제: 백준 2615번. 오목
 * 링크: https://www.acmicpc.net/problem/2615
 */
class Main {

    static int[][] board;
    static boolean[][] checked;
    static int N = 19;
    static int[][] dirWidth = new int[][]{{0,1},{0,-1}};
    static int[][] dirLength = new int[][]{{-1,0},{1,0}};
    static int[][] dirCross1 = new int[][]{{-1,1},{1,-1}};
    static int[][] dirCross2 = new int[][]{{1,1},{-1,-1}};
    static List<int[][]> searchDirList = new ArrayList<>(List.of(dirWidth, dirLength, dirCross1, dirCross2));
    static int count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[N][N];
        checked = new boolean[N][N];

        int result = 0;
        int resultI = 0;
        int resultJ = 0;

        for (int i = 0; i < N; i++) {
            List<Integer> line = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            for (int j = 0; j < N; j++) {
                board[i][j] = line.get(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 1 || board[i][j] == 2) {
                    for (int[][] dirList : searchDirList) {
                        count = 0;
                        dfs(i,j,dirList);
                        if (count == 5 && isLeft(resultJ, j)) {
                            result = board[i][j];
                            resultI = i + 1;
                            resultJ = j + 1;
                        }
                    }
                }
            }
        }

        if(result == 0) System.out.println(result);
        else {
            System.out.println(result);
            System.out.print(resultI + " " + resultJ);
        }

    }
    private static void dfs(int i, int j, int[][] dirList) {
        if(checked[i][j]) return;

        int node = board[i][j];
        checked[i][j] = true;
        count++;

        for (int k = 0; k < 2; k++) {
            int nextI = i + dirList[k][0];
            int nextJ = j + dirList[k][1];

            if (isRange(nextI,nextJ) && board[nextI][nextJ] == node) {
                if (board[i][j] == board[nextI][nextJ]) {
                    dfs(nextI, nextJ, dirList);
                }
            }
        }
        checked[i][j] = false;
    }


    private static boolean isRange(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    private static boolean isLeft(int resultJ, int j) {
        return resultJ == 0 || j + 1 < resultJ;
    }

}