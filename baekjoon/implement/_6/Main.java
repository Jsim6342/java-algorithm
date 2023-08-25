package baekjoon.implement._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


/**
 * 문제: 백준 2729번. 이진수 덧셈
 * 링크: https://www.acmicpc.net/problem/2729
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] BinaryNumbers = br.readLine().split(" ");
            String binaryNumber1 = BinaryNumbers[0];
            String binaryNumber2 = BinaryNumbers[1];

            BigInteger decimalNumber1 = new BigInteger(binaryNumber1, 2);
            BigInteger decimalNumber2 = new BigInteger(binaryNumber2, 2);

            String result = decimalNumber1.add(decimalNumber2).toString(2);
            System.out.println(result);
        }
    }
}
