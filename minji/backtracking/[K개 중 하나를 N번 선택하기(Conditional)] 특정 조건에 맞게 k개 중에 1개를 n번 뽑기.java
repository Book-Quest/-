import java.util.*;
import java.io.*;

// 중복 순열(단, 3 연속 중복 불가)
public class Main {
     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,k;
    static List<Integer> output = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String[] intput = br.readLine().split(" ");
        k = Integer.parseInt(intput[0]);
        n = Integer.parseInt(intput[1]);

        dupliacatePermutation();

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dupliacatePermutation() throws IOException {
        if(output.size() == n){
            for(int i=0; i<output.size(); i++){
                bw.write(output.get(i).toString());
                bw.write(" ");
            }
            bw.newLine();
            return;
        }

        for(int i=1; i<=k; i++){
            if(output.size() >= 2 && output.get(output.size()-1) == i && output.get(output.size() - 2) == i) continue;
                output.add(i);
                dupliacatePermutation();
                output.remove(output.size() - 1);
        }
    }
}
