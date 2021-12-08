package inflearn.ch3_TwoPointer_SlidingWindow._5;
import java.util.*;

// 3-5. 연속된 자연수의 합
class Main {

    public int solution(int n) {

        int answer = 0;

        int lt = 1;
        int rt = 1;

        int sum = 1;

        while(rt < n) {
            if(sum >= n) {
                if(sum == n ) answer++;
                sum -= lt;
                lt++;
            }else {
                rt++;
                sum += rt;
            }
        }


        return answer;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.print(T.solution(n));
 
    }
}
