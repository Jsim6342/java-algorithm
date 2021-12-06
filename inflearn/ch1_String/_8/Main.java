package inflearn.ch1_String._8;
import java.util.*;

// 1-8. 유효한 팰린드롬
class Main {

    public String solution(char[] input) {


        StringBuilder sb = new StringBuilder();
        for(char x : input) {
            if(Character.isAlphabetic(x)) sb.append(x);
        }

        if(sb.toString().equals(sb.reverse().toString())) return "YES";
        return "NO";
        
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toUpperCase().toCharArray();
        System.out.println(T.solution(input));
        
    }
}
