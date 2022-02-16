package programmers._25;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

// 크레인 인혁뽑기 게임
class Main {

    public int solution(int[][] board, int[] moves) {

        int result = 0;

        // 바구니 역할을 하는 Stack 생성
        Stack<Integer> basket = new Stack<>();

        // moves를 탐색하며 인형뽑기를 수행
        for(int move: moves) {
            for(int i = 0; i < board.length; i++) {

                // 0이 아닌 지점에서 로직 수행
                if(board[i][move - 1] != 0) {

                    // 바구니에 같은 값이 있을 경우 스택 상단 값을 없애고, 카운트
                    if(!basket.empty() && basket.peek() == board[i][move - 1]) {
                        basket.pop();
                        result += 2;
                        board[i][move - 1] = 0;
                        break;
                    }

                    // 값을 바구니에 넣고, 0으로 바꿔준다.
                    basket.push(board[i][move - 1]);
                    board[i][move - 1] = 0;
                    break;
                }
            }

        }

        return result;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);


        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(T.solution(board, moves));
    }


}
