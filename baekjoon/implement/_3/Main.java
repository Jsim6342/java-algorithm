package baekjoon.implement._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 백준 1212번. 8진수 2진수
 * 링크: https://www.acmicpc.net/problem/1212
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputNumber = br.readLine();

        StringBuilder sb = new StringBuilder();
        String[] binaryNumbers = {"000","001","010","011","100","101","110","111"};

        sb.append(Integer.toBinaryString(Character.getNumericValue(inputNumber.charAt(0))));
        for(int i = 1; i < inputNumber.length(); i++) {
            char number = inputNumber.charAt(i);
            sb.append(binaryNumbers[Character.getNumericValue(number)]);
        }

        System.out.println(sb.toString());
    }

}
