package baekjoon.implement._1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 문제: 백준 5597번. 과제 안 내신 분..?
 * 링크: https://www.acmicpc.net/problem/5597
*/
class Main {

    public List<Integer> solution(List<Integer> numbers) {

        List<Integer> intRange = IntStream.range(1, 31)
                .boxed()
                .toList();

        List<Integer> result = intRange.stream()
                .filter((i) -> !numbers.contains(i))
                .sorted()
                .toList();

        return result;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        for(int i = 1; i <= 28; i++) {
            int inputNumber = sc.nextInt();
            numbers.add(inputNumber);
        }

        T.solution(numbers).forEach(System.out::println);

        sc.close();
    }
}
