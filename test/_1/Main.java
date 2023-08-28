package test._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 임시로 테스트 해보는 코드 작성
 */
class Main {
    public static void main(String[] args)throws IOException {

        // 변수선언
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 8진수 -> 2진수 변경 리스트
        String[] eightList = {"000", "001", "010", "011", "100","101","110","111"};


        // 값 입력
        String eight = bf.readLine();

        // 8진수 -> 2진수
        for (int i = 0 ; i < eight.length(); i++){
            int num =  eight.charAt(i)-'0';
            sb.append(eightList[num]);
        }


        // 맨앞에 0이 오는 경우 제거
        if(sb.equals("0")|| sb.charAt(0)!='0'){
            System.out.print(sb);

        }else{
            System.out.print(sb.substring(1));
        }
    }
}