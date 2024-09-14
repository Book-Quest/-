import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 총 2n개의 수열(n개 열, n개 행) 중 연속하여 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열의 개수를 출력하라.
public class 행복한 수열의 개수 {
    public static void main(String[] args) throws IOException {
        int ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(graph[0].length == 1){
            if(graph[0].length == M) ans++;
        }
        if(graph.length == 1){
            if(graph.length == M) ans++;
        }
        if (graph[0].length > 1 && graph.length > 1) {
            for(int i=0; i<N; i++){
                int rowM = 1, colM = 1;
                boolean checkedRow = false, checkedCol = false;
                for(int j=1; j<N; j++) {
                    if (!checkedCol) {
                        if (graph[i][j - 1] == graph[i][j]) colM++;
                        else colM = 1;

                        if (colM >= M) {
                            ans++;
                            checkedCol = true;
                        }
                    }
                    if (!checkedRow) {
                        if (graph[j - 1][i] == graph[j][i]) rowM++;
                        else rowM = 1;

                        if (rowM >= M) {
                            ans++;
                            checkedRow = true;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
