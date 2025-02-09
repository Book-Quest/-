import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] a = new int[8];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 8; i++)
      a[i] = Integer.parseInt(st.nextToken());

    String s = "mixed";
    if (a[0] == 1)
      s = "ascending";
    if (a[0] == 8)
      s = "descending";

    int x = a[0];
    for (int i = 1; i < 8; i++) {
      if (Math.abs(x - a[i]) != 1) {
        s = "mixed";
        break;
      }
      else
        x = a[i];
    }

    System.out.print(s);
  }
}
