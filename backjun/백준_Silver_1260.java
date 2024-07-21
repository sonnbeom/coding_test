package backjun;

import java.util.*;

public class 백준_Silver_1260 {
    static int node, edge, start;
    static int[][] arr;
    static boolean visited[];
    static List<Integer> answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        node = sc.nextInt();
        edge = sc.nextInt();
        start = sc.nextInt();
        arr = new int[node+1][node+1];
        visited = new boolean[node+1];
        for (int i = 0; i < edge; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }
        answer = new ArrayList<>();
        dfs(start);
        for (int answer : answer){
            System.out.print(answer+" ");
        }
        System.out.println();

        visited = new boolean[node+1];
        answer = new ArrayList<>();
        bfs(start);
        for (int answer : answer){
            System.out.print(answer+" ");
        }

    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        answer.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int temp = queue.poll();
            for (int i = 1; i <= node; i++){
                if (!visited[i] && arr[temp][i] == 1){
                    queue.add(i);
                    answer.add(i);
                    visited[i] = true;
                }
            }
        }

    }
    static void dfs(int start){
        visited[start] = true;
        answer.add(start);

        if (answer.size() == node){
            return;
        }
        for (int i = 1; i <= node; i++) {
            if (arr[start][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }

    }
}


