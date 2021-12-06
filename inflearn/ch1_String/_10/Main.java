package inflearn.ch1_String._10;
import java.util.*;

// 1-10. 가장 짧은 문자거리
class Main {

    public int[] solution(String input, char target) {

        int[] answer = new int[input.length()];

        int p = 100;
        for(int i = 0; i<input.length(); i++) {
            if(input.charAt(i)==target) {
                p = 0;
                answer[i] = p;
            }else {
                p++;
                answer[i] = p;
            }
        }

        p = 100;
        for(int i = input.length()-1; i>=0; i--) {
            if(input.charAt(i)==target) {
                p = 0;
            }else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char target = sc.next().charAt(0);
        for(int num : T.solution(input, target)) {
            System.out.print(num + " ");
        }
    }
}
