package programmers._13;

import java.util.*;



class Main {

    static int[] dis;
    static ArrayList<ArrayList<Integer>> graph;

    public int solution(int n, int[][] edge)  {
        int answer = 0;

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }


        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dis[1] = 0;
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            int nowCost = dis[nowNode];
            for (int nextNode : graph.get(nowNode)) {
                if(dis[nextNode] > nowCost + 1) {
                    dis[nextNode] = nowCost + 1;
                    q.add(nextNode);
                }
            }
        }
        int maxNum = Arrays.stream(dis).filter(x -> x != Integer.MAX_VALUE).max().getAsInt();
        for (int x : dis) {
            if(x == maxNum) answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(T.solution(n, vertex));
    }


}
