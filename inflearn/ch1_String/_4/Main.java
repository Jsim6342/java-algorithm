package inflearn.ch1_String._4;
import java.util.*;

// 1-4. 단어 뒤집기
class Main {

    public String solution(String input) {
        StringBuilder sb = new StringBuilder();
        return sb.append(input).reverse().toString();
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int caseNum = Integer.parseInt(sc.nextLine());
        while(caseNum > 0) {
            String input = sc.nextLine();
            System.out.println(T.solution(input));
            caseNum--;
        }
        
    }
}
