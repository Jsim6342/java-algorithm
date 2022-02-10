package programmers._22;

import java.util.Scanner;

// 신규 아이디 추천
class Main {

    public String solution(String new_id) {

        // 1단계
        String step1 = new_id.toLowerCase();

        // 2단계
        char[] charArray2 = step1.toCharArray();
        StringBuffer br1 = new StringBuffer();
        for(char word : charArray2) {
            if((word >= 'a' && word <= 'z') || (word >= '0' && word <= '9') ||
                    word == '-' || word == '_' || word == '.') {
                br1.append(word);
            }
        }
        String step2 = br1.toString();

        // 3단계
        char[] charArray3 = step2.toCharArray();
        StringBuffer br2 = new StringBuffer();
        for(int i = 0; i < step2.length() - 1; i++) {
            if(charArray3[i] == '.' && charArray3[i+1] == '.') {
                continue;
            }
            br2.append(charArray3[i]);
        }
        br2.append(charArray3[step2.length() - 1]);
        String step3 = br2.toString();

        // 4단계
        String step4 = step3;
        if (step4.length() > 0) {
            if (step4.charAt(0) == '.') {
                step4 = step4.substring(1, step4.length());
            }
        }
        if (step4.length() > 0) {
            if (step4.charAt(step4.length() - 1) == '.') {
                step4 = step4.substring(0, step4.length() - 1);
            }
        }

        // 5단계
        String step5 = step4;
        if(step5.length() == 0) {
            step5 = "a";
        }

        // 6단계

        String step6 = step5;
        if(step6.length() >= 16) {
            step6 = step6.substring(0, 15);

            if(step6.charAt(step6.length() - 1) == '.') {
                step6 = step6.substring(0, step6.length() - 1);
            }

        }

        // 7단계
        String step7 = step6;
        if(step7.length() <= 2) {
            while(step7.length() <= 2) {
                step7 += step7.charAt(step7.length() - 1);
            }
        }

        return step7;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);


        String new_id = "...!@BaT#*..y.abcdefghijklm";

        System.out.println(T.solution(new_id));
    }


}
