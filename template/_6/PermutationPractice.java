package template._6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java 순열 정리
 * 순열은 주어진 n개의 원소 중에서 r개를 선택하여 순서를 고려하여 배열하는 방법의 수 를 의미
 */
public class PermutationPractice {

    public static void main(String[] args) {
        int n = 4;
        int r1 = 2;
        List<List<Integer>> result1 = permuteWithRange(n, r1);
        System.out.println(Arrays.deepToString(result1.toArray()));
        System.out.println("==================================================");

        int[] nums = {1, 2, 3, 4};
        int r2 = 2;
        List<List<Integer>> result2 = permuteWithArray(nums, r2);
        System.out.println(Arrays.deepToString(result2.toArray()));

    }

    // 범위로 받아 순열 뽑기
    public static List<List<Integer>> permuteWithRange(int n, int r) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];  // 1부터 n까지 숫자를 사용하기 위해 크기를 n+1로 설정
        backtrackWithRange(n, r, new ArrayList<>(), visited, ans);
        return ans;
    }

    // 범위로 받아 순열 뽑기 백트래킹
    private static void backtrackWithRange(int n, int r, List<Integer> curr, boolean[] visited, List<List<Integer>> ans) {
        // todo. 종료 조건
        // todo. 방문, visited 갱신 및 원상태 복구
    }

    // 배열로 받아 순열 뽑기
    public static List<List<Integer>> permuteWithArray(int[] nums, int r) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrackWithArray(r, new ArrayList<>(), nums, visited, ans);
        return ans;
    }

    // 배열로 받아 순열 뽑기 백트래킹
    private static void backtrackWithArray(int r, List<Integer> curr, int[] nums, boolean[] visited, List<List<Integer>> ans) {
        // todo. 종료 조건
        // todo. 방문, visited 갱신 및 원상태 복구
    }


}
