package inflearn.ch10_Dynamic_Programming._3;

import java.util.Arrays;
import java.util.Scanner;

// 10-3. 최대 부분 증가수열
class Main {

    static int n;
    static int[] arr, dy;

    public void solution() {
        dy[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0 ; j--) {
                if(arr[i] > arr[j]) {
                    dy[i] = Math.max(dy[i], dy[j] + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        dy = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.fill(dy, 1);

        T.solution();

        System.out.println(Arrays.stream(dy).max().getAsInt());

    }
}
