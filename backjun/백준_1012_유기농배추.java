package backjun;

import java.util.*;
public class 백준_1012_유기농배추 {
    static int m, n;
    static int[][] arr;
    static boolean[][] visited;
    static int count;
    static int[] dx = {-1, 1, 0, 0}; // 좌 우 상 하
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            arr = new int[n][m];
            visited = new boolean[n][m];
            count = 0;

            for (int j = 0; j < k; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[b][a] = 1;
            }
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (arr[j][l] == 1 && !visited[j][l]){
                        count++;
                        bfs(j, l);
                    }
                }

            }
            System.out.println(count);
        }
    }
    static void dfs(int y, int x){
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if (tempX >=0 && tempY >= 0 && tempX < m && tempY < n){
                if (!visited[tempY][tempX] && arr[tempY][tempX] == 1){
                    dfs(tempY, tempX);
                }
            }
        }
    }
    static class Node{
        int x;
        int y;
        public Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(int y, int x){
        visited[y][x] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = node.x + dx[i];
                int tempY = node.y + dy[i];
                if (tempX >=0 && tempY >= 0 && tempX < m && tempY < n) {
                    if (!visited[tempY][tempX] && arr[tempY][tempX] == 1) {
                        queue.add(new Node(tempY, tempX));
                        visited[tempY][tempX] = true;
                    }
                }

            }

        }

    }

}
