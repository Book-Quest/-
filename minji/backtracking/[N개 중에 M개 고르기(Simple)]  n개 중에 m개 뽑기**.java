import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        getCombination(1, 0, new ArrayList<>());
    }
   private static void getCombination(int start, int cnt, List<Integer> output){
       if(cnt == m){
           for(int num : output) System.out.print(num + " ");
           System.out.println();
           return;
       }

       for(int i=start; i<=n; i++){
           output.add(i);
           getCombination(i + 1, cnt + 1, output); // check-1 (backtracking 시 i+1로 넣어야 중복 방지)
           output.remove(output.size() - 1);
       }
   }
}
