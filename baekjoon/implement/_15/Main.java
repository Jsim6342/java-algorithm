package baekjoon.implement._15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/**
 * 문제: 백준 20436번. ZOAC 3
 * 링크: https://www.acmicpc.net/problem/20436
 */
class Main {

    static char L;
    static char R;
    static String inputString;
    static Map<Character, Integer[]> vowelKeyboard = new HashMap<>();
    static Map<Character, Integer[]> consonantKeyboard = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] charArray = br.readLine().split(" ");
        L = charArray[0].charAt(0);
        R = charArray[1].charAt(0);
        inputString = br.readLine();

        makeKeyboard();

        char preVowelWord = L;
        char preConsonantWord = R;
        int time = 0;

        for (int i = 0; i < inputString.length(); i++) {

            char nowWord = inputString.charAt(i);
            if(vowelKeyboard.containsKey(nowWord)) {
                Integer[] prePoint = vowelKeyboard.get(preVowelWord);
                Integer[] nowPoint = vowelKeyboard.get(nowWord);
                time += Math.abs(nowPoint[0] - prePoint[0]) + Math.abs(nowPoint[1] - prePoint[1]);
                time += 1;
                preVowelWord = nowWord;
            }
            if(consonantKeyboard.containsKey(nowWord)) {
                Integer[] prePoint = consonantKeyboard.get(preConsonantWord);
                Integer[] nowPoint = consonantKeyboard.get(nowWord);
                time += Math.abs(nowPoint[0] - prePoint[0]) + Math.abs(nowPoint[1] - prePoint[1]);
                time += 1;
                preConsonantWord = nowWord;
            }

        }

        System.out.println(time);


    }

    private static void makeKeyboard() {
        vowelKeyboard.put('q', new Integer[]{0,0});
        vowelKeyboard.put('w', new Integer[]{0,1});
        vowelKeyboard.put('e', new Integer[]{0,2});
        vowelKeyboard.put('r', new Integer[]{0,3});
        vowelKeyboard.put('t', new Integer[]{0,4});
        consonantKeyboard.put('y', new Integer[]{0,5});
        consonantKeyboard.put('u', new Integer[]{0,6});
        consonantKeyboard.put('i', new Integer[]{0,7});
        consonantKeyboard.put('o', new Integer[]{0,8});
        consonantKeyboard.put('p', new Integer[]{0,9});
        vowelKeyboard.put('a', new Integer[]{1,0});
        vowelKeyboard.put('s', new Integer[]{1,1});
        vowelKeyboard.put('d', new Integer[]{1,2});
        vowelKeyboard.put('f', new Integer[]{1,3});
        vowelKeyboard.put('g', new Integer[]{1,4});
        consonantKeyboard.put('h', new Integer[]{1,5});
        consonantKeyboard.put('j', new Integer[]{1,6});
        consonantKeyboard.put('k', new Integer[]{1,7});
        consonantKeyboard.put('l', new Integer[]{1,8});
        vowelKeyboard.put('z', new Integer[]{2,0});
        vowelKeyboard.put('x', new Integer[]{2,1});
        vowelKeyboard.put('c', new Integer[]{2,2});
        vowelKeyboard.put('v', new Integer[]{2,3});
        consonantKeyboard.put('b', new Integer[]{2,4});
        consonantKeyboard.put('n', new Integer[]{2,5});
        consonantKeyboard.put('m', new Integer[]{2,6});
    }

}