import java.io.*;
import java.util.*;

public class Main {

  static int n, m;
  static int[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n];
    int low = 0, high = 0;
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
      high += a[i];
      if (low < a[i])
        low = a[i];
    }

    int ans = high;

    while (low <= high) {
      int mid = (low + high) / 2;

      int cnt = 1, sum = 0;

      for (int i = 0; i < n; i++) {
        if (sum + a[i] > mid) {
          cnt++;
          sum = a[i];
        } else
          sum += a[i];
      }

      if (cnt <= m) {
        ans = mid;
        high = mid - 1;
      } else
        low = mid + 1;
    }

    System.out.print(ans);
  }
}
