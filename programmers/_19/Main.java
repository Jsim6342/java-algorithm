package programmers._19;

import java.util.*;

// 튜플
class Main {

    public int[] solution(String s) {

        Map<String, Integer> hashMap = new HashMap<>();

        s = s.replaceAll("[\\{,\\}]", " ");
        String[] numbers = s.split("[ ]+");

        for (int i = 0; i < numbers.length; i++) {
            if(!numbers[i].equals("")) {
                if(hashMap.containsKey(numbers[i])) {
                    hashMap.replace(numbers[i], hashMap.get(numbers[i]) + 1);
                }else {
                    hashMap.put(numbers[i], 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, ((o1, o2) -> {return o2.getValue().compareTo(o1.getValue());}));

        int[] answer = new int[list.size()];

        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            answer[count++] = Integer.parseInt(entry.getKey());
        }

        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        System.out.println(T.solution(s));
    }


}
