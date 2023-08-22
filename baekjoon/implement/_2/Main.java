package baekjoon.implement._2;

import java.util.Scanner;

/**
 * 문제: 백준 2753번. 윤년
 * 링크: https://www.acmicpc.net/problem/2753
 */
class Main {

    public int solution(int number) {
        if((number % 4 == 0 && number % 100 != 0) || number % 400 == 0) return 1;
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.println(T.solution(input));
    }
}
