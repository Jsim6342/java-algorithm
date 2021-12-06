package inflearn.ch2_Array._10;
import java.util.*;

// 2-10. 봉우리
class Main {

    public int solution(int n, int[][] arr) {
        int answer = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1; j <= n ; j++) {
                if(isMountainTop(arr, x, y, i, j)) answer += 1;
            }
        }

        return answer;

    }

    private boolean isMountainTop(int[][] arr, int[] x, int[] y, int i, int j) {
        for(int k = 0; k < 4; k++) {
            if(arr[i][j] <= arr[i + x[k]][j + y[k]]) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n+2][n+2];

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1; j <= n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
       System.out.println(T.solution(n, arr));
       
    }
}
