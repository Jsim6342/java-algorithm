package basic._10;

/**
 * 유클리드
 * a와 b의 최대공약수 구하기
 * eX) 21, 14의 최대공약수 구하기
 */
public class Practice {
    public static void main(String[] args) {
        int result = GCD(21, 14);
        System.out.println(result);
    }

    private static int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a % b);
    }
}
