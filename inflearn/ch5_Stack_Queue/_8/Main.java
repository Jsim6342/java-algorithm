package inflearn.ch5_Stack_Queue._8;
import java.util.*;

// 5-8. 응급실
class Main {

    class Person {
        int id;
        int danger;

        public Person(int id, int danger) {
            this.id = id;
            this.danger = danger;
        }

    }

    public int solution(int n, int m, int[] waiting) {

        int answer = 0;

        Queue<Person> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            queue.add(new Person(i, waiting[i]));
        }


        while(queue.size() > 0) {

            if(queue.peek() == Collections.max(queue, (o1, o2) -> {
                if(o1.danger > o2.danger) return 1;
                if(o1.danger == o2.danger) return 0;
                return -1;
            })) {
                answer++;
                if(m == queue.poll().id) return answer;
                continue;
            }

            queue.add(queue.poll());
        }


        return answer;

    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] waiting = new int[n];
        for(int i = 0; i < n; i++) waiting[i] = sc.nextInt();


        System.out.print(T.solution(n, m, waiting));


    }
}
