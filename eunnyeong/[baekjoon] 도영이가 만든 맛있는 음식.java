import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  static int n, ans;
  static Point[] a;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    a = new Point[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      a[i] = new Point(x, y);
    }

    ans = Integer.MAX_VALUE;
    dfs(new boolean[n], 0);

    System.out.print(ans);
  }

  public static void dfs(boolean[] visit, int idx) {
    if (idx == n) {
      int s = 1, b = 0, f = 0;
      for (int i = 0; i < n; i++) {
        if (visit[i]) {
          s *= a[i].x;
          b += a[i].y;
          f = 1;
        }
      }
      if (f == 1)
        ans = Math.min(ans, Math.abs(s - b));
      return;
    }

    visit[idx] = true;
    dfs(visit, idx + 1);

    visit[idx] = false;
    dfs(visit, idx + 1);
  }
}
