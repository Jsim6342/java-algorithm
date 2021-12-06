package inflearn.ch1_String._9;
import java.util.*;

// 1-9. 숫자만 추출
class Main {

    public int solution(char[] input) {

        StringBuilder sb = new StringBuilder();

        for (char x : input) {
            if(!Character.isAlphabetic(x)) sb.append(x);
        }

        return Integer.valueOf(sb.toString());
    
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        System.out.println(T.solution(input));
        
    }
}
