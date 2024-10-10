import java.io.*;
import java.util.*;

public class Main {

  static int[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());

    a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(a);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < q; i++) {
      int t = Integer.parseInt(br.readLine());
      int x = binary_search(0, n - 1, t);
      int ans = x * (n - x - 1);
      sb.append( ans+ "\n");
    }

    System.out.print(sb.toString());
  }

  public static int binary_search(int l, int r, int target) {
    while (l <= r) {
      int mid = l + (r - l) / 2;

      if (a[mid] == target)
        return mid;

      if (a[mid] < target)
        l = mid + 1;
      else
        r = mid - 1;
    }

    return 0;
  }
}
