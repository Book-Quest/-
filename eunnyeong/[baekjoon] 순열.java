import java.io.*;
import java.util.*;

public class Main {

  static int ans, check;
  static char[] c, select;
  static boolean[] visit;
  static StringBuilder sb;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    sb = new StringBuilder();
    while (true) {
      String s = br.readLine();
      if (s == null || s.equals("")) break;

      StringTokenizer st = new StringTokenizer(s);
      c = st.nextToken().toCharArray();
      check = 0;
      ans = Integer.parseInt(st.nextToken());

      select = new char[c.length];
      visit = new boolean[c.length];

      sb.append(s + " = ");
      perm(0);

      if (check < ans)
        sb.append("No permutation\n");
    }

    System.out.print(sb.toString());
  }

  public static void perm(int cnt) {
    if (check >= ans) return;
    if (cnt == c.length) {
      check++;

      if (check == ans)
        sb.append(new String(select) + "\n");
      return;
    }

    for (int i = 0; i < c.length; i++) {
      if (!visit[i]) {
        select[cnt] = c[i];
        visit[i] = true;
        perm(cnt + 1);
        visit[i] = false;
      }
    }
  }
}
