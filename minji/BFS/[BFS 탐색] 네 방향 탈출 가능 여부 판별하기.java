import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = new int[]{1, 0, -1, 0}; 
    static int[] dy = new int[]{0, 1, 0, -1}; 
    static int n, m, ans;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 0;
        grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < m; k++) {
                grid[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();
        System.out.println(ans);
    }

    private static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{0, 0}); 
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == n-1 && curr[1] == m-1) { 
                ans = 1;
                return; // check-1
            }

            for(int i = 0; i < 4; i++) {
                int nx = curr[1] + dx[i];
                int ny = curr[0] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n) { // check-2
                    if(!visited[ny][nx] && grid[ny][nx] == 1) {
                        visited[ny][nx] = true; // check-3
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
