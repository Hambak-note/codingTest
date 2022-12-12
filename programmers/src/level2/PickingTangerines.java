package level2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PickingTangerines {

    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3});
        System.out.println(answer);

    }

    static class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;

            Map<Integer, Integer> map = new HashMap<>();

            for(int t : tangerine){
                map.put(t, map.getOrDefault(t, 0)+1);
            }

            List<Map.Entry<Integer, Integer>> entries =
                    map.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .collect(Collectors.toList());

            for(Map.Entry<Integer, Integer> i : entries){
                if(k <= 0)
                    break;
                answer++;
                k -= i.getValue();
            }


            return answer;
        }
    }
}
