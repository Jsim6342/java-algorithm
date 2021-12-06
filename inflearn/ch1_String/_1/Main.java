package inflearn.ch1_String._1;
import java.util.*;

// 1-1. 문자 찾기 문제
class Main {

    public int solution(String contents, char word) {
        int answer = 0;

        String upperContents = contents.toUpperCase();
        char upperWord = Character.toUpperCase(word);

        for(char contentWord : upperContents.toCharArray()) {
            if(contentWord == upperWord) {
                answer += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String contents = sc.next();
        char word = sc.next().charAt(0);

        System.out.println(T.solution(contents, word));
    }
}
