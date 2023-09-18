package baekjoon.implement._25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 백준 10703번. 유성
 * 링크: https://www.acmicpc.net/problem/10703
 */
class Main {

    static int R;
    static int S;
    static char[][] picture;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        picture = new char[R][S];

        for (int i = 0; i < R; i++) {
            String lineOfPicture = br.readLine();
            for (int j = 0; j < S; j++) {
                picture[i][j] = lineOfPicture.charAt(j);
            }
        }

        // min distance 구하기
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < S; i++) {
            boolean isStart = false;
            int distance = 0;
            for (int j = 0; j < R; j++) {
                if (picture[j][i] == '#') isStart = false;
                if (isStart && picture[j][i] == '.') distance++;
                if (picture[j][i] == 'X') {
                    distance = 0;
                    isStart = true;
                }
            }

            if(minDistance > distance && distance != 0) {
                minDistance = distance;
            }
        }



        // min distance 만큼 잘라서 붙이기
        for (int i = R-1; i >= 0; i--) {
            for (int j = S-1; j >= 0; j--) {
                if(picture[i][j] == 'X') {
                    picture[i+minDistance][j] = 'X';
                    picture[i][j] = '.';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // 출력
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                sb.append(picture[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

}