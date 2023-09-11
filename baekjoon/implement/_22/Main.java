package baekjoon.implement._22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제: 백준 18311번. 왕복
 * 링크: https://www.acmicpc.net/problem/18311
 */
class Main {

    static int N;
    static long K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        K = Long.parseLong(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Long> distances = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            distances.add(Long.parseLong(st2.nextToken()));
        }

        long nowDistance = 0;
        int course = 0;

        for (int i = 0; i < distances.size(); i++) {
            course += 1;
            if (nowDistance <= K && K < nowDistance + distances.get(i)) {
                System.out.println(course);
                return;
            }
            nowDistance += distances.get(i);
        }
        for (int i = distances.size() - 1; i >= 0; i--) {
            if (nowDistance <= K && K < nowDistance + distances.get(i)) {
                System.out.println(course);
                return;
            }
            course -= 1;
            nowDistance += distances.get(i);
        }


    }


}