package inflearn.ch6_Sorting_Searching._1;
import java.util.*;

// 6-1. 선택 정렬
class Main {

    public int[] solution(int n, int[] arr) {

        
        for(int i = 0; i < n ; i++) {
            int minIdx = i;
            for(int j = i + 1; j < n ; j++) {
                if(arr[minIdx] > arr[j]) minIdx = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
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
