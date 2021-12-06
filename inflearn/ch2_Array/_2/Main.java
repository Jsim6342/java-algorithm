package inflearn.ch2_Array._2;
import java.util.*;

// 2-2. 보이는 학생
class Main {

    public int solution(int n, int[] arr) {
        int answer = 0;

        int max = Integer.MIN_VALUE;

        for(int height : arr) {
            if(height > max) {
                max = height;
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
