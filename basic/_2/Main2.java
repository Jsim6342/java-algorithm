package basic._2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 조합
 * 1 ~ 10까지 3개의 수를 조합 뽑기 전체 리스트 출력
 * Set 자료구조를 활용한 방법
 * Java Set은 List 데이터가 완전히 동일하면 같은 데이터로 인식
 */
public class Main2 {

    static List<Integer> choose = new ArrayList<>();
    static Set<List<Integer>> result = new HashSet<>();

    static int N = 10;
    static int T = 3;

    public static void main(String[] args) {
        permutation(0);

        result.stream().forEach(System.out::println);
        System.out.println(result.size());
    }

    private static void permutation(int level) {
        if(level == T) {
            result.add(new ArrayList<>(choose.stream().sorted().toList()));
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (choose.contains(i)) continue;
            choose.add(i);
            permutation(level + 1);
            choose.remove(choose.size() - 1);
        }
    }

}