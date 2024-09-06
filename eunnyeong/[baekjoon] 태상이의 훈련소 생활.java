import java.util.*;
import java.io.*;

public class Main {

  static int n, m;
  static int[] a;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n];
    int[] diff = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
      if (i > 0)
        diff[i] = a[i] - a[i - 1];
      else
        diff[i] = a[i];
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());

      diff[a - 1] += x;
      if (b < n)
        diff[b] -= x;
    }

    a[0] = diff[0];
    for (int i = 1; i < n; i++)
      a[i] = a[i - 1] + diff[i];

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++)
      sb.append(a[i] + " ");
    
    System.out.print(sb.toString());
  }
}
