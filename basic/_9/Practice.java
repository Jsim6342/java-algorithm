package basic._9;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 에라토스테네스의체
 * 1 ~ 120의 수 중에서 소수 판별
 */
public class Practice {
    public static void main(String[] args) {
        int N = 120;
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(N); i++) {
            if (!isPrime[i]) continue;
            for (int j = i * 2; j < N; j += i) {
                isPrime[j] = false;
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            System.out.println(isPrime[i]);
            if(isPrime[i]) count += 1;
        }
        System.out.println(count);
    }
}
