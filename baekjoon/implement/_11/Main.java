package baekjoon.implement._11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 문제: 백준 4396번. 지뢰 찾기
 * 링크: https://www.acmicpc.net/problem/4396
 */
class Main {

    static Character[][] board;
    static Character[][] selected;
    static Character[][] result;
    static int N;
    static boolean mineSelected = false;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(selected[i][j] == 'x') result[i][j] = Character.forDigit(countMine(i, j), 10);
                if(selected[i][j] == '.') result[i][j] = '.';
            }

        }

        if (mineSelected) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(board[i][j] == '*') result[i][j] = '*';
                }
            }
        }
        print(result);
    }

    private static int countMine(int i, int j) {
        int mineCount = 0;
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                if(!isRange(i+k, j+l)) continue;
                if(k == 0 && l == 0 && board[i+k][j+l] == '*') mineSelected = true;
                if(board[i+k][j+l] == '*') mineCount++;
            }
        }
        return mineCount;
    }

    private static boolean isRange(int i, int j) {
        return 0<=i && i<N && 0<=j && j<N;
    }

    private static void print(Character[][] target) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(target[i][j]);
            }
            System.out.println();
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new Character[N][N];
        selected = new Character[N][N];
        result = new Character[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                board[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                selected[i][j] = input.charAt(j);
            }
        }
    }


}