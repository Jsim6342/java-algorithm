package programmers._11;

import java.util.Scanner;

// 타겟 넘버
class Main {

    static int answer = 0;
    static int[] staticNumbers;
    static int staticTarget;

    public void DFS(int level, int result) {
        if(level == staticNumbers.length - 1) {
            if(result == staticTarget) answer++;
            return;
        } else {
            DFS(level + 1, result + staticNumbers[level + 1]);
            DFS(level + 1, result - staticNumbers[level + 1]);
        }

    }

    public int solution(int[] numbers, int target) {
        staticNumbers = numbers;
        staticTarget = target;

        DFS(0, staticNumbers[0]);
        DFS(0, -staticNumbers[0]);
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(T.solution(numbers, target));
    }

}
