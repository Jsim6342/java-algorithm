package basic._3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 정렬
 * Class를 활용한 정렬
 */
public class Main2 {

    public static void main(String[] args) {

        ArrayList<Data> arr = new ArrayList<>();
        arr.add(new Data("b", 1, "나"));
        arr.add(new Data("c", 2, "라"));
        arr.add(new Data("a", 3, "다"));
        arr.add(new Data("a", 7, "가"));
        arr.add(new Data("c", 3, "가"));

        arr.stream().forEach(System.out::println);
        System.out.println("====================");

        // 가장 앞 요소로 내림차순 정렬
        arr.sort((a,b) -> b.en.compareTo(a.en));
        arr.stream().forEach(System.out::println);
        System.out.println("====================");

        // 두 번째 요소로 내림차순 정렬
        arr.sort((a,b) -> Integer.compare(b.num, a.num));
        arr.stream().forEach(System.out::println);
        System.out.println("====================");


        // 첫 번째, 두 번째 요소로 오름차순 정렬
        arr.sort((a,b) -> {
            int res = a.en.compareTo(b.en);
            if(res != 0) return res;
            return Integer.compare(a.num, b.num);
        });
        arr.stream().forEach(System.out::println);


        // 배열 정렬
        Integer[] array = new Integer[]{1, 3, 3, 4, 5, 7, 9, 10, 11, 13, 13, 16};
        Arrays.sort(array); // 오름차순
        Arrays.sort(array, Comparator.reverseOrder()); // 내림차순
        Arrays.sort(array, (a,b) -> Integer.compare(b, a)); // 오름차순
    }
}

class Data {
    String en;
    int num;
    String ko;

    public Data(String en, int num, String ko) {
        this.en = en;
        this.num = num;
        this.ko = ko;
    }

    @Override
    public String toString() {
        return "Data{" +
                "en='" + en + '\'' +
                ", num=" + num +
                ", ko='" + ko + '\'' +
                '}';
    }
}
