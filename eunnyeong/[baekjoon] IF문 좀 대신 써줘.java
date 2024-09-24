import java.io.*;
import java.util.*;

public class Main {

  static int[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    String[] s = new String[n];
    a = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      s[i] = st.nextToken();
      a[i] = Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      int t = Integer.parseInt(br.readLine());
      int x = binary_search(0, n - 1, t);
      sb.append(s[x] + "\n");
    }

    System.out.print(sb.toString());
  }

  public static int binary_search(int l, int r, int t) {
    int x = 0;

    while (l <= r) {
      int m = (l + r) / 2;

      if (a[m] >= t) {
        x = m;
        r = m - 1;
      }
      else
        l = m + 1;
    }

    return x;
  }
}
