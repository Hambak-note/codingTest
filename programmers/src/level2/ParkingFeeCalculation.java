package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFeeCalculation {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        s.solution(fees, records);
    }

    static class Solution {
        public int[] solution(int[] fees, String[] records) {
            int[] answer;

            Map<String, Integer> carMap =  new HashMap<>();
            Map<String, Integer> timeMap = new HashMap<>();


            for(String record : records){
                String[] temp = record.split(" ");

                if(temp[2].equals("IN")){
                    String carNumber = temp[1];
                    String[] time = temp[0].split(":");
                    int inTime = Integer.parseInt(time[0])*60 +Integer.parseInt(time[1]);

                    carMap.put(carNumber, inTime);
                }

                if(temp[2].equals("OUT")){
                    String carNumber = temp[1];
                    String[] time = temp[0].split(":");
                    int outTime = Integer.parseInt(time[0])*60 +Integer.parseInt(time[1]);

                    int parkingTime = outTime - carMap.get(carNumber);
                    timeMap.put(carNumber, timeMap.getOrDefault(carNumber, 0)+parkingTime);
                    carMap.remove(carNumber);
                }
            }

            int outTime = 1439;
            for(String carNumber : carMap.keySet()){
                int parkingTime = outTime - carMap.get(carNumber);
                timeMap.put(carNumber, timeMap.getOrDefault(carNumber, 0)+parkingTime);
            }

            List<String> keyList = new ArrayList<>(timeMap.keySet());
            keyList.sort((s1, s2) -> s1.compareTo(s2));
            answer = new int[keyList.size()];
            int index = 0;
            for(String key : keyList){
                if(timeMap.get(key) <= fees[0]){
                    answer[index++] = fees[1];
                    continue;
                }
                answer[index++] = fees[1] + (int) (Math.ceil((timeMap.get(key) - fees[0])/(double)fees[2])) * fees[3];
            }

            return answer;
        }

    }


}
