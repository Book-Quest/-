import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 상하좌우 우선순위대로 인접 노드 탐색 (BFS로 풀이)
public class Main {
        static class Pair {
        int x,y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;
        Pair pair = new Pair(x, y);
        int[][] graph = new int[n][n];
        for(int i=0; i<graph.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<graph[0].length; k++) {
                graph[i][k] =  Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pair> q = new LinkedList<>();
        Queue<Integer> visited = new LinkedList<>();
        q.add(pair);
        visited.add(graph[pair.y][pair.x]);

        while (!q.isEmpty()){
           Pair curr = q.poll();

            for(int i=0; i<4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(ny >= 0 && nx >= 0 && ny < graph.length && nx < graph[curr.y].length) {
                    if(graph[ny][nx] >= graph[curr.y][curr.x])  {
                        q.add(new Pair(nx, ny));
                        visited.add(graph[ny][nx]);
                        break;
                    }
                }
            }
        }
        while (!visited.isEmpty()) {
            System.out.print(visited.poll());
            if (!visited.isEmpty()) {
                System.out.print(" ");
            }
        }
    }
}
