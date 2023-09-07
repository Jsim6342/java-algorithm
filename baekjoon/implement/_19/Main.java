package baekjoon.implement._19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 문제: 백준 16926번. 배열 돌리기 1
 * 링크: https://www.acmicpc.net/problem/16926
 */
class Main {

    static int N;
    static int M;
    static int R;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputNumbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        N = inputNumbers.get(0);
        M = inputNumbers.get(1);
        R = inputNumbers.get(2);

        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            for (int j = 0; j < M; j++) {
                array[i][j] = numbers.get(j);
            }
        }

        for (int i = 0; i < R; i++) {
            array = rotate(array);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(array[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

    private static int[][] rotate(int[][] array) {
        int[][] newArray = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArray[i][j] = array[i][j];
            }
        }

        int count = Math.min(N, M)/2;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < N-1-(i*2); j++) {
                newArray[i+j+1][i] = array[i+j][i];
            }
            for (int j = 0; j < N-1-(i*2); j++) {
                newArray[N-2-i-j][M-1-i] = array[N-1-i-j][M-1-i];
            }
            for (int j = 0; j < M-1-(i*2); j++) {
                newArray[i][M-2-i-j] = array[i][M-1-i-j];
            }
            for (int j = 0; j < M-1-(i*2); j++) {
                newArray[N-1-i][i+j+1] = array[N-1-i][i+j];
            }
        }

        return newArray;
    }


}