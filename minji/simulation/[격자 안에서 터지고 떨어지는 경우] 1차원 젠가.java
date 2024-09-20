import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2번에 걸쳐 특정 구간의 블럭들을 빼는 작업 후, 남은 블록의 개수와 남은 블록 숫자 출력하라.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] graph = new int[N];
        for(int i=0; i<graph.length; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }
        int[][] remove = new int[2][2];
        for(int i=0; i<remove.length; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            remove[i] = new int[]{start, end};
        }
        int totalRemove = 0;
        for(int i=0; i<remove.length; i++){
            int loop = remove[i][1] - remove[i][0] + 1;
            totalRemove += loop;
            int cnt = 0;
            for(int k=0; k<graph.length; k++) {
                if (graph[k] != 0) {
                    cnt++;
                    if (cnt >= remove[i][0] && cnt <= remove[i][1]) {
                        graph[k] = 0;
                    }
                }
            }
        }
        System.out.println(Math.max(graph.length - totalRemove, 0));
        for (int i=0; i<graph.length; i++){
            if(graph[i] != 0) System.out.println(graph[i]);
        }
    }        

}
