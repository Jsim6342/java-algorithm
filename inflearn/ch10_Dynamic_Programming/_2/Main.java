package inflearn.ch10_Dynamic_Programming._2;

import java.util.Scanner;

// 10-2. 돌다리 건너기
class Main {

    static int n;
    static int[] memory = new int[36];

    public int solution(int num) {
        if(num == 3) return 5;
        if(num == 4) return 8;
        else{
            return memory[num] = solution(num - 2) + solution(num - 1);
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();


        System.out.println(T.solution(n));

    }
}
