package inflearn.ch4_HashMap_HashSet_TreeSet._3;
import java.util.*;

// 4-3. 매출액의 종류
class Main {

    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        
        ArrayList<Integer> answer = new ArrayList<>();

        int lt = 0;
        int rt = 0;

        Queue<Integer> oneDay = new LinkedList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(arr[0], 1);
        while(rt < n - 1) {
            
            while(rt - lt < k - 1) {
                rt++;
                hashMap.put(arr[rt], hashMap.getOrDefault(arr[rt], 0) + 1);
            }

            answer.add(hashMap.size());
            hashMap.replace(arr[lt], hashMap.get(arr[lt]) - 1);
            if(hashMap.get(arr[lt]) == 0) hashMap.remove(arr[lt]);
            lt++;
        }
            
        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();


        for(Integer x : T.solution(n, k, arr)) System.out.print(x + " ");


    }
}
