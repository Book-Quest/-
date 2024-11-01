import java.util.*;

public class Main {
    static int n;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 1];

        if(n == 2 || n == 3) {
            System.out.println(1);
            return;
        }
        
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<n+1; i++){
            dp[i] = (dp[i-2] + dp[i-3]) % 10007;
        }
        System.out.print(dp[n]);
    }
}
