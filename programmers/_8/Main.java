package programmers._8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 기능개발
class Main {

    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> progressesQ = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            // 여기서 100.0을 해주는 이유는 나눗셈에서 소수점을 남겨 올림을 해주기 위함
            progressesQ.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        while(!progressesQ.isEmpty()) {
            int now = progressesQ.poll();
            int count = 1;
            while(!progressesQ.isEmpty() && now >= progressesQ.peek()) {
                progressesQ.poll();
                count++;
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(T.solution(progresses, speeds));
    }

}
