package inflearn.ch4_HashMap_HashSet_TreeSet._1;
import java.util.*;

// 4-1. 학급 회장
class Main {

    public char solution(int n, String input) {
        
        HashMap<Character, Integer> result = new HashMap<>();

        for (char x : input.toCharArray()) {
            if(!result.keySet().contains(x)) result.put(x, 1);
            else {
                result.replace(x, result.get(x) + 1);
            }
        }

        int maxNum = Collections.max(result.values());

        return result.keySet().stream()
            .filter(k -> result.get(k) == maxNum)
            .findFirst().get();
            
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String input = sc.next();

        System.out.print(T.solution(n, input));


    }
}
