package template._2;

/**
 * Java 재귀 예시 정리
 * 재귀 구성 요소: 종료조건, 재귀호출
 * 재귀의 시간복잡도 = 재귀 함수 호출 수 x (재귀 함수 하나당) 시간복잡도
 */
class Practice {
    public static void main(String[] args) {
        System.out.println("factorial: " + factorial(5));
        System.out.println("sumNumbers: " + sumNumbers(10));
        System.out.println("reverseString: " + reverseString("abcdefg"));
        System.out.println("fibonacci: " + fibonacci(7));
        System.out.println("sumArray: " + sumArray(new int[]{1,2,3,4,5}, 0));
        System.out.println("isPalindrome: " + isPalindrome("abcba"));
        System.out.println("decimalToBinary: " + decimalToBinary(10));
        System.out.println("binarySearch: " + binarySearch(new int[]{1,2,3,4,5,6,7,8,9,10}, 4, 0, 10));
        hanoi(3,1,3, 1);
        sumRecur(5);

    }

    // 1 ~ n 까지 곱한 값 리턴
    // O(n)
    private static int factorial(int n) {
        // todo. 구현
        return 0;
    }

    // 1 ~ n 까지 더한 값 리턴
    // O(n
    private static int sumNumbers(int n) {
        // todo. 구현
        return 0;
    }

    // 문자열을 뒤집어서 반환
    // 나머지 문자열을 뒤집고 + 첫 글자를 뒤에 붙이기
    private static String reverseString(String s) {
        // todo. 구현
        return "";
    }

    // 피보나치 수열의 n번째 값을 반환
    // O(n^2)
    private static int fibonacci(int n) {
        // todo. 구현
        return 0;
    }

    // 배열의 모든 숫자를 더한 값을 반환
    // 첫 원소 + 나머지 배열의 합
    // O(n
    private static int sumArray(int[] arr, int idx) {
        // todo. 구현
        return 0;
    }

    // 하노이 탑
    // n개의 원판을 시작 기둥에서 목표 기둥으로 옮기는 순서를 출력한다.
    // 시작기둥에 있는 n-1개원판을 보조 기둥으로 옮기기 + 가장 큰 원판(밑에 있던 원판)을 목표 기둥으로 옮기기 + 보조 기둥에 있는 n-1개를 목표 기둥으로 옮기기
    private static void hanoi(int n, int start, int target, int temp) {
        // todo. 구현
    }

    // 회문 판별
    // 문자열이 앞뒤로 같은지 확인한다.
    // O(n^2)
    private static boolean isPalindrome(String s) {
        // todo. 구현
        return false;
    }

    // 10진수를 2진수 문자열로 변환
    private static String decimalToBinary(int n) {
        // todo. 구현
        return "";
    }

    // 이진탐색
    // 정렬된 배열에서 target 값을 찾는다.
    private static int binarySearch(int[] arr, int target, int low, int high) {
        // todo. 구현
        return 0;
    }


    // 재귀 디버깅 예시
    private static int sumRecur(int n) {
        System.out.println("→ 들어감: sumRecur(" + n + ")");  // 진입 로그

        if (n == 1) {
            System.out.println("← base case: return 1");
            return 1;
        }

        int result = n + sumRecur(n - 1);
        System.out.println("← 나옴: sumRecur(" + n + ") = " + result);  // 복귀 로그

        return result;
    }

}
