package baekjoon.implement._9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 문제: 백준 1913번. 달팽이
 * 링크: https://www.acmicpc.net/problem/1913
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int targetNumber = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        int number = 1;

        int centerNumber = N / 2;
        board[centerNumber][centerNumber] = number++;

        for(int i = 0; i < centerNumber; i++){
            for (int j = 0; j < 2*(i+1); j++) {
                board[(centerNumber-i)-1][(centerNumber-i)+j] = number++;
            }
            for (int j = 0; j < 2*(i+1); j++) {
                board[(centerNumber-i)+j][(centerNumber+i)+1] = number++;
            }
            for (int j = 0; j < 2*(i+1); j++) {
                board[(centerNumber+i)+1][(centerNumber+i)-j] = number++;
            }
            for (int j = 0; j < 2*(i+1); j++) {
                board[(centerNumber+i)-j][(centerNumber-i)-1] = number++;
            }
        }

        StringBuffer result = new StringBuffer();
        int targetI = 0;
        int targetJ = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result.append(board[i][j]).append(" ");
                if (board[i][j] == targetNumber) {
                    targetI = i + 1;
                    targetJ = j + 1;
                }
            }
            result.append("\n");
        }

        result.append(targetI).append(" ").append(targetJ);
        System.out.println(result);
    }


}