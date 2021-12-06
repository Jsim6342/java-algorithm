package inflearn.ch1_String._7;
import java.util.*;

// 1-7. 회문 문자열
class Main {

    public String solution(char[] input) {
        
        int lt = 0;
        int rt = input.length - 1;

        while(lt < rt) {

            if(input[lt] == input[rt]) {
                lt++;
                rt--;
                continue;
            }
            
            return "NO";
        }
      
        return "YES";
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toUpperCase().toCharArray();
        System.out.println(T.solution(input));
        
    }
}
