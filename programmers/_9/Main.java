package programmers._9;

import java.util.*;

// 더 맵게
class Main {

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int s : scoville) {
            pQ.add(s);
        }

        int count = 0;
        while(pQ.size() > 1) {
            int scoville1 = pQ.poll();
            int scoville2 = pQ.poll();
            pQ.add(scoville1 + (scoville2 * 2));
            count++;
            if(pQ.peek() >= K) break;
        }

        if(pQ.peek() >= K) return count;
        return -1;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(T.solution(scoville, K));
    }

}
