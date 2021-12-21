package inflearn.ch8_DFS_BFS._14;

import java.util.ArrayList;
import java.util.Scanner;

// 8-14. 피자 배달 거리
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Main {
    static int n, m;
    static int[][] board;
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> pizzaStores = new ArrayList<>();
    static ArrayList<Point> pickPizzaStores = new ArrayList<>();
    static ArrayList<Integer> answer = new ArrayList<>();

    public void DFS(int level, int start) {
        if(pickPizzaStores.size() == m) {

            int sum = 0;
            for (int i = 0; i < houses.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    int distance = Math.abs(houses.get(i).x - pickPizzaStores.get(j).x) + Math.abs(houses.get(i).y - pickPizzaStores.get(j).y);
                    min = Math.min(min, distance);
                }
                sum += min;
            }
            answer.add(sum);
        }
        else{
            for (int i = start; i < pizzaStores.size(); i++) {
                pickPizzaStores.add(new Point(pizzaStores.get(i).x, pizzaStores.get(i).y));
                DFS(level + 1, i + 1);
                pickPizzaStores.remove(level);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) houses.add(new Point(i, j));
                if(board[i][j] == 2) pizzaStores.add(new Point(i, j));
            }
        }


        T.DFS(0, 0);

        System.out.println(answer.stream().mapToInt(Integer::intValue).min().getAsInt());

    }
}
