package programmers._12;

import java.util.Arrays;
import java.util.Scanner;

// 입국심사
class Main {

    public long solution(int n, int[] times) {
        long answer = 0;
        long lt = 0L;
        long rt = (long)Arrays.stream(times).max().getAsInt() * n;

        while(lt <= rt) {
            long mid = (lt + rt) / 2;
            long people = 0;
            for (int time : times) {
                people += mid / time;
            }

            if(people >= n) {
                answer = mid;
                rt = mid - 1;
            }else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = 6;
        int[] times = {7, 10};

        System.out.println(T.solution(n, times));
    }

}
