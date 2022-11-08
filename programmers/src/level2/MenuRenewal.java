package level2;

import java.util.*;

public class MenuRenewal {

    static Map<String, Integer> combinationMap;

    public static void main(String[] args) {
        Solution s= new Solution();
        String[] test1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] testCourse1 = {2, 3, 4};
        ArrayList<String> answer = s.solution(test1, testCourse1);
        System.out.println(answer.toString());


    }

    static class Solution {
        public ArrayList<String> solution(String[] orders, int[] course) {
            ArrayList<String> answer = new ArrayList<>();


            //문자열 오름 차순 정렬
            for(int i = 0; i < orders.length; i++){
                char[] orderChar = orders[i].toCharArray();
                Arrays.sort(orderChar);
                orders[i] = new String(orderChar);
            }

            for(int i = 0; i < course.length; i++){
                combinationMap = new HashMap<>();
                for (int j = 0; j < orders.length; j++) {
                    if(course[i] <= orders[j].length()){
                        makeCombination(orders[j], "",0, course[i]);
                    }
                }

                getMostOrderedMenu(answer);
            }

            Collections.sort(answer);

            return answer;
        }


        public static void makeCombination(String order, String splitOrder, int idx,int n){
            if(splitOrder.length() == n){
                combinationMap.put(splitOrder, combinationMap.getOrDefault(splitOrder, 0)+1);
                return;
            }

            for(int i = idx; i < order.length(); i++){
                splitOrder = splitOrder + order.charAt(i);
                makeCombination(order, splitOrder,i+1, n);
                splitOrder = splitOrder.substring(0, splitOrder.length() - 1);
            }
            return;
        }

        public static void getMostOrderedMenu(ArrayList<String> mostOrderedMenu){
            int max = -1;
            int value;
            for(String key : combinationMap.keySet()){
                value = combinationMap.get(key);
                if(max < value) max = value;
            }

            if(max < 2) return;

            for(String key : combinationMap.keySet()){
                value = combinationMap.get(key);
                if(value == max) mostOrderedMenu.add(key);
            }
            return;
        }
    }
}
