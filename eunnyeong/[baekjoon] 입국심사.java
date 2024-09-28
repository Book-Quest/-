import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    long[] a = new long[n];
    for (int i = 0; i < n; i++)
      a[i] = Long.parseLong(br.readLine());

    Arrays.sort(a);

    long l = a[0], r = a[n - 1] * m; // 1개 최소 처리값, m개 최대 처리값
    while (l <= r) {
      long mid = (l + r) / 2;

      long cnt = 0;
      for (int i = 0; i < n; i++) {
        cnt += mid / a[i]; // 게이트가 처리 가능한 수 
        if (cnt >= m) break;
      }

      if (cnt < m)
        l = mid + 1; //가능한 값 중 가장 작음
      else
        r = mid - 1;
    }

    System.out.print(l);
  }
}
