import java.io.*;
import java.util.*;

public class Main {

  static int[] a, select;
  static int n, m, k, ans;
  static boolean[] visit;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    visit = new boolean[n];
    select = new int[n];
    ans = Integer.MAX_VALUE;
    perm(0);

    System.out.print(ans);
  }

  public static void calc() {
    int sum = 0, t = 0, idx = 0, cnt = 0;

    while (true) {
      t += select[idx];

      if (t >= m) {
        if (t != m) {
          t -= select[idx];
          sum += t;
          t = select[idx];
        }
        else {
          sum += t;
          t = 0;
        }

        cnt++;
        if (cnt == k) {
          ans = Math.min(ans, sum);
          return;
        }
      }

      idx++;
      if (idx == n)
        idx = 0;
    }
  }

  public static void perm(int idx) {
    if (idx == n) {
      calc();
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visit[i]) {
        visit[i] = true;
        select[idx] = a[i];
        perm(idx + 1);
        visit[i] = false;
      }
    }
  }
}
