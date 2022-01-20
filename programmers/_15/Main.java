package programmers._15;

import java.util.Scanner;
import java.util.Stack;

// 괄호 변환
class Main {

    public String dfs(String w) {
        if(w.length() == 0) return "";

        int countA = 0;
        int countB = 0;

        StringBuffer u = new StringBuffer();
        StringBuffer v = new StringBuffer();

        int open = 0;
        for (int i = 0; i < w.length(); i++) {

            if(w.charAt(i) == '(') open++;
            else open--;

            if(open == 0) {
                u.append(w.substring(0, i + 1));
                v.append(w.substring(i + 1, w.length()));

                if(check(u.toString())) {
                    u.append(dfs(v.toString())).toString();
                }
                else {
                    StringBuffer br = new StringBuffer();
                    br.append("(");
                    br.append(dfs(v.toString()));
                    br.append(")");
                    br.append(reverse(u.toString()));

                    return br.toString();
                }
                break;
            }
        }
        return u.toString();
    }

    public StringBuffer reverse(String u) {

        StringBuffer br = new StringBuffer();
        for (int i = 1; i < u.length() - 1; i++) {
            if(u.charAt(i) == '(') br.append(")");
            else br.append("(");
        }
        return br;
    }


    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for(char x : s.toCharArray()) {
            if(stack.empty() && x == '(') {
                stack.add(x);
                continue;
            }
            if(stack.empty() && x == ')') return false;
            if(x == '(') stack.add(x);
            if(x == ')') stack.pop();
        }

        if(stack.empty()) return true;
        return false;
    }

    public String solution(String p) {
        if(check(p)) return p;
        return dfs(p);
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String p ="()))((()";

        System.out.println(T.solution(p));
    }


}
