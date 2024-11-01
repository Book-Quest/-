import java.io.*;
import java.util.*;

public class Main {
        static int[] dx = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        static int[] dy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        static int r1, c1, r2, c2, n, ans;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ans = -1;
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken()) - 1;
            c1 = Integer.parseInt(st.nextToken()) - 1;
            r2 = Integer.parseInt(st.nextToken()) - 1;
            c2 = Integer.parseInt(st.nextToken()) - 1;

            BFS();
            System.out.print(ans);
        }
        private static void BFS(){
            Queue<Pair> q = new LinkedList<Pair>();
            boolean[][] visited = new boolean[n][n];
            q.add(new Pair(c1, r1, 0));
            visited[r1][c1] = true;

            while(!q.isEmpty()){
                Pair pair = q.poll();

                if(pair.x == c2 && pair.y == r2) ans = pair.cnt; // check-1 (Math.min() 필요 X)
            
                for(int i=0; i<8; i++){
                    int nx = pair.x + dx[i];
                    int ny = pair.y + dy[i];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                        if(!visited[ny][nx]){
                            visited[ny][nx] = true;
                            q.add(new Pair(nx, ny, pair.cnt+1));
                        }
                    }
                }
            }
        }
        static class Pair {
            int x;
            int y;
            int cnt;
            public Pair(int x, int y, int cnt){
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }
}
