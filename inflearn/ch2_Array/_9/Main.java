package inflearn.ch2_Array._9;
import java.util.*;

// 2-9. 격자판 최대합
class Main {

    public int solution(int n, int[][] arr, ArrayList<Integer> answer) {
        
        // 행, 열 합 구하기
        for(int i = 0 ; i < n ; i++) {
            int rowSum = 0;
            int colSum = 0;
            for(int j = 0 ; j < n ; j++){
                rowSum += arr[i][j];
                colSum += arr[j][i];
                
            }
            answer.add(rowSum);
            answer.add(colSum);
        }

        // 대각선 합 구하기
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0 ; i < n ; i++) {
            leftSum += arr[i][i];
            rightSum += arr[i][n-i-1];
        }
        answer.add(leftSum);
        answer.add(rightSum);

        int result = answer.stream().mapToInt(x -> x).max().orElse(0);

        return result;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            int sum = 0;
            for(int j = 0; j < n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
       System.out.println(T.solution(n, arr, answer));
       
    }
}
