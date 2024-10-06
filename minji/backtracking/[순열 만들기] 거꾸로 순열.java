import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static List<Integer> output = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());

        getPermutationReverse(new boolean[n]);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void getPermutationReverse(boolean[] visited) throws IOException {
        if(output.size() == n){
            for(int i=0; i<output.size(); i++) {
                bw.write(output.get(i).toString());
                bw.write(" ");
            }
            bw.newLine();
            return;
        }
        for(int i=n; i>=1; i--){ // check
            if(!visited[i - 1]){
                visited[i - 1] = true;
                output.add(i);
                getPermutationReverse(visited);
                visited[i - 1] = false;
                output.remove(output.size()-1);
            }
        }
    }
}
