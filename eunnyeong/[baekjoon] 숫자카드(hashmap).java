import java.util.*;
import java.io.*;

public class Main {

  static int n, m;
  static int[] card;
  static HashMap<Integer, Integer> h;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    h = new HashMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(st.nextToken());
      h.put(x, h.getOrDefault(x, 0) + 1);
    }

    m = Integer.parseInt(br.readLine());
    card = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++)
      card[i] = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      int x = 0;
      if (h.containsKey(card[i]))
        x = h.get(card[i]);
      sb.append(x + " ");
    }

    System.out.print(sb.toString());
  }
}
