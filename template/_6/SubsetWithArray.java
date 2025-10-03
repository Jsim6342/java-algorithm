package template._6;


import java.util.ArrayList;
import java.util.List;

/**
 * Java 부분집합 정리
 * 부분집합은 주어진 집합에서 원소를 선택하여 만들 수 있는 모든 경우의 집합을 의미
 */
public class SubsetWithArray {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, ans);
        return ans;
    }

    private static void backtrack(int start, List<Integer> curr, int[] nums, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr)); // 현재 부분집합을 저장

        for (int i = start; i < nums.length; i++) { // 숫자를 하나씩 추가하며 탐색
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums, ans); // 다음 숫자를 선택
            curr.remove(curr.size() - 1); // Backtracking: 원래 상태로 되돌리기
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
