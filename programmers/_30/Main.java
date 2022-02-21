package programmers._30;

import java.util.Arrays;
import java.util.Scanner;

// 체육복
class Main {

    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;

        int[] check = new int[n + 1];
        Arrays.fill(check, 1);

        // 체육복 갯수를 초기화
        for(int number : lost) {
            check[number] -= 1;
        }
        for(int number : reserve) {
            check[number] += 1;
        }

        // 체육복을 빌려주는 로직
        for(int i = 1; i < n + 1; i++) {
            if(check[i] == 0) {
                if(i != 1 && check[i - 1] == 2) {
                    check[i]++;
                    check[i - 1]--;
                }else if(i != n && check[i + 1] == 2) {
                    check[i]++;
                    check[i + 1]--;
                }
            }
        }

        // 체육 가능한 사람 카운트
        for(int i = 1; i < n + 1; i++) {
            if(check[i] >= 1) count += 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);


        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};

        System.out.println(T.solution(n, lost, reserve));
    }


}
