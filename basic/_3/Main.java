package basic._3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 정렬
 */
class Main {
    public static void main(String[] args) {
        ArrayList<Object> arr = new ArrayList<>(
                List.of(List.of("b", 1, "나"),
                        List.of("c", 2, "라"),
                        List.of("a", 3, "다"),
                        List.of("a", 7, "가"),
                        List.of("c", 3, "가")));

        arr.stream().forEach(System.out::println);

        // TODO. 정렬 구현

        // 가장 앞 요소로 내림차순 정렬


        // 두 번째 요소로 내림차순 정렬


        // 첫 번째, 두 번째 요소로 오름차순 정렬

    }
}
