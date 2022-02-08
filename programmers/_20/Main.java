package programmers._20;

import java.lang.reflect.Array;
import java.util.*;

// 신고 결과 받기
class Main {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 결과를 카운트할 Map 생성
        Map<String, Integer> result = new HashMap<>();
        for (String id : id_list) {
            result.put(id, 0);
        }

        // set 자료구조로 중복을 없앤다
        Set<String> setReport = new HashSet<>();
        for (String s : report) {
            setReport.add(s);
        }

        // Map 자료구조 생성
        Map<String, ArrayList<String>> mapReport = new HashMap<>();

        // Report 내용으로 Map 자료구조 채우기
        // key는 신고당한id, value는 신고한 사람들 id
        for (String s : setReport) {
            String[] splitList = s.split(" ");
            if(mapReport.containsKey(splitList[1])) {
                mapReport.get(splitList[1]).add(splitList[0]);
            }else {
                mapReport.put(splitList[1], new ArrayList<>(Arrays.asList(splitList[0])));
            }
        }


        // result Map에 카운트 저장
        for (Map.Entry<String, ArrayList<String>> entry : mapReport.entrySet()) {
            if(entry.getValue().size() >= k) {
                for (String id : entry.getValue()) {
                    result.replace(id, result.get(id) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = result.get(id_list[i]);
        }

        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);


        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;

        System.out.println(T.solution(id_list, report, k));
    }


}
