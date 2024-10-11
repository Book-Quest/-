import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

  static int n, ans;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
  static int[][] map;
  static List<Point> h;
  static Point s, e;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    map = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++)
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    h = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      if (i == 0)
        s = new Point(x, y);
      else if (i == m - 1)
        e = new Point(x, y);
      else
        h.add(new Point(x, y));
    }

    ans = 0;
    dfs(s, new boolean[n + 1][n + 1], new ArrayList<>());
    System.out.print(ans);
  }

  public static void dfs(Point p, boolean[][] visit, List<Point> v) {
    if (p.x == e.x && p.y == e.y) {
      if (v.size() != h.size()) return;
      int f = 0;

      for (int i = 0; i < v.size(); i++) {
        if (!v.get(i).equals(h.get(i))) {
          f = 1;
          break;
        }
      }

      if (f == 0)
        ans++;
      return;
    }

    visit[p.x][p.y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = p.x + dx[k], ny = p.y + dy[k];

      if (range(nx, ny) && !visit[nx][ny] && map[nx][ny] != 1) {
        Point n = new Point(nx, ny);
        if (h.contains(n)){
          v.add(n);
          dfs(n, visit, v);
          v.remove(n);
        }
        else
         dfs(n, visit, v);
      }
    }

    visit[p.x][p.y] = false;
  }

  public static boolean range(int nx, int ny) {
    return nx > 0 && nx <= n && ny > 0 && ny <= n;
  }
}
