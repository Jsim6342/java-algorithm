package programmers._21;

import java.util.*;

// 로또의 최고 순위와 최저 순위
class Main {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int sameNumber = 0;
        int zeroNumber = 0;

        // 같은 번호, 0 번호 탐색
        for(int i = 0; i < 6; i++) {
            if(lottos[i] == 0) {
                zeroNumber++;
                continue;
            }

            for(int j = 0; j < 6; j++) {
                if(lottos[i] == win_nums[j]) {
                    sameNumber++;
                    break;
                }
            }
        }

        // 최고, 최저 순위 계산
        int result = 7 - sameNumber;
        answer[0] = result - zeroNumber;
        answer[1] = result;

        // 예외 처리
        if(sameNumber == 0) answer[1] = 6;
        if(zeroNumber == 0) answer[0] = answer[1];

        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);


        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        System.out.println(T.solution(lottos, win_nums));
    }


}
