package programmers._37;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 전화번호 목록
class Main {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> phoneBook = new HashMap<>();
        for(String phoneNumber : phone_book) {
            phoneBook.put(phoneNumber, 1);
        }


        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (phoneBook.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String[] phone_book = {"119", "997674223", "1195524421"};

        System.out.println(T.solution(phone_book));
    }


}
