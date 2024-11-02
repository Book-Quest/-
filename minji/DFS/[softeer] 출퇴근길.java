import java.io.*;
import java.util.*;

public class Main {
  // n = 정점, m = 간선
  // 인접리스트 - DFS로 중간 노드까지 풀로 탐색하면, 최악의 경우 중간노드가 n-2가 될 수 있기 때문에 O(n(n + m))
  // 그러나, 역방향 그래프를 활용하면 중간노드마다 DFS를 수행할 필요가 없기 때문에 4번의 DFS 즉, O(4(n+m)) = O(n+m)의 시간복잡도를 지닌다.
    static int n,m,s,t;
    static ArrayList[] graph, reverseGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        reverseGraph = new ArrayList[n + 1];
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList();
            reverseGraph[i] = new ArrayList();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            if(graph[node1] == null) graph[node1] = new ArrayList();
            if(reverseGraph[node2] == null) reverseGraph[node2] = new ArrayList();
            graph[node1].add(node2);
            reverseGraph[node2].add(node1);
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        Set<Integer> sToT = new HashSet<>();
        Set<Integer> tFromS = new HashSet<>();
        Set<Integer> tToS = new HashSet<>();
        Set<Integer> sFromT = new HashSet<>();
        
        boolean[] visited = new boolean[n + 1];
        visited[t] = true;
        DFS(s, graph, sToT, visited);

        visited = new boolean[n + 1];
        DFS(s, reverseGraph, tFromS, visited);

        visited = new boolean[n + 1];
        visited[s] = true;
        DFS(t, graph, tToS, visited);

        visited = new boolean[n + 1];
        DFS(t, reverseGraph, sFromT, visited);

        sToT.retainAll(tFromS);
        tToS.retainAll(sFromT);
        sToT.retainAll(tToS);

        sToT.removeAll(Set.of(s,t));
        
        System.out.print(sToT.size());
    }

    private static void DFS(int curr, ArrayList<Integer>[] input, Set<Integer> output, boolean[] visited){
        if(visited[curr]){
            return;
        }

        visited[curr] = true;

        for(int i=0; i<input[curr].size(); i++){
            int node = input[curr].get(i);
                output.add(node);
                DFS(node, input, output, visited);
        }
    }
}
