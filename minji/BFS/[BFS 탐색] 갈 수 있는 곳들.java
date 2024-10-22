import java.util.*;
import java.io.*;

// 방문 가능한 노드들의 합집합 // 각 노드 별로 방문 여부 관리할 필요 없이 하나의 배열로 방문 여부 체크
public class Main {
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int n, k, ans;
    static int[][] starts, grid;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ans = 0;
        grid = new int[n][n];
        starts = new int[k][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            starts[i][0] = Integer.parseInt(st.nextToken()) - 1;
            starts[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        BFS();
        System.out.print(ans);
    }

    private static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        for (int[] start : starts) {
            if (!visited[start[0]][start[1]]) {
                q.add(start);
                visited[start[0]][start[1]] = true;
                ans++; // check-1 (시작 노드들도 카운트에 포함)
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[1], y = curr[0];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < n && nx < n) {
                    if (!visited[ny][nx] && grid[ny][nx] == 0) { // check-2 (하나의 배열로 방문 여부 체크)
                        visited[ny][nx] = true;
                        ans++;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
