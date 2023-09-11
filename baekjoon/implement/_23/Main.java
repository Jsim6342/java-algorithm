package baekjoon.implement._23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제: 백준 5766번. 할아버지는 유명해!
 * 링크: https://www.acmicpc.net/problem/5766
 */
class Main {

    static int N;
    static int M;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;


            if (N == 0 && M == 0) break;

            int[] players = new int[10001];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    int number = Integer.parseInt(st.nextToken());
                    players[number] += 1;
                }
            }

            for (int i = 1; i < 10001; i++) {
                first = Math.max(first, players[i]);
            }

            for (int i = 1; i < 10001; i++) {
                if(players[i] != first){
                    second = Math.max(second, players[i]);
                }
            }



            for (int i = 1; i < 10001; i++) {
                if(players[i] == second) result.append(i+" ");
            }

            result.append("\n");

        }

        System.out.println(result.toString());

    }

}