// 숫자 이동 (0빈칸, 1벽) - 상하좌우, 미방문칸 이동
// m개의 지점을 순서대로 방문
// 차량이 이동가능한 서로 다른 가지 수
import java.io.*;
import java.util.*;

public class Main {

    public static int n,m;
    public static int[][] graph;
    public static int[][] loc;
    public static boolean[][] visited;
    public static int count=0;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        visited = new boolean[n][n];
        loc = new int[m][2];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            loc[i][0] = Integer.parseInt(st.nextToken())-1;
            loc[i][1] = Integer.parseInt(st.nextToken())-1;
        }

        // 출발
        visited[loc[0][0]][loc[0][1]] = true;
        dfs(loc[0][0], loc[0][1],1);

        System.out.println(count);
    }

    private static boolean dfs(int x, int y, int idx) {
        if (x==loc[idx][0] && y==loc[idx][1]) {
            // 마지막 지점 도착
            if (idx == m-1) {
                count += 1;
                return true;
            }
            // 중간 지점 도착
            idx += 1;
        }
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && graph[nx][ny]==0) {
                visited[nx][ny] = true;
                dfs(nx,ny,idx);
                visited[nx][ny] = false;
            }
        }
        return false;
    }
}
