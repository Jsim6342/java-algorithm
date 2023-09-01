package baekjoon.implement._14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 문제: 백준 20291번. 파일 정리
 * 링크: https://www.acmicpc.net/problem/20291
 */
class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Map<String, Integer> extensionMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String extension = br.readLine().split("\\.")[1];
            extensionMap.put(extension, extensionMap.getOrDefault(extension, 0) + 1);
        }

        StringBuffer sb = new StringBuffer();
        extensionMap.entrySet().forEach(entry -> {
            sb.append(entry.getKey() + " " + entry.getValue() + "\n");
        });

        System.out.println(sb);

    }


}