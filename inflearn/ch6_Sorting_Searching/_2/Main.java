package inflearn.ch6_Sorting_Searching._2;
import java.util.*;

// 6-2. 버블 정렬
class Main {

    public int[] solution(int n, int[] arr) {

        
        for(int i = 0; i < n - 1; i++) {;
            for(int j = 0; j < n - i - 1 ; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } 
            }
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
