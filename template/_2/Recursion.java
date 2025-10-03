package template._2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Java 재귀 예시 정리
 * 재귀 구성 요소: 종료조건, 재귀호출
 * 재귀의 시간복잡도 = 재귀 함수 호출 수 x (재귀 함수 하나당) 시간복잡도
 */
class Recursion {
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
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 1 ~ n 까지 더한 값 리턴
    // O(n
    private static int sumNumbers(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNumbers(n - 1);
    }

    // 문자열을 뒤집어서 반환
    // 나머지 문자열을 뒤집고 + 첫 글자를 뒤에 붙이기
    private static String reverseString(String s) {
        if (s.length() == 0) {
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    // 피보나치 수열의 n번째 값을 반환
    // O(n^2)
    private static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 배열의 모든 숫자를 더한 값을 반환
    // 첫 원소 + 나머지 배열의 합
    // O(n
    private static int sumArray(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        return arr[idx] + sumArray(arr, idx + 1);
    }

    // 하노이 탑
    // n개의 원판을 시작 기둥에서 목표 기둥으로 옮기는 순서를 출력한다.
    // 시작기둥에 있는 n-1개원판을 보조 기둥으로 옮기기 + 가장 큰 원판(밑에 있던 원판)을 목표 기둥으로 옮기기 + 보조 기둥에 있는 n-1개를 목표 기둥으로 옮기기
    private static void hanoi(int n, int start, int target, int temp) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + start + " to " + target);
            return;
        }
        hanoi(n - 1, start, temp, target);
        System.out.println("Move disk " + n + " from " + start + " to " + target);
        hanoi(n - 1, temp, target, start);

    }

    // 회문 판별
    // 문자열이 앞뒤로 같은지 확인한다.
    // O(n^2)
    private static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;  // 길이 0 또는 1 → 회문
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;  // 양 끝 문자가 다르면 회문 아님
        }
        return isPalindrome(s.substring(1, s.length() - 1));  // 내부 문자열 확인
    }

    // 10진수를 2진수 문자열로 변환
    private static String decimalToBinary(int n) {
        if (n == 0) {
            return "";
        }
        return decimalToBinary(n / 2) + (n % 2);
    }

    // 이진탐색
    // 정렬된 배열에서 target 값을 찾는다.
    private static int binarySearch(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, low, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, high);
        }
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
