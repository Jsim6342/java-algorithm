package inflearn.ch3_TwoPointer_SlidingWindow._2;
import java.util.*;

// 3-2. 공통원소 구하기
class Main {

    public ArrayList<Integer> solution(int n, int m, int[] arrA, int[] arrB) {
        
        ArrayList<Integer> answer = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        Arrays.sort(arrA);
        Arrays.sort(arrB);


        while(p1 < n && p2 < m) {

            if(arrA[p1] == arrB[p2]) {
                answer.add(arrA[p1]);
                p1++;
                p2++;
            }
            else if(arrA[p1] > arrB[p2]) p2++;
            else p1++;

        }

        return answer;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arrA = new int[n];
        for(int i = 0 ; i < n ; i++) arrA[i] = sc.nextInt();
            
        int m = sc.nextInt();
        int[] arrB = new int[m];
        for(int i = 0 ; i < m ; i++) arrB[i] = sc.nextInt();

        for(Integer x : T.solution(n, m, arrA, arrB)) {
            System.out.print(x + " ");
        }
    }
}
