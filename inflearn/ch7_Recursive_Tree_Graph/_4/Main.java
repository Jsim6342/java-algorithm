package inflearn.ch7_Recursive_Tree_Graph._4;

import java.util.ArrayList;
import java.util.Scanner;

// 7-4. 피보나치 수열
class Main {

    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> memory = new ArrayList<>();
        memory.add(1);
        memory.add(1);
        return DFS(n, memory);
    }

    private ArrayList<Integer> DFS(int n, ArrayList<Integer> memory) {
        if(memory.size() == n) return memory;
        memory.add(memory.get(memory.size()-1) + memory.get(memory.size()-2));
        return DFS(n, memory);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));

    }
}
