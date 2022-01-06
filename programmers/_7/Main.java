package programmers._7;

import java.util.Scanner;

// 124 나라의 숫자
class Main {

    public String solution(int n) {

        String answer = "";
        String[] numbers = {"4", "1", "2"};

        while(n != 0) {
            int remainder = n % 3;
            n = n / 3;

            if(remainder == 0) n--;

            answer = numbers[remainder] + answer;
        }

        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = 10;

        System.out.println(T.solution(n));
    }
}
