package inflearn.ch2_Array._3;
import java.util.*;

// 2-3. 가위 바위 보
class Main {

    public String solution(int n, int[] aArray, int[] bArray) {
        StringBuilder br = new StringBuilder();

        for(int i = 0 ; i < n ; i++) {
            int result = aArray[i] - bArray[i];
            if(result == -2 || result == 1) br.append("A");
            if(result == -1 || result == 2) br.append("B");
            if(result == 0) br.append("D");
        }

        return br.toString();
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] aArray = new int[n];
        int[] bArray = new int[n];

        for(int i = 0 ; i < n ; i++)  aArray[i] = sc.nextInt();
    
        for(int i = 0 ; i < n ; i++)  bArray[i] = sc.nextInt();
 
        for(char x : T.solution(n, aArray, bArray).toCharArray())   System.out.println(x);
 
    }
}
