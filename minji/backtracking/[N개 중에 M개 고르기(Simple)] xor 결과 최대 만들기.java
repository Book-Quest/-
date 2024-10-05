import java.util.*;
import java.io.*;

public class Main {
    static int n, m, ans;
    static int[] nums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for(int i=0; i<nums.length; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        getMaxXorResult(0, 0, new ArrayList<>());

        System.out.print(ans);
    }

    private static void getMaxXorResult(int start, int cnt, List<Integer> output){
        if(cnt == m){
            int result = 0;
            for(int num : output) result ^= num;
            ans = Math.max(ans, result);
        }

        for(int i=start; i<n; i++){
            output.add(nums[i]); // check-1 (타겟 숫자가 공차 1인 등차수열이 아닌 주어진 배열 활용)
            getMaxXorResult(i+1, cnt+1, output);
            output.remove(output.size()-1);
        }
    }
}
