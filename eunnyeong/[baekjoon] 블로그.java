import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    int sum = 0;
    for (int i = 0; i < x; i++)
      sum += a[i];

    int max = sum, cnt = 1;
    for (int i = x; i < n; i++) {
      sum -= a[i - x];
      sum += a[i];

      if (max == sum)
        cnt++;

      if (max < sum) {
        cnt = 1;
        max = sum;
      }
    }

    if (max == 0)
      System.out.print("SAD");
    else {
      System.out.print(max + "\n" + cnt);
    }
  }
}
