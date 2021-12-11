package inflearn.ch5_Stack_Queue._8_2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 5-8. 응급실 풀이2
class Main {

    class Person implements Comparable<Person>{
        int id;
        int danger;

        public Person(int id, int danger) {
            this.id = id;
            this.danger = danger;
        }

        @Override
        public int compareTo(Person o) {
            if(this.danger > o.danger) {
                return 1;
            }

            if(this.danger == o.danger) {
                return 0;
            }

            return -1;
        }

    }

    public int solution(int n, int m, int[] waiting) {

        int answer = 0;

        Queue<Person> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            queue.add(new Person(i, waiting[i]));
        }


        while(queue.size() > 0) {

            if(queue.peek() == Collections.max(queue)) {
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
