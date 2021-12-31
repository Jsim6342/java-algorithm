package programmers._1;

import java.util.Scanner;

// 문자열 압축
class Main {

    public int solution(String s) {
        int answer = s.length();
        int len = s.length() / 2 + 1;
        for(int i = 1; i <= len; i++) {
            String before = "";
            StringBuffer br = new StringBuffer();
            int count = 1;
            for(int j = 0; j < s.length();) {
                int start = j;
                j = j + i <= s.length() ? j + i : s.length();
                String temp = s.substring(start, j);
                if (temp.equals(before)) count++;
                else {
                    if (count == 1) {
                        br.append(before);
                    }
                    else {
                        br.append(count + before);
                        count = 1;
                    }
                    before = temp;
                }
            }
            if(count == 1) br.append(before);
            else{
                br.append(count + before);
            }
            answer = Math.min(answer, br.toString().length());
        }
        return answer;
    }




    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s = "abcabcabcabcdededededede";
        System.out.println(T.solution(s));
    }
}
