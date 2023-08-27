package baekjoon.implement._10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * 문제: 백준 12933번. 오리
 * 링크: https://www.acmicpc.net/problem/12933
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String soundString = br.readLine();
        List<StringBuffer> quackList = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < soundString.length(); i++) {
            char word = soundString.charAt(i);

            boolean check = false;
            for (StringBuffer stringBuffer : quackList) {
                char lastWord = stringBuffer.charAt(stringBuffer.length() - 1);

                if(lastWord == 'q' && word == 'u') {
                    stringBuffer.append(word);
                    check = true;
                    break;
                }
                if(lastWord == 'u' && word == 'a') {
                    stringBuffer.append(word);
                    check = true;
                    break;
                }
                if(lastWord == 'a' && word == 'c') {
                    stringBuffer.append(word);
                    check = true;
                    break;
                }
                if(lastWord == 'c' && word == 'k') {
                    stringBuffer.append(word);
                    check = true;
                    break;
                }
                if(lastWord == 'k' && word == 'q') {
                    stringBuffer.append(word);
                    check = true;;
                    break;
                }
            }

            if(!check) {
              if(word == 'q') quackList.add(new StringBuffer().append(word));

              // 중간에 이상한 문자가 껴있는 경우
              else {
                  result = -1;
                  break;
              }
            }
        }

        if(result == 0) {
            for(StringBuffer stringbuffer : quackList) {
                if(stringbuffer.length() % 5 != 0) {
                    result = -1;
                    break;
                }
                result++;
            }
        }
        System.out.println(result);
    }


}