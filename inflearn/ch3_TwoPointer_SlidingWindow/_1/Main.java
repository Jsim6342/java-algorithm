package inflearn.ch3_TwoPointer_SlidingWindow._1;
import java.util.*;
import java.util.stream.Stream;

// 3-1. 두 배열 합치기
class Main {

    public Integer[] solution(int n, Integer[] arrA, Integer[] arrB) {
        
        Integer[] answer = Stream.of(arrA, arrB).flatMap(Stream::of).toArray(Integer[]::new);
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] arrA = new Integer[n];
        for(int i = 0 ; i < n ; i++) arrA[i] = sc.nextInt();
            
        int m = sc.nextInt();
        Integer[] arrB = new Integer[m];
        for(int i = 0 ; i < m ; i++) arrB[i] = sc.nextInt();

        for(Integer x : T.solution(n, arrA, arrB)) {
            System.out.print(x + " ");
        }
    }
}
