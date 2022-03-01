package programmers._38;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 두 개 뽑아서 더하기
class Main {

    public Set<Integer> solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int[] numbers = {2,1,3,4,1};

        System.out.println(T.solution(numbers));
    }


}
