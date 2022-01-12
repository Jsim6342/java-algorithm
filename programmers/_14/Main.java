package programmers._14;

import java.util.*;


class Main {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] words = s.toCharArray();

        for (Character word : words) {
            if(stack.size() == 0) {
                stack.add(word);
                continue;
            }
            if(stack.peek() == word) stack.pop();
            else stack.add(word);
        }

        if(stack.size() == 0) return 1;
        else return 0;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s ="baabaa";

        System.out.println(T.solution(s));
    }


}
