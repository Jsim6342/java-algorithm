package inflearn.ch6_Sorting_Searching._6;
import java.util.*;

// 6-6. 장난꾸러기
class Main {

    public ArrayList<Integer> solution(int n, int[] arr) {
        
        ArrayList<Integer> answer = new ArrayList<>();

        int[] preArr = new int[n];
        for(int i = 0; i < n; i++) preArr[i] = arr[i];

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            if(preArr[i] != arr[i]) {
                answer.add(i + 1);
            }
        }
        
        return answer;
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
