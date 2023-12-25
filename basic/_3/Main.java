package basic._3;

import java.util.*;

/**
 * 정렬
 * Class 미활용 정렬
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
        System.out.println("====================");

        // 가장 앞 요소로 내림차순 정렬
        arr.sort((a, b) -> ((List<?>) b).get(0).toString().compareTo(((List<?>) a).get(0).toString()));
        arr.stream().forEach(System.out::println);
        System.out.println("====================");

        // 두 번째 요소로 내림차순 정렬
        arr.sort((a, b) -> Integer.compare((int) ((List<?>) b).get(1), (int) ((List<?>) a).get(1)));
        arr.stream().forEach(System.out::println);
        System.out.println("====================");

        // 첫 번째, 두 번째 요소로 오름차순 정렬
        arr.sort((a, b) -> {
            int cmp = ((List<?>) a).get(0).toString().compareTo(((List<?>) b).get(0).toString());
            if (cmp != 0) {
                return cmp;
            }
            return Integer.compare((int) ((List<?>) a).get(1), (int) ((List<?>) b).get(1));
        });
        arr.stream().forEach(System.out::println);


        // 배열 정렬
        Integer[] array = new Integer[]{1, 3, 3, 4, 5, 7, 9, 10, 11, 13, 13, 16};
        Arrays.sort(array); // 오름차순
        Arrays.sort(array, Comparator.reverseOrder()); // 내림차순

    }
}
