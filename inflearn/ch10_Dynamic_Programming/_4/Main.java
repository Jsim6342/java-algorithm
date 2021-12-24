package inflearn.ch10_Dynamic_Programming._4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 10-4. 가장 높은 탑 쌓기
class Block implements Comparable<Block>{
    int width;
    int height;
    int weight;

    public Block(int width, int height, int weight) {
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Block o) {
        return o.width - this.width;
    }

    @Override
    public String toString() {
        return "Block{" +
                "width=" + width +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}

class Main {

    static int n;
    static int answer;
    static ArrayList<Block> arr = new ArrayList<>();
    static int[] dy;

    public void solution() {
        Collections.sort(arr);
        dy[0] = arr.get(0).height;
        for (int i = 1; i < n; i++) {
            dy[i] = arr.get(i).height;
            for (int j = i; j >= 0 ; j--) {
                  if(arr.get(j).weight > arr.get(i).weight) {
                      dy[i] = Math.max(dy[i], dy[j] + arr.get(i).height);
                  }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            arr.add(new Block(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        T.solution();

        System.out.println(Arrays.stream(dy).max().getAsInt());

    }
}
