package inflearn.ch5_Stack_Queue._2;
import java.util.*;

// 5-2. 괄호문자제거
class Main {

    public String solution(String str) {
        
        String answer = "";

        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()) {
            if(x == '(') {stack.push(x); continue;}
            if(x == ')') {stack.pop(); continue;}

            if(stack.size() == 0) answer += x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.print(T.solution(str));


    }
}
