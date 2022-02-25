package programmers._34;

import java.util.*;

// 약수의 개수와 덧셈
class Main {

    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
            if(calculate(i) % 2 == 0) {
                answer += i;
            }else {
                answer -= i;
            }
        }
        return answer;
    }

    public int calculate(int number) {
        Set<Integer> count = new HashSet<>();
        for(int i = 1; i <= number; i++) {
            if(number % i == 0) {
                count.add(i);
                count.add(number / i);
            }
        }
        return count.size();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int left = 13;
        int right = 17;

        System.out.println(T.solution(left, right));
    }


}
