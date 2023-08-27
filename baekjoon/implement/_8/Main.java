package baekjoon.implement._8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 문제: 백준 2578번. 빙고
 * 링크: https://www.acmicpc.net/problem/2578
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> bingGo = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            bingGo.add(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        for (int i = 0; i < 5; i++) {
            numbers.addAll(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }

        for (int i = 0; i < 25; i++) {
            int nowNumber = numbers.get(i);
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(bingGo.get(j).get(k) == nowNumber) bingGo.get(j).set(k, 0);
                }
            }
            int bingGoCount = checkBingGo(bingGo);
            if(bingGoCount >= 3) {
                System.out.println(i + 1);
                break;
            }
        }

    }

    private static int checkBingGo(List<List<Integer>> bingGo) {
        int bingGoCount = 0;

        for (int i = 0; i < 5; i++) {
            int rowResult = 0;
            int colResult = 0;
            for (int j = 0; j < 5; j++) {
                rowResult += bingGo.get(i).get(j);
                colResult += bingGo.get(j).get(i);
            }
            if (rowResult == 0) bingGoCount += 1;
            if (colResult == 0) bingGoCount += 1;
        }

        int crossResult1 = 0;
        int crossResult2 = 0;
        for (int i = 0; i < 5; i++) {
            crossResult1 += bingGo.get(i).get(i);
            crossResult2 += bingGo.get(i).get((5-1) - i);
        }
        if (crossResult1 == 0) bingGoCount += 1;
        if (crossResult2 == 0) bingGoCount += 1;

        return bingGoCount;
    }

}