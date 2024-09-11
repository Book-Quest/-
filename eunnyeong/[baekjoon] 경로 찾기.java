import java.util.*;
import java.io.*;

public class Main {

  static int n;
  static int[][] map, ans;
  static List<Integer> list[];
  static boolean[][] visit;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    list = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      list[i] = new ArrayList<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 1)
          list[i].add(j);
      }
     }

    ans = new int[n][n];
    visit = new boolean[n][n];
    for (int i = 0; i < n; i++)
      dfs(i, i);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        sb.append(ans[i][j] + " ");
      sb.append("\n");
    }

    System.out.print(sb.toString());
  }

  public static void dfs(int start, int x) {
    for (int i = 0; i < list[x].size(); i++) {
      int j = list[x].get(i);
      if (ans[start][j] == 0) {
        ans[start][j] = 1;
        dfs(start, j);
      }
    }
  }
}
