package inflearn.ch2_Array._12;
import java.util.*;

// 2-12. 멘토링
class Main {

    public int solution(int n, int m, int[][] arr) {
        
        int answer = 0;

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                boolean check = true;
                for(int t = 1 ; t <= m ; t++) {
                    int iRank = 0;
                    int jRank = 0;
                    for(int r = 1 ; r <= n ; r++) {
                        if(arr[t][r] == i) iRank = r;
                        if(arr[t][r] == j) jRank = r;
                    }
                    if(iRank >= jRank) check = false;
                }
                if(check == true) answer++;
            }
        }


        return answer;

    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[m+1][n+1];

        for(int i = 1 ; i <= m ; i++) {
            for(int j = 1; j <= n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
       System.out.println(T.solution(n, m, arr));
       
    }
}
