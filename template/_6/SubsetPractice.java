package template._6;


import java.util.ArrayList;
import java.util.List;

/**
 * Java 부분집합 정리
 * 부분집합은 주어진 집합에서 원소를 선택하여 만들 수 있는 모든 경우의 집합을 의미
 */
public class SubsetPractice {

    public static void main(String[] args) {
        int n = 3;
        List<List<Integer>> result1 = subsetWithRange(n);
        for (List<Integer> subset : result1) {
            System.out.println(subset);
        }

        System.out.println("==================================================");

        int[] nums = {1, 2, 3};
        List<List<Integer>> result2 = subsetWithArray(nums);
        for (List<Integer> subset : result2) {
            System.out.println(subset);
        }
    }

    // 범위로 받아 부분집합 뽑기
    public static List<List<Integer>> subsetWithRange(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrackWithRange(1, new ArrayList<>(), n, ans);
        return ans;
    }

    // 범위로 받아 부분집합 뽑기 백트래킹
    private static void backtrackWithRange(int start, List<Integer> curr, int n, List<List<Integer>> ans) {
        // todo. 현재 부분집합을 저장
        // todo. 탐색 및 원래 백트래킹
    }

    // 배열로 받아 부분집합 뽑기
    public static List<List<Integer>> subsetWithArray(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrackWithArray(0, new ArrayList<>(), nums, ans);
        return ans;
    }

    // 배열로 받아 부분집합 뽑기 백트래킹
    private static void backtrackWithArray(int start, List<Integer> curr, int[] nums, List<List<Integer>> ans) {
        // todo. 현재 부분집합을 저장
        // todo. 탐색 및 원래 백트래킹
    }

}
