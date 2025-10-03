package template._6;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 조합 정리
 * 조합은 주어진 n개의 원소 중에서 r개를 선택하되, 원소의 순서를 고려하지 않는 경우를 의미
 */
public class CombinationGenerator {
    public static List<List<Integer>> combine(int n, int r) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, new ArrayList<>(), n, r, ans);
        return ans;
    }

    private static void backtrack(int start, List<Integer> curr, int n, int r, List<List<Integer>> ans) {
        if (curr.size() == r) {
            ans.add(new ArrayList<>(curr)); // 정답 저장
            return;
        }

        for (int i = start; i <= n; i++) { // 중복 방지를 위해 `start`부터 탐색
            curr.add(i);
            backtrack(i + 1, curr, n, r, ans); // 다음 숫자는 현재 숫자보다 커야 함
            curr.remove(curr.size() - 1); // Backtracking: 원래 상태로 되돌리기
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int r = 2;
        List<List<Integer>> result = combine(n, r);
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }
}
