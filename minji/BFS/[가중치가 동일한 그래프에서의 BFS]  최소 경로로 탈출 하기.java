import java.util.*;
import java.io.*;

public class Main {
    static int n,m, ans;
    static int[][] grid;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = -1;
        grid = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<m; k++){
                grid[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        findMin();
        
        System.out.print(ans);  
    }
    private static void findMin(){
        Queue<Node> q = new LinkedList<Node>();
        boolean[][] visited = new boolean[n][m];
        q.add(new Node(0,0,0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            if(node.x == m-1 && node.y == n-1){
                ans = node.cost;
            }
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx >= 0 && ny >= 0 && ny < n && nx < m){
                    if(grid[ny][nx] == 1 && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.add(new Node(nx, ny, node.cost+1));
                    }
                }
            }

        }
    }
    private static class Node{
        private int x;
        private int y;
        private int cost;
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
