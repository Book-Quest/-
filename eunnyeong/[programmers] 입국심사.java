import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        int size = times.length;
        long l = 0, r = (long)n * times[size - 1];
    
        while(l <= r) {
            long mid = l + (r - l) / 2;
            
            long cnt = 0;
            for (int i = 0; i < size; i++) {
                cnt += mid / times[i];
                if (cnt >= n) break;
            }
            
            if (cnt < n)
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return l;
    }
}
