package programmers._29;

import java.util.Scanner;

// 소수 만들기
class Main {

    public int solution(int[] nums) {
        int answer = 0;

        // 3개 선택
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int result = nums[i] + nums[j] + nums[k];
                    if(checkSosu(result) == true) answer += 1;
                }
            }
        }
        return answer;
    }

    // 소수 체크
    public boolean checkSosu(int number) {
        for(int i = 2; i <= number/2; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);


        int[] nums = {1,2,3,4};


        System.out.println(T.solution(nums));
    }


}
