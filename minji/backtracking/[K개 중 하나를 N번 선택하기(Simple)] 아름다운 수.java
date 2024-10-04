import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [중복순열] 1이상 4이하의 숫자로만 이루어져 있으면서, 정확히 해당 숫자만큼 연달아 같은 숫자가 나오는 숫자 개수 구하기
public class Main {
    static int n, ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        ans = 0;

        getPermutation(0, new int[n]);

        System.out.println(ans);
        br.close();
    }

    private static void getPermutation(int cnt, int[] output){
        if(cnt == n){
            boolean satisfied = true;
            for(int i=0; i<output.length; i+= output[i]){ // check-1
                if (i + output[i] - 1 >= n) { // check-2
                    satisfied = false;
                    break; // check-3
                }
                for(int j=i; j<i+output[i]; j++){ // check-4
                    if(output[j] != output[i]) satisfied = false;
                }
            }
            if(satisfied) ans++;
            return;
        }
        for(int i=1; i<=4; i++){
            output[cnt] = i;
            getPermutation(cnt + 1, output);
            output[cnt] = 0;
        }
    }
}
