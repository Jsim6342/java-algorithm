package baekjoon.implement._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 문제: 백준 14467번. 소가 길을 건너간 이유 1
 * 링크: https://www.acmicpc.net/problem/14467
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cows = new HashMap<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            int cowNumber = inputs.get(0);
            int cowPosition = inputs.get(1);

            if(cows.get(cowNumber) == null) {
                cows.put(cowNumber, cowPosition);
                continue;
            }

            if(cows.get(cowNumber) != cowPosition) {
                count++;
            }

            cows.put(cowNumber, cowPosition);
        }

        System.out.println(count);
    }
}
