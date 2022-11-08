package level2;

import java.util.LinkedList;

public class Cache {

    private static final int CACHE_HIT = 1;
    private static final int CACHE_MISS = 5;

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] inputStr = {"Jeju", "Pangyo", "NewYork", "newyork"};

        int answer = s.solution(2, inputStr);
        System.out.println("answer = " + answer);

    }

    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            //cacheSize가 0인 경우
            if(cacheSize == 0){
                return cities.length*5;
            }

            LinkedList<String> cacheList = new LinkedList<>();

            for(int i = 0; i < cities.length; i++){

                String tempStr = cities[i].toLowerCase();

                if(cacheList.contains(tempStr)){
                    answer += CACHE_HIT;
                    cacheList.remove(tempStr);
                    cacheList.addLast(tempStr);
                    continue;
                }

                if(cacheList.size() == cacheSize){
                    answer += CACHE_MISS;
                    cacheList.remove(0);
                    cacheList.addLast(tempStr);
                }else{
                    answer += CACHE_MISS;
                    cacheList.addLast(tempStr);
                }
            }

            return answer;
        }
    }
}
