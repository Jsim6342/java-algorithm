package inflearn.ch6_Sorting_Searching._4;
import java.util.*;

// 6-4. Least Recently Used
class Main {

    public Queue<Integer> solution(int s,int n, int[] arr) {

        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < s ; i++) queue.add(0);

        for(int x : arr) {
            if(queue.contains(x)) {
                queue.remove(x);
                queue.add(x);
            }else {
                queue.poll();
                queue.add(x);
            }
        }

        return queue;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Queue<Integer> answer = T.solution(s, n, arr);
        
        for(int i = s - 1; i >= 0; i--) System.out.print(answer.toArray()[i] + " ");


    }
}
