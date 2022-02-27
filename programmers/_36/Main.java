package programmers._36;

import java.util.Arrays;
import java.util.Scanner;

// 예산
class Main {

    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for(int cost : d) {
            budget -= cost;
            if(budget < 0) break;
            answer += 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int[] d = {1,3,2,5,4};
        int budget = 9;

        System.out.println(T.solution(d, budget));
    }


}
