import java.io.*;

public class Main {

  static int n;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    dfs(2, 1);
    dfs(3, 1);
    dfs(5, 1);
    dfs(7, 1);
  }

  public static void dfs(int x, int d) {
    if (d == n) {
      System.out.println(x);
      return;
    }

    for (int i = 1; i < 10; i+=2) {
      if (isPrime(x * 10 + i)) {
        dfs(x * 10 + i, d + 1);
      }
    }
  }


  public static boolean isPrime(int x) {
    if (x <= 1) return false;

    for (int i = 2; i * i <= x; i++)
      if (x % i == 0)
        return false;
    return true;
  }
}
