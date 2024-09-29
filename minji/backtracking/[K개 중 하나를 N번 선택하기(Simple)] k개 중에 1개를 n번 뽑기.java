import java.util.*;
import java.io.*;

public class Main {
    static int k, n;
    static List<Integer> selectedNums = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        k = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        getDuplicatePermutations(0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void getDuplicatePermutations(int curr) throws IOException {
        if (curr == n) {
            for (int i = 0; i < selectedNums.size(); i++) {
                bw.write(selectedNums.get(i).toString());
                bw.write(" ");
            }
            bw.newLine();
            return;
        }
        for (int i = 0; i < k; i++) {
            selectedNums.add(i + 1);
            getDuplicatePermutations(curr + 1);
            selectedNums.remove(selectedNums.size() - 1);
        }
    }
}
