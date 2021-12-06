package inflearn.ch1_String._5;
import java.util.*;

// 1-5. 특정 문자 뒤집기
class Main {

    public String solution(String input) {
        
        int lt = 0;
        int rt = input.length()-1;

        char[] charArray = input.toCharArray();
        while(lt < rt) {
            
            if(!checkAlphabet(charArray[lt])) lt++;
            else if (!checkAlphabet(charArray[rt])) rt--;
            else {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }
            
        }

        return String.valueOf(charArray);
    }

    private boolean checkAlphabet(char tmp) {
        return 65 <= tmp && tmp <= 90 || 97 <= tmp && tmp <= 122;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(T.solution(input));
        
    }
}
