package inflearn.ch6_Sorting_Searching._8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 6-8. 이분 탐색
class Main {

    public int solution(int n, int m, int[] arr) {

        int answer = 0;
        Arrays.sort(arr);

        int lt = 0;
        int rt = arr.length;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;

            if(m == arr[mid]) return mid + 1;
            if(m > arr[mid]) lt = mid + 1;
            if(m < arr[mid]) rt = mid - 1;

        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
    
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(T.solution(n, m, arr));

    }
}
