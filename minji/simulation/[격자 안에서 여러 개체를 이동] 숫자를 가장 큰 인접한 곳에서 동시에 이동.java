import java.util.*;
import java.io.*;

public class Main {
        static int[] dx = new int[]{0, 0, -1, 1};
        static int[] dy = new int[]{-1, 1, 0, 0};
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            int[][] graph = new int[n][n];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++){
                    graph[i][k] = Integer.parseInt(st.nextToken());
                }
            }
            Queue<int[]> q = new LinkedList<>(); // check-1 (Queue로 관리)
            int[][] curr = new int[n][n];
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                q.add(new int[]{r,c});
                curr[r][c] = 1;
            }
            while(t-- > 0){ // check-2 (while 조건문)
                int prevSize = q.size();
                for(int i=0; i<prevSize; i++) {
                    int[] pos = q.poll();
                    int maxNum = 0;
                    int[] maxPos = new int[2];
                    for(int k=0; k<4; k++){
                        int nr = pos[0] + dy[k];
                        int nc = pos[1] + dx[k];
                        if(nr >= 0 && nc >= 0 && nr < n && nc < n){
                            if(graph[nr][nc] > maxNum){
                                maxNum = graph[nr][nc];
                                maxPos = new int[]{nr, nc};
                            }
                        }
                    }
                    curr[maxPos[0]][maxPos[1]]++;
                    curr[pos[0]][pos[1]]--;
                    q.add(new int[]{maxPos[0], maxPos[1]});
                }
                
                // check-3 (한 사이클 돌고 중복 체크)
                int resultingSize = q.size();
                for(int i=0; i<resultingSize; i++){
                    int[] pos = q.poll();
                    if(curr[pos[0]][pos[1]] > 1) curr[pos[0]][pos[1]] = 0;
                    else if (curr[pos[0]][pos[1]] == 1) q.add(pos);
                    }
                }
            System.out.println(q.size());
        }
}
