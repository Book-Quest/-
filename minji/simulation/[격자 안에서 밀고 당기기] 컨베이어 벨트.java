import java.util.*;
import java.io.*;

// 컨베이어 벨트가 시계 방향으로 한 칸씩 회전할 때, t초 후의 컨베이어 벨트 상태를 출력하라. (컨베이어 벨트는 위아래 두 줄, 각 줄에 n개의 숫자로 구성)
public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int remainder = t % (2 * n);
        int[][] move = new int[2][n];
        for (int i = 0; i < move.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < move[0].length; k++) {
                int targetRow = i, targetCol = k + remainder;
                while (targetCol > move[0].length - 1) {
                    targetRow = targetRow == 0 ? 1 : 0;
                    targetCol = targetCol - n;
                }
                move[targetRow][targetCol] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < move.length; i++) {
            for (int j = 0; j < move[0].length; j++) {
                System.out.print(move[i][j] + " ");
            }
            System.out.println();
        }
    }
}
