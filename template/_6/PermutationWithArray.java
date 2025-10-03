package template._6;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 순열 정리
 * 순열은 주어진 n개의 원소 중에서 r개를 선택하여 순서를 고려하여 배열하는 방법의 수 를 의미
 */
public class PermutationWithArray {

    public static List<List<Integer>> permute(int[] nums, int r) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(r, new ArrayList<>(), nums, visited, ans);
        return ans;
    }

    private static void backtrack(int r, List<Integer> curr, int[] nums, boolean[] visited, List<List<Integer>> ans) {
        if (curr.size() == r) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                curr.add(nums[i]);
                visited[i] = true;
                backtrack(r, curr, nums, visited, ans);
                curr.remove(curr.size() - 1);
                visited[i] = false; // Backtracking: 원래 상태로 되돌리기
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int r = 2;
        List<List<Integer>> result = permute(nums, r);
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}