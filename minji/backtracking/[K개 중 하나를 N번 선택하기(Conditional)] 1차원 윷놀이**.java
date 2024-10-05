import java.util.*;
import java.io.*;

// n개의 거리 값 중에 최대 k 선택하여 m 이상 만들어내는 [조합]
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,m,k,ans;
    static int[] distances;
    public static void main(String[] args) throws IOException {
        String[] output = br.readLine().split(" ");
        n = Integer.parseInt(output[0]);
        m = Integer.parseInt(output[1]);
        k = Integer.parseInt(output[2]);
        ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        distances = new int[n];
        for(int i=0; i<distances.length; i++){
            distances[i] = Integer.parseInt(st.nextToken());
        }

        pickMaxKFromN(0, new int[k]);

        System.out.print(ans);
    }
    private static void pickMaxKFromN(int curr, int[] score){
        if(curr == n){
            int sum = 0;
            for(int s : score){
                if(s + 1 >= m ) sum++; // check-1 (초기 score는 모두 1로 셋팅)
            }
            ans = Math.max(ans, sum);
            return;
        }

        for(int i=0; i<k; i++){ // check-2 (i < k)
                score[i] += distances[curr];
                pickMaxKFromN(curr + 1, score);
                score[i] -= distances[curr];
        }
    }
}
