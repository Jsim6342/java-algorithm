package baekjoon.implement._21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 문제: 백준 1316번. 그룹 단어 체커
 * 링크: https://www.acmicpc.net/problem/1316
 */
class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            String inputString = br.readLine();
            List<Character> checked = new ArrayList<>();

            char firstWord = inputString.charAt(0);
            checked.add(firstWord);
            char preWord = firstWord;

            boolean isGroup = true;
            for (int j = 1; j < inputString.length(); j++) {
                char word = inputString.charAt(j);
                if(checked.contains(word)) {
                    if (word == preWord) continue;
                    else {
                        isGroup = false;
                        break;
                    }
                }else{
                    checked.add(word);
                    preWord = word;
                }
            }
            if(isGroup) result++;
        }
        System.out.println(result);
    }


}