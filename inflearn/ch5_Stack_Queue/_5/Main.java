package inflearn.ch5_Stack_Queue._5;
import java.util.*;

// 5-5. 쇠막대기
class Main {

    public int solution(String input) {

        int answer = 0;

        Stack<Character> stack = new Stack<>();

        char pre = '(';
        for(char x : input.toCharArray()) {
            if(x == '(') {
                stack.push(x);
            }
            if(x == ')') {
                stack.pop();
                if(pre == '(') answer += stack.size();
                if(pre == ')') answer += 1;
            }

            pre = x;
        }


        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        System.out.print(T.solution(input));


    }
}
