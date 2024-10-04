import java.io.*;
import java.util.*;

public class Main {

  static int n, ans, x , y;
  static int[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    a = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(a);

    ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++)
      binary_search(i + 1, n - 1, a[i]);

    System.out.print(x + " " + y);
  }

  public static void binary_search(int l, int r, int target) {
    while (l <= r) {
      int mid = (l + r) / 2;

      int t = target + a[mid];
      int c = Math.abs(t);
      if (c < ans) {
        ans = c;
        x = target;
        y = a[mid];
      }

      if (t < 0)
        l = mid + 1;
      else
        r = mid - 1;
    }
  }
}
