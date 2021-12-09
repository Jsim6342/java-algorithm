package inflearn.ch4_HashMap_HashSet_TreeSet._5;
import java.util.*;

// 4-5. K번째 큰 수
class Main {

    public int solution(int n, int k, int[] arr) {
        
        TreeSet<Integer> result = new TreeSet<>();

        for(int i = 0 ; i < n - 2 ; i++) {
            for(int j = i + 1 ; j < n - 1 ; j++) {
                for(int l = j + 1 ; l < n ; l++) {
                    result.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        
        if(result.size() - k < 0) return -1;
        return (int)result.toArray()[result.size() - k];
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();

        System.out.print(T.solution(n, k, arr));

    }
}
