import java.io.*;
import java.util.*;

public class Main {

  static int n, c;
  static int[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    a = new int[n];

    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(br.readLine());

    Arrays.sort(a);

    int l = 1, r = a[n - 1] - a[0], ans = -1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (check(mid) >= c) {
        if (check(mid) == c)
          ans = mid;
        l = mid + 1;
      }
      else
        r = mid - 1;
    }

    System.out.print(ans);
  }

  public static int check(int d) {
    int past = a[0], cnt = 1;

    for (int i = 1; i < n; i++) {
      if (a[i] - past >= d) {
        past = a[i];
        cnt++;
      }
    }

    return cnt;
  }
}
