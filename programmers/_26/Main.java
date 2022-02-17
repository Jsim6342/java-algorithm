package programmers._26;

import java.util.*;
import java.util.stream.Collectors;

// 없는 숫자 더하기
class Main {

    public int solution(int[] numbers) {
        int result = 0;

        List<Integer> numberList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        for (int i = 0; i < 10; i++) {
            if(numberList.contains(i)) {
                continue;
            }
            result += i;
        }

        return result;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);


        int[] numbers = {1,2,3,4,6,7,8,0};


        System.out.println(T.solution(numbers));
    }


}
