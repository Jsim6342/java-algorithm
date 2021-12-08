package inflearn.ch3_TwoPointer_SlidingWindow._3;
import java.util.*;

// 3-3. 최대 매출
class Main {

    public int solution(int n, int k, int[] arr) {

        int sum = 0;
        for(int i = 0 ; i < k ; i++) {
            sum += arr[i];
        }
        int answer = sum;

        for(int i = k ; i < n ; i++) {
            sum -= arr[i-k];
            sum += arr[i];
            if(sum > answer) answer = sum;
        }

        return answer;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
     
        System.out.print(T.solution(n, k, arr));
 
    }
}
