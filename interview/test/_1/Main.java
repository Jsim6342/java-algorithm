package interview.test._1;

import java.util.*;

// 테스트
//
class Main {

    public String solution(int x) {
        // 1. 입력된 x 값을 인덱스 뒤에서 부터 탐색하며 갯수를 카운팅
        // 2. 카운트 갯수가 3개일 때 마다 , 추가

        String s = String.valueOf(x);
        char[] stringNum = s.toCharArray();
        int count = 0;
        StringBuffer br = new StringBuffer();
        for (int i = stringNum.length - 1; i >= 0; i--) {
            if(count == 3) {
                br.append(',');
                count = 0;
            }
            count++;
            br.append(stringNum[i]);
        }
        return br.reverse().toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        Integer x = 100;
        System.out.println(T.solution(x));

    }
}
