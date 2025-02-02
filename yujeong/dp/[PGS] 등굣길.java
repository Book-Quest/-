// (1,1)->(m,n) right down
import java.util.*;
class Solution {
    public static int[][] shortpath;
    public int solution(int m, int n, int[][] puddles) {
        shortpath = new int[m][n];
        // puddle 위치를 -1로 설정
        for(int[] p:puddles) {
            shortpath[p[0]-1][p[1]-1] = -1;
        }
        
        // shortpath 초기값 설정
        for (int i=1; i<m; i++) {
            if(shortpath[i][0]==-1)
                break;
            shortpath[i][0] =1;
        }
        for (int i=1; i<n; i++) {
            if(shortpath[0][i]==-1)
                break;
            shortpath[0][i] =1;
        }
        
        // 최단 거리 구하기
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if(shortpath[i][j] == -1)
                    continue;
                shortpath[i][j] = (Math.max(0,shortpath[i-1][j]) + Math.max(0,shortpath[i][j-1]))%1000000007;
            }
        }
        
        return shortpath[m-1][n-1];
    }
}
