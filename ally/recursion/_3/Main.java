package ally.recursion._3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 백준 6603번. 로또
 * 링크: https://www.acmicpc.net/problem/6603
*/
class Main {
    static int k;
    static int[] s;
    static int[] ans = new int[6];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if(k == 0) break;

            s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            backtrack(0, 0);
            System.out.println();
        }
    }

    private static void backtrack(int start, int depth) {
        if(depth == 6) {
            for(int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < s.length; i++) {
            ans[depth] = s[i];
            backtrack(i+1, depth+1);
        }
    }


}
