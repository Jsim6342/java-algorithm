package inflearn.ch9_Greedy._2;

import java.util.Arrays;
import java.util.Scanner;

// 9-2. 회의실 배정
class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.end - o.end == 0) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

class Main {

    public int solution(int n, Meeting[] meetings) {
        int answer = 0;

        Arrays.sort(meetings);

        int endTime = meetings[0].end;
        answer++;

        for (int i = 1; i < n; i++) {
            if(meetings[i].start >= endTime) {
                endTime = meetings[i].end;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }

        System.out.println(T.solution(n, meetings));

    }
}
