package programmers._6;

import java.util.Scanner;

// 멀쩡한 사각형
class Main {

    // 유클리드 호제법
    public long GCD(long a, long b) {

        while(b != 0) {
            long c = a % b;
            a = b;
            b = c;
        }

        return a;
    }

    public long solution(int w, int h) {

        // 정답을 long 타입으로 return하기 때문에 미리 형변환하여 계산
        long longW = w;
        long longH = h;

        long gcd = GCD(longW, longH);
        long answer = longW * longH - (longW + longH - gcd);

        return answer;
    }



    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int w = 8;
        int h = 12;

        System.out.println(T.solution(w, h));
    }
}
