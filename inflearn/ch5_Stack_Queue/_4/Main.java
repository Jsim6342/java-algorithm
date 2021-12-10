package inflearn.ch5_Stack_Queue._4;
import java.util.*;

// 5-4. 후위식 연산(postfix)
class Main {

    public int solution(String input) {

        Stack<Integer> stack = new Stack<>();

        for(char x : input.toCharArray()) {
            if(Character.isDigit(x)) stack.push(x - 48);
            else {
                int one = stack.pop();
                int two = stack.pop();

                stack.push(operation(x, one, two));
            }
        }


        return stack.peek();
    }

    private int operation(char x, int one, int two) {
        int result = 0;
        if(x == '+') result = two + one;
        if(x == '-') result = two - one;
        if(x == '*') result = two * one;
        if(x == '/') result = two / one;
        return result;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        System.out.print(T.solution(input));


    }
}
