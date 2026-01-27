package ally.recursion._2;

import java.util.Scanner;

/**
 * 문제: 백준 4779번. 칸토어 집합
 * 링크: https://www.acmicpc.net/problem/4779
*/
class Main {
    static int[] memo;

    public int solution(int number) {
        return fibo(number);
    }

    public int fibo(int number) {
        // 최초 array 초기화
        if(memo == null) {
            memo = new int[number + 1];
        }

        // 종료조건
        if (number == 0) return 0;
        if (number == 1) return 1;
        if (number == 2) return 1;

        // 메모이제이션
        if(memo[number] != 0) {
            return memo[number];
        }

        // 반복조건
        memo[number] = fibo(number - 1) + fibo(number - 2);
        return memo[number];
    }

//    public int fibo(int number) {
//        // 1. 함수 진입 로그
//        System.out.println("fibo(" + number + ") 시작");
//
//        // 종료조건
//        if (number == 1 || number == 2) {
//            System.out.println("-> fibo(" + number + ")는 1 리턴 (종료)");
//            return 1;
//        }
//
//        // 반복조건
//        // 계산 과정을 보기 위해 바로 return하지 않고 변수에 담습니다.
//        int result = fibo(number - 1) + fibo(number - 2);
//
//        // 2. 계산 완료 로그
//        System.out.printf("-> fibo(%d) 계산 끝: fibo(%d) + fibo(%d) = %d\n",
//                number, number - 1, number - 2, result);
//
//        return result;
//    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.println(T.solution(input));
        sc.close();
    }
}
