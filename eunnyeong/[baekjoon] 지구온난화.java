import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

  static int r, c;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    char[][] map = new char[r][c];
    char[][] fifty = new char[r][c];
    Queue<Point> q = new ArrayDeque<>();

    for (int i = 0; i < r; i++) {
      String s = br.readLine();
      for (int j = 0; j < c; j++) {
        char ch = s.charAt(j);
        map[i][j] = ch;
        fifty[i][j] = ch;
        if (ch == 'X')
          q.add(new Point(i, j));
      }
    }

    int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
    while (!q.isEmpty()) {
      Point p = q.poll();

      int cnt = 0;
      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (!range(nx, ny) || (range(nx, ny) && map[nx][ny] == '.'))
          cnt++;
      }

      if (cnt >= 3)
        fifty[p.x][p.y] = '.';
    }

    int x1 = r, y1 = c, x2 = 0, y2 = 0;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (fifty[i][j] == 'X') {
          x1 = Math.min(i, x1);
          x2 = Math.max(i, x2);
          y1 = Math.min(j, y1);
          y2 = Math.max(j, y2);
        }
      }

    }

    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++)
        System.out.print(fifty[i][j]);
      System.out.println();
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < r && ny >= 0 && ny < c;
  }
}
