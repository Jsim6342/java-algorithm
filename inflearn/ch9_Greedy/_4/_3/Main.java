package inflearn.ch9_Greedy._4._3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// 9-4. 최대 수입 스케쥴
class Lecture implements Comparable<Lecture>{
    int money;
    int date;

    public Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.date - this.date;
    }
}

class Main {

    public int solution(ArrayList<Lecture> arr, int maxDate) {
        Collections.sort(arr);
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int day = maxDate; day >= 1; day--) {
            while(!arr.isEmpty() && arr.get(0).date == day) {
                pQ.add(arr.get(0).money);
                arr.remove(0);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        int maxDate = 0;
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int date = sc.nextInt();
            arr.add(new Lecture(money, date));
            maxDate = Math.max(maxDate, date);
        }

        System.out.println(T.solution(arr, maxDate));

    }
}
