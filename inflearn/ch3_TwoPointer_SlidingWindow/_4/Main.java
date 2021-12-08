package inflearn.ch3_TwoPointer_SlidingWindow._4;
import java.util.*;

// 3-4. 연속 부분 수열
class Main {

    public int solution(int n, int m, int[] arr) {

        int answer = 0;

        int lt = 0;
        int rt = 0;

        int sum = arr[0];

        while(lt < n) {
            if(sum == m) {
                answer++;
                sum -= arr[lt];
                lt++;
            }else if(sum < m) {
                    rt++;
                    if(rt == n) break;
                    sum += arr[rt];
            }else {
                sum -= arr[lt];
                lt++;
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
     
        System.out.print(T.solution(n, m, arr));
 
    }
}
