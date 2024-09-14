import java.util.*;
import java.io.*;

// 0 또는 1로 이루어진 N * N 격자에서 3 * 3 크기의 서브격자를 적절히 선택하여 동전의 수를 최대로 하는 프로그램을 작성하라.
public class 최고의_33위치 {
    public static void main(String[] args) throws IOException {
        sol1(); // 다중 루프(115ms, 8MB)
        sol2(); // 누적합(93ms,	8MB)
    }

    private static void sol1() throws IOException {
        int ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int col = 0; col + 2 < N; col++) {
            for (int row = 0; row + 2 < N; row++) {
                int cnt = 0;
                for (int currCol = col; currCol <= col + 2; currCol++) {
                    for (int currRow = row; currRow <= row + 2; currRow++) {
                        cnt += graph[currRow][currCol];
                    }
                }
                ans = Math.max(cnt, ans);
            }
        }
        System.out.println(ans);
    }
    private static void sol2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefixSum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefixSum[i][j] = graph[i][j]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }

        /*
            (i-1,j-1)(i-1,j)(i-1,j+1)(i-1,j+2)
            (i,j-1)   (i,j)  (i,j+1)  (i, j+2)
            (i+1,j-1)(i+1,j)(i+1,j+1)(i+1,j+2)
            (i+2,j-1)(i+2,j)(i+2,j+1)(i+2,j+2)
         */
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i + 2 <= N; i++) {
            for (int j = 1; j + 2 <= N; j++) {
                int totalSum = prefixSum[i + 2][j + 2]
                        - prefixSum[i - 1][j + 2]
                        - prefixSum[i + 2][j - 1]
                        + prefixSum[i - 1][j - 1];
                maxSum = Math.max(maxSum, totalSum);
            }
        }
        System.out.println(maxSum);
    }
}
