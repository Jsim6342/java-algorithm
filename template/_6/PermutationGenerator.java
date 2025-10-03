package template._6;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 순열 정리
 * 순열은 주어진 n개의 원소 중에서 r개를 선택하여 순서를 고려하여 배열하는 방법의 수 를 의미
 */
public class PermutationGenerator {

    public static List<List<Integer>> permute(int n, int r) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];  // 1부터 n까지 숫자를 사용하기 위해 크기를 n+1로 설정
        backtrack(n, r, new ArrayList<>(), visited, ans);
        return ans;
    }

    private static void backtrack(int n, int r, List<Integer> curr, boolean[] visited, List<List<Integer>> ans) {
        if (curr.size() == r) {
            ans.add(new ArrayList<>(curr));  // 정답 저장
            return;
        }

        for (int i = 1; i <= n; i++) {  // 1부터 n까지 숫자 직접 사용
            if (!visited[i]) {  // 방문하지 않은 숫자만 선택
                curr.add(i);
                visited[i] = true;
                backtrack(n, r, curr, visited, ans);
                curr.remove(curr.size() - 1);  // Backtracking: 원래 상태로 되돌리기
                visited[i] = false;  // 방문 체크 해제
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int r = 2;
        List<List<Integer>> result = permute(n, r);
        for (List<Integer> p : result) {
            System.out.println(p);
        }
    }
}
