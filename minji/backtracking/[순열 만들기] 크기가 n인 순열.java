import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static List<Integer> output = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        getPermutation(new boolean[n], 0);

        bw.flush(); // check-1 (flush는 버퍼에 저장된 내용을 강제로 출력 스트림에 전달, 즉 write는 데이터를 내부 버퍼에 저장했다가 flush 호출되면 콘솔에 출력)
        bw.close();
        br.close();
    }

    private static void getPermutation(boolean[] visited, int curr) throws IOException {
        if(curr == n){
            for(int i=0; i<output.size(); i++){
                bw.write(output.get(i).toString());
                bw.write(" ");
            }
            bw.newLine();
            return;
        }
        for(int i=1; i<=n; i++){ // check-2 (int i=1; i<=n)
            if(!visited[i-1]) { // check-3 (n개 중에 m개 뽑아 사전순 정렬하기는 조합이지만 '사전순 정렬'이기에 visited 배열로 관리하지 않고, start 변수를 선언하여 초기값만 관리하면 됐음. 그러나 해당 문제는 X)
                visited[i-1] = true;
                output.add(i);
                getPermutation(visited, curr + 1);
                visited[i-1] = false;
                output.remove(output.size() - 1);
            }
        }
    }
}
