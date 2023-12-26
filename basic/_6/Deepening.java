package basic._6;

import java.util.Arrays;

/**
 * 프로그래머스 문제
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43238
 * [해설]
 * - 기본적으로 time을 기준으로 N번 탐색하면 최소 시간을 구할 수 있다.
 * - 하지만 time의 범위가 최대 10억까지이기 때문에 N번 탐색으로는 1초 이상이 소요된다.
 * - 따라서 O(N) 이하의 알고리즘을 떠올려야 하는데, 이중 이분탐색 O(logN) 선택.
 * - time을 기준으로 lt, rt 범위를 잡아 탐색. mid time 값에 검사받은 people을 카운트해서 n명 이상이 되었는지 판별하며 lt, rt를 조정
 * - O(logN) 시간복잡도이기 때문에 10억 범위는 30번 안에 풀린다.
 */

public class Deepening {

    public static void main(String[] args) {
        long result = solution(6, new int[]{7, 10});
        System.out.println(result);
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        long lt = 0L;
        long rt = (long) Arrays.stream(times).max().getAsInt() * n;


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

}
