import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long n = Long.parseLong(br.readLine());

    long l = 1, r = n, cnt = 0;

    while (l <= r) {
      long m = (l + r) / 2;

      long sum = m * (m + 1) / 2;

      if (n < sum)
        r = m - 1;
      else {
        cnt = m;
        l = m + 1;
      }
    }

    System.out.print(cnt);
  }
}

