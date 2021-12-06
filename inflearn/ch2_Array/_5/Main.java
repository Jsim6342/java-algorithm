package inflearn.ch2_Array._5;
import java.util.*;

// 2-5. 소수(에라토스테네스 체)
class Main {

    public int solution(int n) {

        int answer = 0;
        int[] check = new int[n+1];
        
        for(int i = 2 ; i <= n ; i++) {
            if(check[i]!=1) {
                answer += 1;
                int cnt = 1;
                while(i * cnt <= n) {
                    check[i * cnt] = 1;
                    cnt++;
                }
            }
        }   
           
        return answer;

    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
 
        System.out.println(T.solution(n));
 
    }
}
