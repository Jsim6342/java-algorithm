package baekjoon.implement._16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/**
 * 문제: 백준 17413번. 단어 뒤집기 2
 * 링크: https://www.acmicpc.net/problem/17413
 */
class Main {

    static String inputString;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputString = br.readLine();

        StringBuffer result = new StringBuffer();
        StringBuffer tempString = new StringBuffer();

        boolean reverseStatus = true;
        for (int i = 0; i < inputString.length(); i++) {
            char word = inputString.charAt(i);

            tempString.append(word);

            if (word == '<') {
                reverseStatus = false;
                result.append(tempString.reverse().delete(0,1));
                result.append(word);
                tempString.delete(0, tempString.length());
                continue;
            }
            if (word == '>') {
                reverseStatus = true;
                result.append(tempString);
                tempString.delete(0, tempString.length());
                continue;
            }

            if (word == ' ' && reverseStatus == true) {
                result.append(tempString.reverse().delete(0,1));
                result.append(word);
                tempString.delete(0, tempString.length());
                continue;
            }
            if (word == ' ' && reverseStatus == false) {
                result.append(tempString);
                tempString.delete(0, tempString.length());
                continue;
            }

        }

        if (tempString.length() > 0) result.append(tempString.reverse());
        System.out.println(result);

    }


}