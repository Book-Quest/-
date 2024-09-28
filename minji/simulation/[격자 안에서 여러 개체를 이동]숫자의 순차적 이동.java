import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = new int[]{-1, -1, -1,  0, 0,  1, 1, 1};
    static int[] dy = new int[]{ -1, 0,  1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];
        int[][] idx = new int[(n * n) + 1][2]; // 1부터 순차적으로 타겟을 삼으므로 각 타겟 인덱스 저장 *
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                graph[i][k] = Integer.parseInt(st.nextToken());
                idx[graph[i][k]][0] = i;
                idx[graph[i][k]][1] = k;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int k = 1; k < (n * n) + 1; k++) {
                int row = idx[k][0];
                int col = idx[k][1];
                int target = 0;
                int[] targetIdx = new int[2];
                for (int j = 0; j < 8; j++) {
                    int nRow = row + dy[j];
                    int nCol = col + dx[j];
                    if (0 <= nCol && nCol < n && 0 <= nRow && nRow < n) {
                        if (target < graph[nRow][nCol]) {
                            target = graph[nRow][nCol];
                            targetIdx = new int[]{nRow, nCol};
                        }
                    }
                }
                int tmp = graph[row][col];
                // 1-a.swap
                graph[row][col] = graph[targetIdx[0]][targetIdx[1]];
                // 1-b.타겟의 인덱스 배열도 swap
                idx[graph[targetIdx[0]][targetIdx[1]]] = new int[]{row,col};
                // 2.swap
                graph[targetIdx[0]][targetIdx[1]] = tmp;
                // 2-b.타겟의 인덱스 배열도 swap
                idx[tmp] = new int[]{targetIdx[0],targetIdx[1]};
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j]);
                if (j != n - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
