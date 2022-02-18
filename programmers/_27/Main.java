package programmers._27;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// 음양 더하기
class Main {

    public int solution(int[] absolutes, boolean[] signs) {
        int result = 0;
        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i] == true) result += absolutes[i];
            if(signs[i] == false) result -= absolutes[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);


        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};


        System.out.println(T.solution(absolutes, signs));
    }


}
