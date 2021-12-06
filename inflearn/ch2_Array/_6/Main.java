package inflearn.ch2_Array._6;
import java.util.*;

// 2-6. 뒤집은 소수
class Main {

    public ArrayList<Integer> solution(int n, String[] arr) {
        
        ArrayList<Integer> primeArr = makePrimeArr(100000);
        ArrayList<Integer> answer = new ArrayList<>();

        for(String num : arr) {
            StringBuilder sb = new StringBuilder();
            int result = Integer.valueOf(sb.append(num).reverse().toString());
            if(primeArr.contains(result)) answer.add(result);
        }
        
        return answer;
    }

    public ArrayList<Integer> makePrimeArr(int n) {

        ArrayList<Integer> answer = new ArrayList<>();
        int[] check = new int[n+1];
        
        for(int i = 2 ; i <= n ; i++) {
            if(check[i]!=1) {
                answer.add(i);
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
        String[] arr = new String[n];
        for(int i = 0 ; i < n ; i++) arr[i] = sc.next();
 
        for(int x : T.solution(n, arr)) System.out.print(x + " ");
 
    }
}
