import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    a = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(a);

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++){
      int x = Integer.parseInt(st.nextToken());
      sb.append(binary_search(0, n - 1, x) + "\n");
    }

    System.out.print(sb.toString());
  }

  public static int binary_search(int l, int r, int t) {
    while (l <= r) {
      int m = (l + r) / 2;

      if (a[m] == t)
        return 1;

      if (a[m] > t)
        r = m - 1;
      else
        l = m + 1;
    }

    return 0;
  }
}
