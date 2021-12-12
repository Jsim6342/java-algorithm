package inflearn.ch6_Sorting_Searching._5;
import java.util.*;

// 6-5. 중복 확인
class Main {

    public String solution(int n, HashSet<Integer> set) {

        String answer = "U";

        if(set.size() != n) return "D"; 

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) set.add(sc.nextInt());

        System.out.print(T.solution(n, set));
        


    }
}
