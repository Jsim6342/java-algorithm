package inflearn.ch4_HashMap_HashSet_TreeSet._2;
import java.util.*;

// 4-2. 아나그램(해쉬)
class Main {

    public String solution(String word1, String word2) {
        
        HashMap<Character, Integer> word1Components = new HashMap<>();
        HashMap<Character, Integer> word2Components = new HashMap<>();

        makeMap(word1, word1Components);
        makeMap(word2, word2Components);

        return word1Components.equals(word2Components) == true ? "YES" : "NO" ;
    }

    private void makeMap(String word, HashMap<Character, Integer> hashMap) {
        for(char x : word.toCharArray()) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        
        System.out.print(T.solution(word1, word2));


    }
}
