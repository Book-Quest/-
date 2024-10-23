import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(br.readLine());
      
    Arrays.sort(a);

    int s = 0, e = 0, ans = Integer.MAX_VALUE;
    while (true) {
      int sum = Math.abs(a[s] - a[e]);
      if (sum >= m) {
        ans = Math.min(ans, sum);
        s++;
      }
      else
        e++;

      if (e >= n || s >= n) break;
    }

    System.out.print(ans);
  }
}
