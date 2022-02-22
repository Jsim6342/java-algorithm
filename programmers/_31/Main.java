package programmers._31;

import java.util.*;

// 폰켓몬
class Main {

    public int solution(int[] nums) {

        // 중복을 없애기 위해 set 자료구조 활용
        HashSet<Integer> set = new HashSet<>();
        for(int phoneketmon : nums) {
            set.add(phoneketmon);
        }

        // 남아 있는 set의 크기에 따라 return
        if(set.size() >= nums.length / 2) {
            return nums.length / 2;
        }else {
            return set.size();
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int[] nums = {3,1,2,3};

        System.out.println(T.solution(nums));
    }


}
