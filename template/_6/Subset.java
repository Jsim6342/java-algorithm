package template._6;


import java.util.ArrayList;
import java.util.List;

/**
 * Java 부분집합 정리
 * 부분집합은 주어진 집합에서 원소를 선택하여 만들 수 있는 모든 경우의 집합을 의미
 */
public class Subset {

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
        ans.add(new ArrayList<>(curr)); // 현재 부분집합을 저장

        for (int i = start; i <= n; i++) { // 숫자를 하나씩 추가하며 탐색
            curr.add(i);
            backtrackWithRange(i + 1, curr, n, ans); // 다음 숫자를 선택
            curr.remove(curr.size() - 1); // Backtracking: 원래 상태로 되돌리기
        }
    }

    // 배열로 받아 부분집합 뽑기
    public static List<List<Integer>> subsetWithArray(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrackWithArray(0, new ArrayList<>(), nums, ans);
        return ans;
    }

    // 배열로 받아 부분집합 뽑기 백트래킹
    private static void backtrackWithArray(int start, List<Integer> curr, int[] nums, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr)); // 현재 부분집합을 저장

        for (int i = start; i < nums.length; i++) { // 숫자를 하나씩 추가하며 탐색
            curr.add(nums[i]);
            backtrackWithArray(i + 1, curr, nums, ans); // 다음 숫자를 선택
            curr.remove(curr.size() - 1); // Backtracking: 원래 상태로 되돌리기
        }
    }

}
