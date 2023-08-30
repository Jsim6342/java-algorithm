package baekjoon.implement._12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 문제: 백준 1244번. 스위치 켜고 끄기
 * 링크: https://www.acmicpc.net/problem/1244
 */
class Main {

    static List<Integer> switchList;
    static int N;
    static int T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        switchList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            Integer number = inputs.get(1) - 1;
            if (inputs.get(0) == 1) manSwtich(number);
            if (inputs.get(0) == 2) womanSwtich(number);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append(switchList.get(i));
            sb.append(" ");
            if ((i+1) % 20 == 0) sb.append("\n");
        }
        System.out.print(sb);

    }

    private static void manSwtich(int number) {
        for (int i = number; i < N; i += number+1) {
            Integer switchNumber = switchList.get(i);
            switchList.set(i, switchNumber == 1 ? 0 : 1);
        }
    }

    private static void womanSwtich(int number) {
        switchList.set(number, switchList.get(number) == 1 ? 0 : 1);
        for (int i = 1; i < N/2; i++) {
            if(number - i < 0 || number + i >= N) return;
            if(switchList.get(number-i) == switchList.get(number+i)) {
                switchList.set(number-i, switchList.get(number-i) == 1 ? 0 : 1);
                switchList.set(number+i, switchList.get(number+i) == 1 ? 0 : 1);
            }else return;

        }
    }


}