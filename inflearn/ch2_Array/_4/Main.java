package inflearn.ch2_Array._4;
import java.util.*;

// 2-4. 피보나치 수열
class Main {

    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;

        for(int i = 1 ; i < n - 1 ; i ++) {
            answer[i+1] = answer[i-1] + answer[i];
        }

        return answer;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
 
        for(int x : T.solution(n)) System.out.print(x + " ");
 
    }
}
