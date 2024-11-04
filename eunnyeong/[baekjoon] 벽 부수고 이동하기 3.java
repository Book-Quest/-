import java.io.*;
import java.util.*;

public class Main {

  static int n, m, k, ans;
  static char[][] map;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    map = new char[n][m];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      map[i] = s.toCharArray();
    }

    ans = -1;
    boolean[][][] visit = new boolean[n][m][k + 1];
    Queue<Check> q = new ArrayDeque<>();
    q.add(new Check(0, 0, 1, 0, 0));
    visit[0][0][0] = true;

    while (!q.isEmpty()) {
      Check c = q.poll();
      if (c.x == n - 1 && c.y == m - 1) {
        ans = c.cnt;
        break;
      }

      int day = c.day;
      day = day == 0 ? 1 : 0;

      for (int i = 0; i < 4; i++) {
        int nx = c.x + dx[i], ny = c.y + dy[i];
        if (range(nx, ny)) {
          if (map[nx][ny] == '0' && !visit[nx][ny][c.f]) {
            visit[nx][ny][c.f] = true;
            q.add(new Check(nx, ny, c.cnt + 1, day, c.f));
          }
          if (map[nx][ny] == '1' && c.f < k && !visit[nx][ny][c.f + 1]) {
            if (c.day == 0) {
              visit[nx][ny][c.f + 1] = true;
              q.add(new Check(nx, ny, c.cnt + 1, day, c.f + 1));
            }
            else // 아무것도 안하고 다음날로 보냄
              q.add(new Check(c.x, c.y, c.cnt + 1, day, c.f));
          }
        }
      }
    }

    System.out.print(ans);
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < m;
  }

  static class Check {
    int x, y, cnt, day, f;

    public Check(int x, int y, int cnt, int day, int f) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
      this.day = day;
      this.f = f;
    }
  }
}
