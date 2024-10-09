import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,m, ans;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        ans = 0; // check-1 (정점 1은 제외하지만, 초기값은 0)

        for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[key].add(value);
            graph[value].add(key);
        }
        DFS(1);

        System.out.print(ans > 0 ? ans - 1 : ans); // check-1 (정점 1은 제외하지만, 초기값은 0)
    }

    private static void DFS(int node){
        for(int i=0; i<graph[node].size(); i++) {
            if(!visited[graph[node].get(i)]){
                ans++;
                visited[graph[node].get(i)] = true;
                DFS(graph[node].get(i));
            }
        }
    }
}
