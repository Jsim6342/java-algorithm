package inflearn.ch5_Stack_Queue._7;
import java.util.*;

// 5-7. 교육과정 설계
class Main {

    public String solution(char[] required, char[] timeTable) {

        Queue<Character> queue = new LinkedList<>();

        for(char x : required) queue.offer(x);

        for(char subject : timeTable) {
            if(queue.size() == 0) return "YES";
            if(queue.peek() == subject) queue.poll();
        }

        if(queue.size() != 0) return "NO";
        return "YES"; 

    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String required = sc.nextLine();
        String timeTable = sc.nextLine();

        System.out.print(T.solution(required.toCharArray(), timeTable.toCharArray()));


    }
}
