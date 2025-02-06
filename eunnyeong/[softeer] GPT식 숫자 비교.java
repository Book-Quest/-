import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Point[] a = new Point[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), ".");
      int x = Integer.parseInt(st.nextToken());
      int y = -1;
      if (st.hasMoreTokens())
        y = Integer.parseInt(st.nextToken());

      a[i] = new Point(x, y);
    }

    Arrays.sort(a);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      Point p = a[i];

      sb.append(p.x);
      if (p.y != -1)
        sb.append("." + p.y);
      sb.append("\n");
    }

    System.out.print(sb.toString());
  }

  static class Point implements Comparable<Point>{

    int x, y;

    public Point (int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point o) {
      if (this.x == o.x)
        return this.y - o.y;
      return this.x - o.x;
    }
  }
}
