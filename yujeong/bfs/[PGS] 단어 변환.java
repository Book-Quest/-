// begin문자열 -> target문자열로 변환하는 가장 짧은 변환 과정의 단계 수
// 1번에 1개만 변환 가능 + words에 있는 단어로만 변환 가능
// 방문할수 있는 단어를 어떻게 체크? => 
import java.util.*;

class Solution {
    public static boolean[] visited;
    public static int n;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        n = words.length;
        visited = new boolean[n];
        answer = bfs(begin,target,words);
        return answer;
    }
    
    private int bfs(String begin, String target, String[] words) {
        Queue<int[]> queue = new LinkedList<>();
        // 첫번째 단어
        for (int i=0; i<n; i++) {
            if(findNext(begin, words[i])) {
                if (words[i].equals(target))
                        return 1;
                queue.offer(new int[] {1,i});
                visited[i] = true;
            }
        }
        // 이후 단어
        while(!queue.isEmpty()) {
            int[] x = queue.poll();
            for (int i=0; i<n; i++) {
                if (!visited[i] && findNext(words[x[1]], words[i])) {
                    if (words[i].equals(target))
                        return x[0]+1;
                    queue.offer(new int[] {x[0]+1, i});
                    visited[i] = true;
                }
            }
        }
        return 0;
    }    
    
    /* 이동가능한 문자열인지 확인 */
    private boolean findNext(String cur, String next) {
        int same = 0;
        // 같은 문자 개수 count
        for (int i=0; i<cur.length(); i++) {
            if (cur.charAt(i)==next.charAt(i))
                same += 1;
        }
        // 이동 가능 유무 반환
        return same == cur.length()-1;
    }
}
