package baekjoon.implement._20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 문제: 백준 15787번. 기차가 어둠을 헤치고 은하수를
 * 링크: https://www.acmicpc.net/problem/15787
 */
class Main {

    static int N;
    static int M;
    static List<boolean[]> trains = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            trains.add(new boolean[20]);
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int commend = Integer.parseInt(st.nextToken());
            int trainNumber = Integer.parseInt(st.nextToken());

            if (commend == 1) {
                int customerNumber =Integer.parseInt(st.nextToken());
                trains.get(trainNumber-1)[customerNumber-1] = true;
            }
            if (commend == 2) {
                int customerNumber = Integer.parseInt(st.nextToken());
                trains.get(trainNumber-1)[customerNumber-1] = false;
            }
            if (commend == 3) {
                boolean[] changeTrain = new boolean[20];
                for (int j = 1; j < 20; j++) {
                    changeTrain[j] = trains.get(trainNumber-1)[j-1];
                }
                trains.set(trainNumber-1, changeTrain);
            }
            if (commend == 4) {
                boolean[] changeTrain = new boolean[20];
                for (int j = 19; j > 0; j--) {
                    changeTrain[j-1] = trains.get(trainNumber-1)[j];
                }
                trains.set(trainNumber-1, changeTrain);
            }
        }

        Set<String> result = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < 20; j++) {
                sb.append(trains.get(i)[j]);
            }
            result.add(sb.toString());
        }

        System.out.println(result.size());
    }


}