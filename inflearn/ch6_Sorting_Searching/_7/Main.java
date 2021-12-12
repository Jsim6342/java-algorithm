package inflearn.ch6_Sorting_Searching._7;
import java.util.*;

// 6-7. 좌표 정렬
class Main {

    static class Spot {
        int num1;
        int num2;

        public Spot(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public String toString() {
            return "Spot{" +
                    "num1=" + num1 +
                    ", num2=" + num2 +
                    '}';
        }
    }

    public ArrayList<Spot> solution(int n, ArrayList<Spot> arr) {


        Collections.sort(arr, (o1, o2) -> {
                    if(o1.num1 == o2.num1) return o1.num2 - o2.num2;
                    else return o1.num1 - o2.num1;
                }
        );


        return arr;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Spot> arr = new ArrayList<>();
    
        for(int i = 0; i < n; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            arr.add(new Spot(num1, num2));
        }

        for(Spot spot : T.solution(n, arr)) {
            System.out.println(spot.num1 + " " + spot.num2);
        }

    }
}
