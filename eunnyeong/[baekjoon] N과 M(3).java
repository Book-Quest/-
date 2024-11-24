import java.io.*;
import java.util.*;

public class Main {

  static int n, m;
  static int[] select;
  static StringBuilder sb;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    select = new int[m];
    sb = new StringBuilder();
    perm(0);
      
    System.out.print(sb.toString());
  }

  public static void perm(int cnt) {
    if (cnt == m) {
      for (int i = 0; i < m; i++)
        sb.append(select[i] + " ");
      sb.append("\n");
      return;
    }

    for (int i = 0; i < n; i++) {
        select[cnt] = i + 1;
        perm(cnt + 1);
    }
  }
}
