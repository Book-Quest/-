import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] cnt, check;
    static int ans;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String c = br.readLine();
        check = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            check[i] = Integer.parseInt(st.nextToken());

        ans = 0;
        int left = 0, right = p - 1;
        cnt = new int[4];
        for (int i = 0; i < p; i++)
            plus(c.charAt(i));
        
        while (true) {
            int x = right - left + 1;
            if (x < p) {
                right++;
                if (right >= s) break;
                plus(c.charAt(right));
            }
            else {
                if (x == p)
                    count();
                minus(c.charAt(left));
                left++;
                if (left >= s) break;
            }
        }

        System.out.print(ans);
    }

    public static void count() {
        int f = 0;
        
        for (int i = 0; i < 4; i++)
            if(cnt[i] >= check[i])
                f++;

        if (f == 4)
            ans++;
    }

    public static void plus(char c) {
        if (c == 'A')
            cnt[0]++;
        else if (c== 'C')
            cnt[1]++;
        else if (c == 'G')
            cnt[2]++;
        else if (c == 'T')
            cnt[3]++;
    }

    public static void minus(char c) {
        if (c == 'A')
            cnt[0]--;
        else if (c== 'C')
            cnt[1]--;
        else if (c == 'G')
            cnt[2]--;
        else if (c == 'T')
            cnt[3]--;
    }
}
