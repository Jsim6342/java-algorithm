package inflearn.ch1_String._2;
import java.util.*;

// 1-2. 대소문자 변환
class Main {

    public String solution(String input) {
        StringBuilder answer = new StringBuilder();

        for(char word : input.toCharArray()) {
            if(checkIsUpper(word)==true) {
                answer.append(Character.toLowerCase(word));
            }
            if(checkIsUpper(word)==false)
                answer.append(Character.toUpperCase(word));
            }
        

        return answer.toString();
    }

    private boolean checkIsUpper(char word) {
        return Character.isUpperCase(word);
    }

    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(T.solution(input));
    }
}
