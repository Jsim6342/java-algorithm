package inflearn.ch2_Array._8;
import java.util.*;

// 2-8. 등수구하기
class Main {

    public int[] solution(int n, Integer[] arr) {
        
        int[] answer = new int[n];

        Map ranking = makeRanking(n, arr);

        for(int i = 0 ; i < n ; i++) {
            answer[i] = Integer.valueOf(ranking.get(arr[i]).toString());
        }

        return answer;
    }


    private Map makeRanking(int n, Integer[] arr) {
        Integer[] sortArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortArr, Collections.reverseOrder());
        Map ranking = new HashMap();

        
        int rank = 1;
        for(int i = 0; i < arr.length ; i++) {
            if(!ranking.containsKey(sortArr[i])){
                ranking.put(sortArr[i], rank);
            }
            rank++;
        }
        return ranking;
    }

    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
 
       for(int x : T.solution(n, arr)) System.out.print(x + " ");
       
 
    }
}
