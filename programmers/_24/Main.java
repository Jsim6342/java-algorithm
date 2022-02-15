package programmers._24;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 키패드 누르기
class Main {

    final int LEFT_HAND = 0;
    final int RIGHT_HAND = 1;

    public String solution(int[] numbers, String hand) {

        // 키패드 위치 정보를 담은 Map 생성
        Map<Integer, Position> keyPad = new HashMap<>();
        keyPad.put(1, new Position(0, 0));
        keyPad.put(2, new Position(0, 1));
        keyPad.put(3, new Position(0, 2));
        keyPad.put(4, new Position(1, 0));
        keyPad.put(5, new Position(1, 1));
        keyPad.put(6, new Position(1, 2));
        keyPad.put(7, new Position(2, 0));
        keyPad.put(8, new Position(2, 1));
        keyPad.put(9, new Position(2, 2));
        keyPad.put(0, new Position(3, 1));

        // 현재 왼손, 오른손 위치를 담은 배열 선언. 0번 왼손, 1번 오른손 위치 저장.
        Position[] handPosition = new Position[2];
        handPosition[LEFT_HAND] = new Position(3, 0);
        handPosition[RIGHT_HAND] = new Position(3, 2);

        // result 선언
        StringBuffer result = new StringBuffer();

        // 숫자에 따라 result에 값 추가

        for(int number : numbers) {
            // 왼손, 오른손 고정적인 값 추가
            if(number == 1 || number == 4 || number == 7) {
                result.append("L");
                handPosition[LEFT_HAND] = keyPad.get(number);
            }
            if(number == 3 || number == 6 || number == 9) {
                result.append("R");
                handPosition[RIGHT_HAND] = keyPad.get(number);
            }

            // 가운데 값은 가까운 값을 계산하여 추가
            if(number == 2 || number == 5 || number == 8 || number == 0) {
                Position target = keyPad.get(number);
                int leftDistance = Math.abs(target.x - handPosition[LEFT_HAND].x) + Math.abs(target.y - handPosition[LEFT_HAND].y);
                int rightDistance = Math.abs(target.x - handPosition[RIGHT_HAND].x) + Math.abs(target.y - handPosition[RIGHT_HAND].y);

                if(leftDistance == rightDistance) {
                    if(hand.equals("right")) {
                        result.append("R");
                        handPosition[RIGHT_HAND] = keyPad.get(number);
                    }
                    if(hand.equals("left")) {
                        result.append("L");
                        handPosition[LEFT_HAND] = keyPad.get(number);
                    }
                }
                if(leftDistance > rightDistance) {
                    result.append("R");
                    handPosition[RIGHT_HAND] = keyPad.get(number);
                }
                if(leftDistance < rightDistance) {
                    result.append("L");
                    handPosition[LEFT_HAND] = keyPad.get(number);
                }
            }

        }

        return result.toString();
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);


        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(T.solution(numbers, hand));
    }


}
