package basic._2;

import java.util.ArrayList;
import java.util.List;

/**
 * 조합
 * 1 ~ 10까지 3개의 수를 조합 뽑기 전체 리스트 출력
 */
class Main {

    static List<Integer> choose = new ArrayList<>();
    static List<List<Integer>> result = new ArrayList<>();

    static int N = 10;
    static int T = 3;

    public static void main(String[] args) {

        combination(0, 0);
        result.stream().forEach(System.out::println);
        System.out.println(result.size());

    }

    private static void combination(int level, int index) {
        if(level == T) {
            result.add(new ArrayList<>(choose));
            return;
        }

        for (int i = index + 1; i < N + 1; i++) {
            choose.add(i);
            combination(level + 1, i);
            choose.remove(choose.size()-1);
        }

    }
}
