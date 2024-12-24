import java.util.*;
import java.io.*;

public class Main {

  static int n, ans, mp, mf, ms, mv;
  static Point[] a;
  static List<List<Integer>> list;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    mp = Integer.parseInt(st.nextToken());
    mf = Integer.parseInt(st.nextToken());
    ms = Integer.parseInt(st.nextToken());
    mv = Integer.parseInt(st.nextToken());

    a = new Point[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken());
      int f = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      a[i] = new Point(p, f, s, v, c);
    }

    ans = Integer.MAX_VALUE;
    list = new ArrayList<>();
    dfs(new boolean[n], 0);

    if (ans == Integer.MAX_VALUE)
      ans = -1;
    System.out.println(ans);

    Collections.sort(list, new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> o1, List<Integer> o2) {
        int min = Math.min(o1.size(), o2.size());
        for (int i = 0; i < min; i++) {
            if (o1.get(i) != o2.get(i))
              return o1.get(i) - o2.get(i);
        }
        return Integer.compare(o1.size(), o2.size());
      }
    });

    if (ans != -1)
      for (Integer i : list.get(0))
        System.out.print(i + " ");
  }

  public static void dfs(boolean[] visit, int idx) {
    if (idx == n) {
      int p = 0, f = 0, s = 0, v = 0, c = 0, check = 0;
      for (int i = 0; i < n; i++) {
        if (visit[i]) {
          p += a[i].p;
          f += a[i].f;
          s += a[i].s;
          v += a[i].v;
          c += a[i].c;
          check = 1;
        }
      }
      if (check == 1 && p >= mp && f >= mf && s >= ms && v >= mv) {
        if (ans >= c) {
          if (ans > c)
            list = new ArrayList<>();

          List<Integer> t = new ArrayList<>();
          for (int i = 0; i < n; i++)
            if (visit[i])
              t.add(i + 1);

          list.add(t);
          ans = c;
        }
      }
      return;
    }

    visit[idx] = true;
    dfs(visit, idx + 1);

    visit[idx] = false;
    dfs(visit, idx + 1);
  }

  static class Point {
    int p, f, s, v, c;

    public Point(int p, int f, int s, int v, int c) {
      this.p = p;
      this.f = f;
      this.s = s;
      this.v = v;
      this.c = c;
    }
  }
}
