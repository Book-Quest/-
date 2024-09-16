import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
  static String[] s;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    s = new String[n];
    for (int i = 0; i < n; i++)
      s[i] = br.readLine();

    Arrays.sort(s);

    int ans = 0;
    for (int i = 0; i < m; i++)
      if (binarySearch(br.readLine()))
        ans++;

    System.out.print(ans);
  }

  public static boolean binarySearch(String word) {
    int left = 0, right = s.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (s[mid].equals(word))
        return true;

      if (s[mid].compareTo(word) < 0)
        left = mid + 1;
      else if (s[mid].compareTo(word) > 0)
        right = mid - 1;

    }
    return false;
  }
}
