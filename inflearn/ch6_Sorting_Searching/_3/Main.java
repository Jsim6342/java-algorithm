package inflearn.ch6_Sorting_Searching._3;
import java.util.*;

// 6-3. 삽입 정렬
class Main {

    public int[] solution(int n, int[] arr) {

        
        for(int i = 1; i < n ; i++) {
            int temp = arr[i];
            int j;
            for(j = i - 1; j >= 0; j--) {
                if(arr[j] > temp) arr[j + 1] = arr[j];
                else break;
            }
            // j for문이 다 끝난 후, j + 1 지점에 temp 값을 넣는다.
            arr[j + 1] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for(int x : T.solution(n, arr)) System.out.print(x + " ");

    }
}
