package inflearn.ch7_Recursive_Tree_Graph._1;

import java.util.ArrayList;
import java.util.Scanner;

// 7-1. 재귀함수
class Main {

    public ArrayList<Integer> solution(int n) {

        ArrayList<Integer> answer = new ArrayList<>();

        return makeArray(1, n, answer);
    }

    private ArrayList<Integer> makeArray(int cnt, int n, ArrayList<Integer> arr) {
        if(cnt == n+1) return arr;
        arr.add(cnt);
        return makeArray(cnt+1, n, arr);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int x : T.solution(n)) System.out.print(x + " ");

    }
}
