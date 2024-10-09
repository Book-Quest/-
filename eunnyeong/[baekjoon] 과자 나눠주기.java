import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    long l = 1, r = Arrays.stream(a).max().getAsInt(), ans = 0;
    while (l <= r) {
      long mid = l + (r - l) / 2;

      long cnt = 0;
      for (int i = 0; i < n; i++) {
        if (a[i] >= mid && mid > 0)
          cnt += a[i] / mid;

        if (cnt >= m) {
          break;
        }
      }

      if (cnt < m)
        r = mid - 1;
      else {
        l = mid + 1;
        ans = mid;
      }
    }

    System.out.print(ans);
  }
}
