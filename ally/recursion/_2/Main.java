package ally.recursion._2;

import java.util.Scanner;

/**
 * 문제: 백준 4779번. 칸토어 집합
 * 링크: https://www.acmicpc.net/problem/4779
*/
class Main {
    static StringBuilder answer;

    public void solution(int number) {
        int length = (int) Math.pow(3, number);

        answer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            answer.append("-");
        }

        // 재귀 시작
        fibo(0, length);

        System.out.println(answer);
    }

    public void fibo(int start, int length) {
        // 종료조건
        if(length == 1) {
            return;
        }

        int newSize = length / 3;
        int startIndex = start + newSize;
        int endIndex = start + 2 * newSize;

        for (int i = start + newSize; i < start + 2 * newSize; i++) {
            answer.setCharAt(i, ' ');
        }

        // 왼쪽 구간 재귀
        fibo(start, newSize);

        // 오른쪽 구간 재귀
        fibo(start + 2 * newSize, newSize);
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int input = sc.nextInt();
            T.solution(input);
        }
        sc.close();
    }
}
