import java.io.*;
import java.util.*;

public class Main {

  static int min, x, y;
  static int[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    a = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(a);

    min = Integer.MAX_VALUE;
    x = -1;
    y = -1;
    for (int i = 0; i < n - 1; i++) {
      int close = binary_search(i + 1, n - 1, -a[i]);
      int sum = Math.abs(a[i] + a[close]);

      if (sum < min) {
        x = i;
        y = close;
        min = sum;
      }
    }

    System.out.print(a[x] + " " + a[y]);
  }

  public static int binary_search(int left, int right, int target) {
    int close = left;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (Math.abs(a[mid] - target) < Math.abs(a[close] - target))
        close = mid;

      if (a[mid] < target)
        left = mid + 1;
      else
        right = mid - 1;
    }

    return close;
  }
}
