package inflearn.ch2_Array._7;
import java.util.*;

// 2-7. 점수 계산
class Main {

    public int solution(int n, int[] arr) {
        
        int answer = 0;
        int bonus = 0;

        for(int score : arr) {
            if(score == 1) {
                bonus += 1;
                answer += bonus;
            }
            if(score == 0) {
                bonus = 0;
            }
        }
        
        return answer;
    }

    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
 
       System.out.println(T.solution(n, arr));
 
    }
}
