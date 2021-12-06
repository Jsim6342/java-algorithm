package inflearn.ch1_String._12;
import java.util.*;

// 1-12. 암호
class Main {

    public String solution(int num, String input) {

        String answer = "";

        while(num-- > 0) {

            answer += decoding(input);
            input = input.substring(7);
        }
        
        return answer;

    }

    private char decoding(String input) {
        StringBuilder sb = new StringBuilder();

        for(char x : input.substring(0, 7).toCharArray()) {
            if(x=='#') sb.append(1);
            if(x=='*') sb.append(0);
        }
        
        return (char)Integer.parseInt(sb.toString(), 2);
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        String input = sc.next();
        System.out.println(T.solution(num, input));
    }
}
