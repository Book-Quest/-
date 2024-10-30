import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] line = new int[2*n];
        for (int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) 
                line[n*i+j] = Integer.parseInt(st.nextToken());
        }
        
        int[] newLine = new int[2*n];
        for (int i=0; i<2*n; i++) {
            int idx = (i+t)%(2*n);
            newLine[idx] = line[i];
        }

        for (int i=0; i<2; i++) {
            for (int j=0; j<n; j++)
                System.out.print(newLine[n*i+j]+" ");
            System.out.println();
        }

    }
}
