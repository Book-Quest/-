import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

  static int[][] a;
  static int[] dx = {1, 0, 0, -1}, dy = {0, -1, 1, 0};
  static int n, m, ans;
  static Point[] list;
  static boolean[][][] visit;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    list = new Point[m];
    visit = new boolean[n][n][m];
    ans = 0;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      list[i] = new Point(x, y);
      visit[x][y][i] = true;
    }

    Point p = list[0];
    dfs(p.x, p.y, 0, 0, a[p.x][p.y]);
    System.out.print(ans);
  }
  public static void dfs(int x, int y, int d, int cnt, int sum) {
    if (d == 3) {
      if (cnt + 1 < m) {
        Point p = list[cnt + 1];
        dfs(p.x, p.y, 0, cnt + 1, sum + a[p.x][p.y]);
      }
      else
        ans = Math.max(sum, ans);

      return;
    }
      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k], ny = y + dy[k];
        if (range(nx, ny) && !visit[nx][ny][cnt]) {
          visit[nx][ny][cnt] = true;

          int t = sum, f = 0;
          for (int i = m - 1; i >= 0; i--) {
            if (visit[nx][ny][i] && i != cnt) {
              f++;
              break;
            }
          }
          if (f == 0)
            t += a[nx][ny];

          dfs(nx, ny, d + 1, cnt, t);
          visit[nx][ny][cnt] = false;
        }
      }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}
