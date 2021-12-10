package inflearn.ch5_Stack_Queue._1;
import java.util.*;

// 5-1. 올바른 괄호
class Main {

    public String solution(String input) {
        
        Stack<Character> stack = new Stack<>();
        for(char x : input.toCharArray()) {
            if(x == '(') stack.push(x);
            try {
            if(x == ')') stack.pop();
            }catch(Exception e) {
                return "NO";
            }
        }

        if(stack.size() == 0) return "YES";
        return "NO";    
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        System.out.print(T.solution(input));


    }
}
