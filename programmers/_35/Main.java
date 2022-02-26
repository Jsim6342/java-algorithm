package programmers._35;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

// 3진법 뒤집기
class Main {

    public int solution(int n) {
        int answer = 0;
        StringBuffer br = new StringBuffer();
        while(n != 0) {
            br.append(n % 3);
            n = n / 3;
        }
        int result = Integer.parseInt(br.toString(), 3);

        return result;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = 45;

        System.out.println(T.solution(n));
    }


}
