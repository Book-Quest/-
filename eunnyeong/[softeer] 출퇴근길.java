import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    List[] list = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++)
      list[i] = new ArrayList<Integer>();

    List[] reverse = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++)
      reverse[i] = new ArrayList<Integer>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      list[x].add(y);
      reverse[y].add(x);
    }

    st = new StringTokenizer(br.readLine());
    int s = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());

    // s -> t
    boolean[] v1 = new boolean[n + 1];
    v1[t] = true; //도착지는 한 번만 가야함
    dfs(s, v1, list);

    // s -> t를 역으로 가보면서 가능한지 체크 (단방향 그래프이기 때문에 체크 필요함), v1 - v2는 같은 경로이므로 체크
    boolean[] v2 = new boolean[n + 1];
    dfs(t, v2, reverse);

    // t -> s
    boolean[] v3 = new boolean[n + 1];
    v3[s] = true; //도착지는 한 번만 가야함
    dfs(t, v3, list);

    // t -> s를 역으로 가보면서 가능한지 체크 (단방향 그래프이기 때문에 체크 필요함), v3 - v4는 같은 경로이므로 체크
    boolean[] v4 = new boolean[n + 1];
    dfs(s, v4, reverse);

    int ans = 0;
    for (int i = 1; i <= n; i++)
      if (v1[i] && v2[i] && v3[i] && v4[i] && i != s && i != t) // v1-v2 | v3-v4 같은 경로인 것 중 공통적인거 + 시작, 도착 점 제외
        ans++;

    System.out.print(ans);
  }

  public static void dfs(int x, boolean[] visit, List[] list) {
    for (int i = 0; i < list[x].size(); i++) {
      int next = (Integer) list[x].get(i);
      if (!visit[next]) {
        visit[next] = true;
        dfs(next, visit, list);
      }
    }
  }
}
