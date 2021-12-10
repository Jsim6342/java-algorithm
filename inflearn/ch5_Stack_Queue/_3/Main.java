package inflearn.ch5_Stack_Queue._3;
import java.util.*;

// 5-3. 크레인 인형뽑기(카카오)
class Main {

    public int solution(int n, int[][] board, int m, int[] moves) {
        
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int move : moves) {
            for(int i = 0 ; i < n ; i++) {

                if(board[i][move - 1] != 0) {

                    if(!stack.isEmpty() && stack.peek() == board[i][move - 1]) {
                        answer += 1;
                        stack.pop();
                        board[i][move - 1] = 0;
                        break;
                    }

                    stack.push(board[i][move - 1]);
                    board[i][move - 1] = 0;
                    break;
                }
  
            }

        }

        return answer * 2;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for(int i = 0 ; i < m ; i++) moves[i] = sc.nextInt();

        System.out.print(T.solution(n, board, m, moves));


    }
}
