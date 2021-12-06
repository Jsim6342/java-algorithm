package inflearn.ch1_String._11;
import java.util.*;

// 1-11. 문자열 압축
class Main {

    public String solution(String input) {

         StringBuilder sb = new StringBuilder();

        int cnt = 1;
        for(int i = 0 ; i < input.length() - 1 ; i++) {
            if(input.charAt(i) == input.charAt(i+1)) {
                cnt++;
            }else {
                sb.append(input.charAt(i)).append(cnt);
                cnt = 1;
            }
        }

        // 마지막 부분 처리
        if(cnt == 1) {
            sb.append(input.charAt(input.length()-1));
        }else {
            sb.append(input.charAt(input.length()-1)).append(cnt);
        }

        return sb.toString().replace("1", "");
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(T.solution(input));
    }
}
