package programmers._16;

import java.util.*;

// [1차] 뉴스 클러스터링
class Common {
    String word;
    int str1Value;
    int str2Value;

    public Common(String word, int str1Value, int str2Value) {
        this.word = word;
        this.str1Value = str1Value;
        this.str2Value = str2Value;
    }

}

class Main {

    public int solution(String str1, String str2) {
        double commonNum = 0;
        double sumNum = 0;

        Map<String, Integer> str1Map = new Hashtable<>();
        Map<String, Integer> str2Map = new Hashtable<>();
        ArrayList<Common> commonList = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // str1 탐색하며 부분집합 제작
        for(int i = 0;i < str1.length() - 1; i++) {
            char char1 = str1.charAt(i);
            char char2 = str1.charAt(i + 1);

            if(!Character.isAlphabetic(char1) || !Character.isAlphabetic(char2)) continue;

            String word = char1 + "" + char2;

            if(str1Map.containsKey(word)) {
                str1Map.replace(word, str1Map.get(word) + 1);
            }else {
                str1Map.put(word, 1);
            }
        }

        // str2 탐색하며 부분집합 제작
        for(int i = 0;i < str2.length() - 1; i++) {
            char char1 = str2.charAt(i);
            char char2 = str2.charAt(i + 1);

            if(!Character.isAlphabetic(char1) || !Character.isAlphabetic(char2)) continue;

            String word = char1 + "" + char2;

            if(str2Map.containsKey(word)) {
                str2Map.replace(word, str2Map.get(word) + 1);
            }else {
                str2Map.put(word, 1);
            }
        }

        ArrayList<String> removeList = new ArrayList<>();

        // 공통 부분만을 뽑아 ArrayList에 저장
        for (String word : str1Map.keySet()) {
            if(str2Map.containsKey(word)) {
                commonList.add(new Common(word, str1Map.get(word), str2Map.get(word)));
                removeList.add(word);
            }
        }


        // 공통 값 지워주기
        for (String word : removeList) {
            str1Map.remove(word);
            str2Map.remove(word);
        }

        // 교집합 갯수 및 합집합 공통 갯수
        for (Common common : commonList) {
            commonNum += Math.min(common.str1Value, common.str2Value);
            sumNum += Math.max(common.str1Value, common.str2Value);
        }

        // 합집합 나머지 갯수 더해주기
        for (Integer value : str1Map.values()) {
            sumNum += value;
        }
        for (Integer value : str2Map.values()) {
            sumNum += value;
        }

        // 합집합 0일 때 65536, 교집합 0일 때 0을 리턴 해야함.
        if(sumNum == 0) return 65536;
        if(commonNum == 0) return 0;
        return (int)((commonNum / sumNum) * 65536);
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str1 = "handshake";
        String str2 = "shake hands";


        System.out.println(T.solution(str1, str2));
    }


}
