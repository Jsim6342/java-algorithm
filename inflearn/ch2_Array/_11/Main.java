package inflearn.ch2_Array._11;
import java.util.*;

// 2-11. 임시 반장 구하기
class Main {

    public int solution(int n, int[][] arr) {
        
        int answer = 0;
        int maxNum = Integer.MIN_VALUE;
        
        for(int i = 1 ; i <= n ; i++) {
            int cnt = 0;
            for(int j = 1 ; j <= n ; j++) {
                for(int k = 1 ; k <= 5 ; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    } 
                }
            }
            if(cnt > maxNum) {
                maxNum = cnt;
                answer = i;
            }
        }

        return answer;

    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n+1][6];

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1; j <= 5 ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
       System.out.println(T.solution(n, arr));
       
    }
}
