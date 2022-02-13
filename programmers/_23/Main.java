package programmers._23;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 숫자 문자열과 영단어
class Main {

    public int solution(String s) {

        // 문자, 숫자 대응 Map 자료구조를 만든다.
        Map<String, Integer> numbersMap = new HashMap<>();
        numbersMap.put("zero", 0);
        numbersMap.put("one", 1);
        numbersMap.put("two", 2);
        numbersMap.put("three", 3);
        numbersMap.put("four", 4);
        numbersMap.put("five", 5);
        numbersMap.put("six", 6);
        numbersMap.put("seven", 7);
        numbersMap.put("eight", 8);
        numbersMap.put("nine", 9);

        // 문자열 s를 탐색하며 숫자와 문자를 비교하고, result를 채워나간다.
        StringBuffer result = new StringBuffer();

        char[] words = s.toCharArray();
        StringBuffer temp = new StringBuffer();

        for(int i = 0; i < words.length; i++ ) {
            if(Character.isDigit(words[i])) {
                result.append(words[i]);
                continue;
            }

            temp.append(words[i]);
            if(numbersMap.containsKey(temp.toString())) {
                result.append(numbersMap.get(temp.toString()));
                temp.setLength(0);
            }

        }

        return Integer.valueOf(result.toString());
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);


        String s = "one4seveneight";

        System.out.println(T.solution(s));
    }


}
