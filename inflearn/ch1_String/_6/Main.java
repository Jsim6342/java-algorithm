package inflearn.ch1_String._6;
import java.util.*;

// 1-6. 중복 문제 제거
class Main {

    public String solution(String input) {
        
        String answer = "";

        char[] charArray = input.toCharArray();
        
        Set<Character> set = new LinkedHashSet<>();

        for (char x : charArray) {
            if(set.add(x)==true) answer += x;
        }

        return answer;
      
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(T.solution(input));
        
    }
}
