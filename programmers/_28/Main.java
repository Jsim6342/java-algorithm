package programmers._28;

import java.util.Scanner;

// 내적
class Main {

    public int solution(int[] a, int[] b) {
        int result = 0;
        for(int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);


        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};


        System.out.println(T.solution(a, b));
    }


}
