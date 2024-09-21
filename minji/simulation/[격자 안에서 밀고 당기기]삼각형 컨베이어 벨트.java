import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[n * 3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i * n + j] = Integer.parseInt(st.nextToken());
            }
        }
        int prevEnd = n - 1;
        int end = prevEnd - t;
        while(end < 0){
            end = (end + arr.length) % arr.length;
        }
        int start = (end - n + 1 + arr.length) % arr.length;
        int cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            int index = (start + i) % arr.length;
            System.out.print(arr[index] + (cnt % n == 0 ? "\n" : " "));
            cnt++;
        }

    }

}
