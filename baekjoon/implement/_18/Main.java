package baekjoon.implement._18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 문제: 백준 17276번. 배열 돌리기
 * 링크: https://www.acmicpc.net/problem/17276
 */
class Main {

    static int T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < T; i++) {
            List<Integer> inputNumber = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int n = inputNumber.get(0);
            int d = inputNumber.get(1);

            int[][] array = new int[n][n];

            for (int j = 0; j < n; j++) {
                List<Integer> arrayLine = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                for (int k = 0; k < n; k++) {
                    array[j][k] = arrayLine.get(k);
                }
            }

            if(d > 0) {
                for (int j = 0; j < d/45; j++) {
                    array = plusRotateArray(array, n);
                }
            }else {
                d = Math.abs(d);
                for (int j = 0; j < d/45; j++) {
                    array = minusRotateArray(array, n);
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sb.append(array[j][k] + " ");
                }
                sb.append("\n");
            }

        }

        System.out.println(sb);

    }

    private static int[][] plusRotateArray(int[][] array, int n) {
        int[][] newArray = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                newArray[j][k] = array[j][k];
            }
        }

        for (int j = 0; j < n; j++) {
            newArray[j][(n-1)/2] = array[j][j];
            newArray[j][(n-1)-j] = array[j][(n-1)/2];
            newArray[(n-1)/2][j] = array[(n-1)-j][j];
            newArray[j][j] = array[(n-1)/2][j];
        }

        return newArray;
    }

    private static int[][] minusRotateArray(int[][] array, int n) {
        int[][] newArray = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                newArray[j][k] = array[j][k];
            }
        }

        for (int j = 0; j < n; j++) {
            newArray[j][j] = array[j][(n-1)/2];
            newArray[j][(n-1)/2] = array[j][(n-1)-j];
            newArray[(n-1)-j][j] = array[(n-1)/2][j];
            newArray[(n-1)/2][j] = array[j][j];
        }

        return newArray;
    }



}