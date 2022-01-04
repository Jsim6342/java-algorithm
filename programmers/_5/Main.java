package programmers._5;

import java.util.Scanner;

// 단체사진 찍기
class Main {

    static char[] FRIENDS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[] friends = new char[8];
    static int[] check = new int[8];
    static int count = 0;
    static String[] dataList;

    public void DFS(int level) {
        if(level == friends.length) {
            boolean isCount = false;

            // 조건을 하나씩 탐색. 일치하지 않는 조건이 있다면 바로 break
            for(String data : dataList) {
                isCount = false;
                char friend1 = data.substring(0, 1).charAt(0);
                char friend2 = data.substring(2, 3).charAt(0);
                char commend = data.substring(3, 4).charAt(0);
                int number = Integer.valueOf(data.substring(4, 5));

                String stringFriends = String.valueOf(friends);
                int distance = Math.abs(stringFriends.indexOf(friend1) - stringFriends.indexOf(friend2)) - 1;

                switch (commend) {
                    case '<':
                        if(distance < number) isCount = true;
                        break;
                    case '>':
                        if(distance > number) isCount = true;
                        break;
                    case '=':
                        if(distance == number) isCount = true;
                        break;
                }
                if(isCount == false) break;
            }

            if(isCount == true) count++;
        }
        else {
            // 순열 만들기
            for (int i = 0; i < 8; i++) {
                if(check[i] == 0) {
                    friends[level] = FRIENDS[i];
                    check[i] = 1;
                    DFS(level + 1);
                    check[i] = 0;
                }
            }
        }


    }

    public int solution(int n, String[] data) {
        count = 0;
        dataList = data;
        DFS(0);
        return count;
    }



    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        System.out.println(T.solution(n, data));
    }
}
