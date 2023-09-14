package baekjoon.implement._24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 백준 1283번. 단축키 지정
 * 링크: https://www.acmicpc.net/problem/1283
 */
class Main {

    static int N;
    static StringTokenizer st;
    static List<String> wordsList = new ArrayList<>();
    static Set<Character> checkedShortCutKeys = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String inputWord = br.readLine();
            wordsList.add(inputWord);
        }

        for(String words : wordsList) {
            boolean isApply = false;

            // 첫 번째 규칙 적용
            sb.replace(0,sb.length(),"");
            st = new StringTokenizer(words);
            while(st.hasMoreElements()) {
                String word = st.nextToken();
                char firstAlphabet = Character.toUpperCase(word.charAt(0));
                if(checkedShortCutKeys.contains(firstAlphabet) || isApply == true) {
                    sb.append(word);
                    if(st.hasMoreElements()) sb.append(" ");
                }else {
                    checkedShortCutKeys.add(firstAlphabet);
                    sb.append("[").append(word.charAt(0)).append("]");
                    for (int i = 1; i < word.length(); i++) {
                        sb.append(word.charAt(i));
                    }
                    if(st.hasMoreElements()) sb.append(" ");
                    isApply = true;
                }
            }

            if(isApply) {
                result.append(sb).append("\n");
                continue;
            }

            // 두 번째 규칙 적용
            sb.replace(0,sb.length(),"");
            st = new StringTokenizer(words);
            while(st.hasMoreElements()) {
                String word = st.nextToken();
                for (int i = 0; i < word.length(); i++) {
                    char alphabet = Character.toUpperCase(word.charAt(i));
                    if(checkedShortCutKeys.contains(alphabet) || isApply == true) {
                        sb.append(word.charAt(i));
                        if(i == word.length() - 1 && st.hasMoreElements()) sb.append(" ");
                    }else {
                        checkedShortCutKeys.add(alphabet);
                        sb.append("[").append(word.charAt(i)).append("]");
                        if(i == word.length() - 1 && st.hasMoreElements()) sb.append(" ");
                        isApply = true;
                    }
                }
            }

            result.append(sb).append("\n");
        }

        System.out.println(result);

    }

}