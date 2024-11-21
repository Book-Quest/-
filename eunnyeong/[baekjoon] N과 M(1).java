import java.util.*;
import java.io.*;

public class Main {

  static int n, m;
  static int[] select;
  static boolean[] visit;
  static StringBuilder sb;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    select = new int[m];
    visit = new boolean[n];
    sb = new StringBuilder();

    perm(0);
    bw.write(sb.toString());
    bw.flush(); bw.close(); br.close();
  }

  public static void perm(int cnt) {
    if (cnt == m) {
      for (int i = 0; i < m; i++)
        sb.append(select[i] + " ");
      sb.append("\n");
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visit[i]) {
        select[cnt] = i + 1;
        visit[i] = true;
        perm(cnt + 1);
        visit[i] = false;
      }
    }
  }
}
