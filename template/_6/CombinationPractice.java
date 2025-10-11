package template._6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java 조합 정리
 * 조합은 주어진 n개의 원소 중에서 r개를 선택하되, 원소의 순서를 고려하지 않는 경우를 의미
 */
public class CombinationPractice {

    public static void main(String[] args) {

        // 범위로 받아 조합 뽑기.
        int n = 4;
        int r1 = 2;
        List<List<Integer>> result1 = combineWithRange(n, r1);
        System.out.println(Arrays.deepToString(result1.toArray()));
        System.out.println("==================================================");

        // 배열로 받아 조합 뽑기.
        int[] nums = {1, 2, 3, 4};
        int r2 = 2;
        List<List<Integer>> result2 = combineWithArray(nums, r2);
        System.out.println(Arrays.deepToString(result2.toArray()));
    }

    // 범위로 받아 조합 뽑기
    public static List<List<Integer>> combineWithRange(int n, int r) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrackWithRange(1, new ArrayList<>(), n, r, ans);
        return ans;
    }

    // 범위로 받아 조합 뽑기 백트래킹
    private static void backtrackWithRange(int start, List<Integer> curr, int n, int r, List<List<Integer>> ans) {
        // todo. 종료 조건
        // todo. 중복 방지 탐색 및 원상태 복구
    }

    // 배열로 받아 조합 뽑기
    public static List<List<Integer>> combineWithArray(int[] nums, int r) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrackWithArray(0, new ArrayList<>(), nums, r, ans);
        return ans;
    }

    // 배열로 받아 조합 뽑기 백트래킹
    private static void backtrackWithArray(int start, List<Integer> curr, int[] nums, int r, List<List<Integer>> ans) {
        // todo. 종료 조건
        // todo. 중복 방지 탐색 및 원상태 복구
    }


}
