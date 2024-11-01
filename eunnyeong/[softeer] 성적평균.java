import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] a = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += Integer.parseInt(st.nextToken());
      a[i] = sum;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      double ans = (double) (a[y] - a[x - 1]) / (y - x + 1);

      sb.append(String.format("%.2f", ans) + "\n");
    }

    System.out.println(sb.toString());
  }
}
