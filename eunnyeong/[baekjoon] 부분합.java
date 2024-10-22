import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    int s = 0, e = 0, sum = a[0], ans = n + 1;
    while (true) {
      if (sum < m) {
        e++;
        if (e >= n) break;
        sum += a[e];
      }
      else {
        ans = Math.min(ans, e - s + 1);
        sum -= a[s];
        s++;
      }
    }
    
    if (ans == n + 1)
      ans = 0;

    System.out.print(ans);
  }
}
