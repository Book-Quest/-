import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] block = new int[n];
        for (int i=0; i<n; i++) {
            block[i] = Integer.parseInt(br.readLine());
        }

        int s,e,newN,idx;
        int[] newBlock;
        for (int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken())-1;
            e = Integer.parseInt(st.nextToken())-1;
            newN = n-(e-s+1);
            idx = 0;
            newBlock = new int[newN];
            for (int j=0; j<n; j++) {
                if (j<s || j>e)
                    newBlock[idx++] = block[j];
            }
            block = newBlock;
            n = newN;
        }
        System.out.println(n);
        for (int i=0; i<n; i++)
            System.out.println(block[i]);

    }
}
