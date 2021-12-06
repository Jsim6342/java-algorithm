package inflearn.ch1_String._3;
import java.util.*;

// 1-3. 문장 속 단어
class Main {

    public String solution(String input) {
        String answer = "";

        String[] stringArray = input.split(" ");

        int maxLength = Integer.MIN_VALUE;

        for(String word : stringArray) {

            if(word.length() > maxLength) {
                answer = word;
                maxLength = word.length();
            }
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
