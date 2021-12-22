package inflearn.ch9_Greedy._3;

import java.util.*;

// 9-3. 결혼식
class Time implements Comparable<Time>{
    int time;
    char state;

    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time o) {
        if(this.time - o.time == 0) {
            return this.state - o.state;
        }
        return this.time - o.time;
    }

}

class Main {

    public int solution(ArrayList<Time> arr) {
        Collections.sort(arr);
        int maxCnt = 0;
        int cnt = 0;
        for (Time time : arr) {
            if(time.state == 's') {
                cnt++;
            }
            if(time.state == 'e') {
                cnt--;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            arr.add(new Time(startTime, 's'));
            arr.add(new Time(endTime, 'e'));
        }

        System.out.println(T.solution(arr));

    }
}
