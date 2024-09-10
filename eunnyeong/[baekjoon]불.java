import java.util.*;
import java.io.*;

public class Main {

  static int w, h, f, fs;
  static char[][] map;
  static int[] dx = {-1, 0, 0, 1}, dy = {0, 1, -1, 0};
  static Queue<Point> fq;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int tc = 0; tc < t; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      h = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());

      map = new char[w][h];
      fq = new ArrayDeque<>();
      int x = -1, y = -1;
      for (int i = 0; i < w; i++) {
        String s = br.readLine();
        for (int j = 0; j < h; j++) {
          map[i][j] = s.charAt(j);
          if (map[i][j] == '@') {
            x = i; y = j;
          }
          if (map[i][j] == '*')
            fq.add(new Point(i, j, 0));
        }
      }

      fs = fq.size();
      f = -1;
      bfs(x, y);

      if (f != -1)
        sb.append(f + "\n");
      else
        sb.append("IMPOSSIBLE\n");
    }

    System.out.print(sb.toString());

  }

  public static void bfs(int x, int y) {
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y, 0));
    boolean[][] visit = new boolean[w][h];
    visit[x][y] = true;

    int chk = 0;
    while (!q.isEmpty()) {
      Point p = q.poll();

      if (chk == p.c) {
        fire();
        chk++;
      }

      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (!range(nx, ny)) {
          f = p.c + 1;
          return;
        }
        if (range(nx, ny) && !visit[nx][ny] && map[nx][ny] == '.') {
          visit[nx][ny] = true;
          q.add(new Point(nx, ny, p.c + 1));
        }
      }

    }
  }

  public static void fire() {
   for (int i = 0; i < fs; i++) {
     Point p = fq.poll();
     for (int k = 0; k < 4; k++) {
       int nx = p.x + dx[k], ny = p.y + dy[k];
       if (range(nx, ny) && map[nx][ny] == '.') {
         map[nx][ny] = '*';
         fq.add(new Point(nx, ny, p.c + 1));
       }
     }
   }

   fs = fq.size();
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < w && ny >= 0 && ny < h;
  }

  static class Point {
    int x, y, c;
    public Point(int x, int y, int c) {
      this.x = x;
      this.y = y;
      this.c = c;
    }
  }
}
