package basic._1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 순열
 * 1 ~ 10까지 3개의 수를 순열 뽑기 전체 리스트 출력
 */
class Main {

    static List<Integer> choose = new ArrayList<>();
    static List<List<Integer>> result = new ArrayList<>();
    static int N = 10;
    static int T = 3;

    public static void main(String[] args) {
        permutation(0);

        result.stream().forEach(System.out::println);
        System.out.println(result.size());

    }

    private static void permutation(int level) {
        if(level == T) {
            result.add(new ArrayList<>(choose));
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (choose.contains(i)) continue;
            choose.add(i);
            permutation(level + 1);
            choose.remove(choose.size()-1);
        }
    }
}
