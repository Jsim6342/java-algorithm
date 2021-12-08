package inflearn.ch3_TwoPointer_SlidingWindow._6;
import java.util.*;

// 3-5. 연속된 자연수의 합
class Main {

    public int solution(int n, int k, int[] arr) {

        int answer = 0;

        int lt = 0;
        int rt = 0;

        int cnt = k;
        
        while(rt < n) {
            if(cnt == 0) {
                int sum = rt - lt;
                if(sum > answer) answer = sum;
            }

            rt++;
            if(rt < n && arr[rt] == 0) {
                cnt--;
            }

            if(cnt < 0) {
                while(cnt < 0) {
                    lt++;
                    if(arr[lt] == 0) {
                        cnt++;
                    }
                }
            }
    
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
