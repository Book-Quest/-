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

    ans = 0;
    dfs(0, 0);

    System.out.print(ans);
  }

  public static void dfs(int cnt, int sum) {
    if (cnt >= n) {
      if (cnt == n)
      ans = Math.max(ans, sum);
      return;
    }

    dfs(cnt + a[cnt].x, sum + a[cnt].y);
    dfs(cnt + 1, sum);
  }
}
