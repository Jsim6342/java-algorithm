package programmers._33;

import java.util.*;

// 메뉴 리뉴얼
class Main {

    public ArrayList<String> solution(String[] orders, int[] course) {


        ArrayList<String> answer = new ArrayList<>();

        // 각 문자열을 오름차순 정렬.
        for(int i =0;i<orders.length;i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        for (int number : course) {
            int max = Integer.MIN_VALUE;
            Map<String, Integer> candidate = new HashMap<>();

            for (String order : orders) {
                StringBuffer menu = new StringBuffer();
                DFS(candidate, order, menu, 0, number);
            }

            for(Map.Entry<String,Integer> entry : candidate.entrySet()){
                max = Math.max(max,entry.getValue());

            }

            for(Map.Entry<String,Integer> entry : candidate.entrySet()){
                if(max >=2 && entry.getValue() == max)
                    answer.add(entry.getKey());
            }
        }

        Collections.sort(answer);

        return answer;

    }

    public void DFS(Map<String, Integer> candidate, String order, StringBuffer menu, int start, int course) {
        if(menu.length() == course) {
            String s = menu.toString();
            if(candidate.containsKey(s)) {
                candidate.replace(s, candidate.get(s) + 1);
            }else {
                candidate.put(s, 1);
            }
        }else {
            for (int i = start; i < order.length(); i++) {
                menu.append(order.charAt(i));
                DFS(candidate, order, menu,i + 1, course);
                menu.deleteCharAt(menu.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        T.solution(orders, course);
        System.out.println();
    }


}
