package inflearn.ch4_HashMap_HashSet_TreeSet._4;
import java.util.*;

// 4-4. 모든 아나그램 찾기(해쉬, 투포인터, 슬라이딩 윈도우)
class Main {

    public int solution(char[] sWord, char[] tWord) {
        
        int answer = 0;

        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char x : tWord) {
            tMap.put(x, tMap.getOrDefault(x, 0) + 1);
        }

        int lt = 0;
        int rt = 0;

        HashMap<Character, Integer> sMap = new HashMap<>();
        sMap.put(sWord[0], 1);

        while(rt < sWord.length - 1) {
            while(rt - lt < tWord.length - 1) {
                rt++;
                sMap.put(sWord[rt], sMap.getOrDefault(sWord[rt], 0) + 1);
            }
            
            if(tMap.equals(sMap)) answer++;


            sMap.replace(sWord[lt], sMap.get(sWord[lt]) - 1);
            if(sMap.get(sWord[lt]) == 0) sMap.remove(sWord[lt]);

            lt++;

        }
        
            
        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String sWord = sc.nextLine();
        String tWord = sc.nextLine();

        System.out.print(T.solution(sWord.toCharArray(), tWord.toCharArray()));

    }
}
