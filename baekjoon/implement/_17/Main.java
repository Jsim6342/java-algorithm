package baekjoon.implement._17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 문제: 백준 2615번. 오목
 * 링크: https://www.acmicpc.net/problem/2615
 */
class Main {

    // TODO. 코드 중복 제거 등 리팩토링
    // TODO. 테스트케이스 예외상황 찾기

    static int[][] board;
    static boolean[][] checked;
    static int N = 19;
    static int[][] dirWidth = new int[][]{{-1,0},{1,0}};
    static int[][] dirLength = new int[][]{{0,1},{0,-1}};
    static int[][] dirCross1 = new int[][]{{-1,1},{1,-1}};
    static int[][] dirCross2 = new int[][]{{1,1},{-1,-1}};
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

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }




        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if(board[i][j] == 0) {
                    checked[i][j] = true;
                    continue;
                }

                if(board[i][j] == 1 || board[i][j] == 2) {
                    count = 0;
                    checked[i][j] = false;
                    dfsWidth(i, j);
                    if (count == 5) {
                        result = board[i][j];
                        resultI = i + 1;
                        resultJ = j + 1;
                        break;
                    }
//                    System.out.println("width " + count);
                    count = 0;
                    checked[i][j] = false;
                    dfsLength(i,j);
                    if (count == 5) {
                        result = board[i][j];
                        resultI = i + 1;
                        resultJ = j + 1;
                        break;
                    }
//                    System.out.println("length " + count);
                    count = 0;
                    checked[i][j] = false;
                    dfsCross1(i,j);
                    if (count == 5) {
                        result = board[i][j];
                        resultI = i + 1;
                        resultJ = j + 1;
                        break;
                    }
//                    System.out.println("dfsCross1 " + count);
                    count = 0;
                    checked[i][j] = false;
                    dfsCross2(i,j);
                    if (count == 5) {
                        result = board[i][j];
                        resultI = i + 1;
                        resultJ = j + 1;
                        break;
                    }
//                    System.out.println("dfsCross2 " + count);

                }
            }
        }

        if(result == 0) System.out.println(result);
        else {
            System.out.println(result);
            System.out.print(resultI + " " + resultJ);
        }


//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(checked[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
    private static void dfsCross1(int i, int j) {
        if(checked[i][j]) return;

        int node = board[i][j];
        checked[i][j] = true;
        count++;

        for (int k = 0; k < 2; k++) {
            int nextI = i + dirCross1[k][0];
            int nextJ = j + dirCross1[k][1];

            if (isRange(nextI,nextJ) && board[nextI][nextJ] == node) {
                if (board[i][j] == board[nextI][nextJ]) {
                    dfsCross1(nextI, nextJ);
                }
            }
        }
    }

    private static void dfsCross2(int i, int j) {
        if(checked[i][j]) return;

        int node = board[i][j];
        checked[i][j] = true;
        count++;

        for (int k = 0; k < 2; k++) {
            int nextI = i + dirCross2[k][0];
            int nextJ = j + dirCross2[k][1];

            if (isRange(nextI,nextJ) && board[nextI][nextJ] == node) {
                if (board[i][j] == board[nextI][nextJ]) {
                    dfsCross2(nextI, nextJ);
                }
            }
        }
    }

    private static void dfsWidth(int i, int j) {
        if(checked[i][j]) return;

        int node = board[i][j];
        checked[i][j] = true;
        count++;

        for (int k = 0; k < 2; k++) {
            int nextI = i + dirWidth[k][0];
            int nextJ = j + dirWidth[k][1];

            if (isRange(nextI,nextJ) && board[nextI][nextJ] == node) {
                if (board[i][j] == board[nextI][nextJ]) {
                    dfsWidth(nextI, nextJ);
                }
            }
        }
    }

    private static void dfsLength(int i, int j) {
        if(checked[i][j]) return;

        int node = board[i][j];
        checked[i][j] = true;
        count++;

        for (int k = 0; k < 2; k++) {
            int nextI = i + dirLength[k][0];
            int nextJ = j + dirLength[k][1];

            if (isRange(nextI,nextJ) && board[nextI][nextJ] == node) {
                if (board[i][j] == board[nextI][nextJ]) {
                    dfsLength(nextI, nextJ);
                }
            }
        }
    }

    private static boolean isRange(int i, int j) {
        return i > 0 && i < N && j > 0 && j < N;
    }

}