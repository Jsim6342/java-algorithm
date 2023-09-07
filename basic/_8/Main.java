package basic._8;

import java.math.BigInteger;

/**
 * DP
 * 일정한 규칙을 갖는 DP 테이블 100번째 값 구하기
 * 1, 2번째 이전 인덱스를 더해서 인덱스를 갱신해 나가는 바텀업 점화식 세우기
 */
class Main {
    public static void main(String[] args) {
        BigInteger[] dp = new BigInteger[100];
        int N = dp.length;

        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(1);

        for (int i = 3; i < N; i++) {
            dp[i] = dp[i - 2].add(dp[i - 1]);
        }

        System.out.println(dp[N - 1]);

    }
}
