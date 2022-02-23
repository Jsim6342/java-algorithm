package programmers._32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// 행렬 테두리 회전하기
class Main {

    public int[] solution(int rows, int columns, int[][] queries) {

        ArrayList<Integer> result = new ArrayList<>();

        // board 생성
        int[][] board = new int[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++){
                board[i][j] = (columns * i) + j + 1;
            }
        }

        // 회전 로직
        for(int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;

            int temp = board[x1][y1];
            int min = temp;

            for (int i = x1; i < x2; i++) {
                board[i][y1] = board[i + 1][y1];
                min = Math.min(min, board[i][y1]);
            }

            for (int i = y1; i < y2; i++) {
                board[x2][i] = board[x2][i + 1];
                min = Math.min(min, board[x2][i]);
            }

            for (int i = x2; i > x1; i--) {
                board[i][y2] = board[i - 1][y2];
                min = Math.min(min, board[i][y2]);
            }

            for (int i = y2; i > y1; i--) {
                board[x1][i] = board[x1][i - 1];
                min = Math.min(min, board[x1][i]);
            }
            board[x1][y1 + 1] = temp;

            result.add(min);
        }

        Integer[] integers = result.toArray(new Integer[0]);
        int[] answer = Arrays.stream(integers).mapToInt(i -> i).toArray();

        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        System.out.println(T.solution(rows, columns, queries));
    }


}
