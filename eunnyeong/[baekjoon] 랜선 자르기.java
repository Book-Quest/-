import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int k = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    int[] a = new int[k];
    long max = 0;
    for (int i = 0; i < k; i++) {
      a[i] = Integer.parseInt(br.readLine());
      if (a[i] > max)
        max = a[i];
    }

    max++; //min보다 값이 커야 하기 때문에

    long min = 0;

    while (min < max) {
      long mid = (max + min) / 2;

      long cnt = 0;
      for (int i = 0; i < k; i++)
        cnt += a[i] / mid;

     if (cnt < n) {
        max = mid;  // 최댓값 갱신하며 이동
      } else {
        min = mid + 1; //큰수로 이동
      }
    }

    System.out.print(min - 1); // 마지막에 +1 돼서 나오기 때문에 -1
  }

}
