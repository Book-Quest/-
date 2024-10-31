import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int w = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
      @Override
      public int compare(Point o1, Point o2) {
        if (o2.y == o1.y)
          return o2.x - o1.x;
        return o2.y - o1.y;
      }
    });

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      q.add(new Point(x, y));
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      Point p = q.poll();

      if (p.x <= w)
        ans += p.x * p.y;
      else
        ans += w * p.y;

      w -= p.x;

      if (w <= 0) break;
    }

    System.out.print(ans);
  }
}
