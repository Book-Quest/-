import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    a = new int[n];
    long sum = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
      sum += a[i];
    }

    int m = Integer.parseInt(br.readLine());

    Arrays.sort(a);

    int ans = 0;
    if (m >= sum) {
      ans = a[n - 1];
    }
    else {
      int l = 0, r = a[n - 1];

      while (l <= r) {
        int mid = (l + r) / 2;

        int idx = calc(mid);
        sum = (n - idx) * mid;
         if (idx == -1)
          sum = 0;
          
        for (int i = 0; i < idx; i++)
          sum += a[i];

        if (sum <= m) {
          ans = mid;
          l = mid + 1;
        }
        else
          r = mid - 1;
      }
    }

    System.out.print(ans);

  }
  public static int calc(int x) {
    for (int i = 0; i < n; i++) {
      if (a[i] > x)
        return i;
    }

    return -1;
  }
}
