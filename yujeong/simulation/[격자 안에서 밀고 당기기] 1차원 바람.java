// 특정 행의 모든 원소를 왼쪽 혹은 오른쪽으로 한칸 씩 밀기
// 밀리기 시작한 행을 기준으로 위 아래 방향으로 전파
    // 현재 행, 나아가는 행 비교 -> 1개라도 같은 열에 같은 숫자가 적혀있다면 전파
    // 전파 : 나아가려는 행의 숫자들을 원래행과 반대 방향으로 한칸씩 밀기
// q개의 바람을 거친 후 건물의 상태를 출력
import java.util.*;
import java.io.*;
public class Main {
    public static int[][] graph;
    public static int n,m;

    private static void windPush(int x, int d) {
        int[] newRow = new int[m];
        boolean up=false, down=false;
        int ud=d,dd=d;
        // i행의 바람 불기 + 위 아래 비교
        for (int j=0; j<m; j++) {
            newRow[j] = graph[x][(m+j+d)%m];
            if (x>0 && graph[x-1][j]==newRow[j])
                up = true;
            if (x<n-1 && graph[x+1][j]==newRow[j])
                down = true;
        }
        graph[x] = Arrays.copyOf(newRow,m);
        // 위
        for (int i=x-1; i>=0; i--) {
            if (!up)
                break;
            ud *= -1;
            up = false;
            for (int j=0; j<m; j++) {
                newRow[j] = graph[i][(m+j+ud)%m];
                if (i>0 && graph[i-1][j]==newRow[j])
                    up = true;
            }
            graph[i] = Arrays.copyOf(newRow,m);
        }
        // 아래
        for (int i=x+1; i<n; i++) {
            if(!down)
                break;
            dd *= -1;
            down = false;
            for (int j=0; j<m; j++) {
                newRow[j] = graph[i][(m+j+dd)%m];
                if (i<n-1 && graph[i+1][j]==newRow[j])
                    down = true;
            }
            graph[i] = Arrays.copyOf(newRow,m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }
        
        // 바람
        for (int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int dir = (st.nextToken().equals("L") ? -1 : 1);
            windPush(x,dir);
        }

        // 출력
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
}
