import java.util.*;
import java.io.*;

public class Main {

  static int n, m;
  static int[] a, card;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    a = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(a);

    m = Integer.parseInt(br.readLine());
    card = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++)
      card[i] = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      int f = findFirst(card[i]), e = findLast(card[i]);
      int x = e - f + 1;
      if (e == -1 && f == -1)
        x = 0;
      sb.append(x + " ");
    }

    System.out.print(sb.toString());
  }

  public static int findFirst(int target) {
    int low = 0, high = n - 1, firstIndex = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (a[mid] == target) {
        firstIndex = mid;  // 값 찾았으나, 더 왼쪽이 있을 수 있음
        high = mid - 1;  // 왼쪽 부분 탐색
      } else if (a[mid] < target) {
        low = mid + 1;  // 오른쪽으로 이동
      } else {
        high = mid - 1;  // 왼쪽으로 이동
      }
    }

    return firstIndex;
  }
  
  public static int findLast(int target) {
    int low = 0, high = n - 1, lastIndex = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (a[mid] == target) {
        lastIndex = mid;  // 값 찾았으나, 더 오른쪽이 있을 수 있음
        low = mid + 1;  // 오른쪽 부분 탐색
      } else if (a[mid] < target) {
        low = mid + 1;  // 오른쪽으로 이동
      } else {
        high = mid - 1;  // 왼쪽으로 이동
      }
    }

    return lastIndex;
  }
}
