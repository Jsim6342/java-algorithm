package programmers._17;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// 거리두기(틀린 풀이)
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

    static int[] answer = new int[5];

    public void solution(String[][] places) {

        ArrayList<ArrayList<Point>> people = new ArrayList<>();

        int count = 0;
        for(String[] place : places) {
            people.add(new ArrayList<>());
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(place[i].charAt(j) == 'P') {
                        ArrayList<Point> points = people.get(count);
                        points.add(new Point(i, j));
                    }
                }
            }
            count++;
        }

        for (int i = 0; i < 5; i++) {
            ArrayList<Point> points = people.get(i);
            coluation(points, i, places);

        }

        for (int x : answer) {
            System.out.print(x);
        }
    }

    public void coluation(ArrayList<Point> points, int idx, String[][] places) {
        for (int j = 0; j < points.size(); j++) {
            for (int k = j; k < points.size(); k++) {
                int manhattan = Math.abs(points.get(j).x - points.get(k).x) + Math.abs(points.get(j).y - points.get(k).y);
                if(manhattan <= 1) {
                    answer[idx] = 0;
                    return;
                }
                if(manhattan == 2) {

                    if(points.get(j).x != points.get(k).x && points.get(j).y != points.get(k).y) {
                        int x1 = points.get(j).x + (points.get(k).x - points.get(j).x);
                        int y1 = points.get(j).y;

                        int x2 = points.get(j).x;
                        int y2 = points.get(j).y + (points.get(k).y - points.get(j).y);

                        if(places[idx][x1].charAt(y1) != 'X' || places[idx][x2].charAt(y2) != 'X') {
                            answer[idx] = 0;
                            return;
                        }
                    }else {
                        int x = (points.get(j).x + points.get(k).x) / 2;
                        int y = (points.get(j).y + points.get(k).y) / 2;
                        if(places[idx][x].charAt(y) != 'X') {
                            answer[idx] = 0;
                            return;
                        }
                    }
                }
            }
        }
        answer[idx] = 1;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        T.solution(places);
    }


}
