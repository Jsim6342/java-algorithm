package programmers._2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 오픈채팅방
class Main {

    static ArrayList<String> result = new ArrayList<>();
    static HashMap<String, ArrayList<Integer>> log = new HashMap<>();
    static HashMap<String, String> db = new HashMap<>();

    public void enter(String[] splitNow) {

        if(db.containsKey(splitNow[1])) {
            change(splitNow);
            makeMssage(splitNow, "enter");
        }
        else {
            db.put(splitNow[1], splitNow[2]);
            makeMssage(splitNow, "enter");
        }
    }

    public void leave(String[] splitNow) {
        makeMssage(splitNow, "leave");
    }

    public void makeMssage(String[] splitNow, String commend) {
        StringBuffer br = new StringBuffer();
        if(commend.equals("enter")) br.append(db.get(splitNow[1])).append("님이 들어왔습니다.");
        if(commend.equals("leave")) br.append(db.get(splitNow[1])).append("님이 나갔습니다.");

        result.add(br.toString());

        if(log.containsKey(splitNow[1])) {
            log.get(splitNow[1]).add(result.size() - 1);
        }else {
            log.put(splitNow[1], new ArrayList<>());
            log.get(splitNow[1]).add(result.size() - 1);
        }
    }

    public void change(String[] splitNow) {
        db.replace(splitNow[1], splitNow[2]);

        ArrayList<Integer> indexList = log.get(splitNow[1]);
        for (Integer index : indexList) {
            StringBuffer br = new StringBuffer();
            String commandMssage = result.get(index).split(" ")[1];
            if(commandMssage.equals("들어왔습니다.")) br.append(splitNow[2]).append("님이 들어왔습니다.");
            if(commandMssage.equals("나갔습니다.")) br.append(splitNow[2]).append("님이 나갔습니다.");
            result.set(index, br.toString());
        }

    }

    public ArrayList<String> solution(String[] record) {

        for (String now : record) {
            String[] splitNow = now.split(" ");
            String commend = splitNow[0];

            if(commend.equals("Enter")) enter(splitNow);
            if(commend.equals("Leave")) leave(splitNow);
            if(commend.equals("Change")) change(splitNow);
        }

        return result;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(T.solution(record));
    }
}
