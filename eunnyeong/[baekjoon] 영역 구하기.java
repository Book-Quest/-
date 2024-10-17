import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

  static int m, n, k;
  static int[][] map;
  static boolean[][] visit;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
  static List<Integer> list;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    map = new int[m][n];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int y1 = Integer.parseInt(st.nextToken());
      int x1 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      for (int a = x1; a < x2; a++)
        for (int b = y1; b < y2; b++)
          map[a][b] = 1;
    }

    visit = new boolean[m][n];
    list = new ArrayList<>();
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (!visit[i][j] && map[i][j] == 0)
          bfs(i, j);

    Collections.sort(list);

    StringBuilder sb = new StringBuilder();
    sb.append(list.size() + "\n");

    for (Integer i : list)
      sb.append(i + " ");

    System.out.print(sb.toString());
  }

  public static void bfs(int x, int y) {
    visit[x][y] = true;
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y));
    int cnt = 1;

    while (!q.isEmpty()) {
      Point p = q.poll();

      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny] && map[nx][ny] == 0) {
          visit[nx][ny] = true;
          cnt++;
          q.add(new Point(nx, ny));
        }
      }
    }

    list.add(cnt);
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < m && ny >= 0 && ny < n;
  }
}
