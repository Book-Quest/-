import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int[][] graph;
    static boolean[][] visited;
    static int n, m, ans;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new int[n][m];
        visited = new boolean[n][m]; 
        ans = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(new int[]{0,0}); 
        System.out.println(ans);
    }

    private static void DFS(int[] curr) {
        if (ans == 1) { // check-1(이미 도착점에 도달했을 경우, 더 이상 진행하지 않음)
            return;
        }
        if (curr[0] == n - 1 && curr[1] == m - 1) { 
            ans = 1;
            return;
        }
        if (graph[curr[0]][curr[1]] != 0 && !visited[curr[0]][curr[1]]) { 
            visited[curr[0]][curr[1]] = true; // check-2 (도착 가능한지 여부만을 확인하기 위함으로, visted를 다시 False로 복구하지 않고 시간복잡도 O(N×M) 확보 필요)

            for (int i = 0; i < 2; i++) {
                int y = curr[0] + dy[i];
                int x = curr[1] + dx[i];
                if (y >= 0 && x >= 0 && y < n && x < m) {
                    if (graph[y][x] != 0) {
                        DFS(new int[]{y,x});
                    }
                }
            }
        }
    }
}
