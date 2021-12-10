package inflearn.ch5_Stack_Queue._6;
import java.util.*;

// 5-6. 공주 구하기
class Main {

    public int solution(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1 ; i <= n ; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {

            for(int i = 0 ; i < k ; i++) {
                if(i == k - 1) {
                    queue.poll();
                    break;
                }
                queue.add(queue.poll());
            }
        }

        return queue.poll();
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.print(T.solution(n, k));


    }
}
