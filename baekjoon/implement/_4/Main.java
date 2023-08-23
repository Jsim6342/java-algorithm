package baekjoon.implement._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 문제: 백준 20053번. 최소, 최대 2
 * 링크: https://www.acmicpc.net/problem/20053
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String N = br.readLine();

            List<Integer> numbers = Arrays.stream(br.readLine().split(" "))
                    .map((n) -> Integer.parseInt(n))
                    .collect(Collectors.toList()); // JDK16 이상에서 toList();로 대체 가능.

            Integer maxNumber = numbers.stream().max(Integer::compareTo).get();
            Integer minNumber = numbers.stream().min(Integer::compareTo).get();

            System.out.println(minNumber + " " + maxNumber);

        }
    }
}
