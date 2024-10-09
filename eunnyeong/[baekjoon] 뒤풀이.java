import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());

    Point[] list = new Point[n];
    long l = Integer.MAX_VALUE, r = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      list[i] = new Point(x, y);
      if (l > x)
        l = x;
      if (r < y)
        r = y;
    }

    long ans = Integer.MAX_VALUE;
    while (l <= r) {
      long mid = l + (r - l) / 2;

      int upper = 0, lower = 0, f = 0;
      for (int i = 0; i < n; i++) {
       Point p = list[i];
       if (p.x > mid) {
         l = mid + 1;
         f = 1;
         break;
       }
       lower += p.x;
       upper += Math.min(mid, p.y);
      }

      if (f == 0) {
        if (lower <= t && upper >= t) {
          ans = mid;
          r = mid - 1;
        }
        else if (lower > t)
          r = mid - 1;
        else
          l = mid + 1;
      }
    }

    if (ans == Integer.MAX_VALUE)
      ans = -1;

    System.out.print(ans);
  }
}
