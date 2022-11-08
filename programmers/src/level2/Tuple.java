package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Tuple {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer;

        answer = s.solution("{{20,111},{111}}");
        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i] + ",");
        }
        System.out.println();
        System.out.println(answer.toString());

    }

    static class Solution {
        public int[] solution(String s) {
            int[] answer;

            ArrayList<Integer> store = new ArrayList<>();

            //주어진 문자열 가장 앞의 {{ 제거
            s = s.substring(2, s.length());
            //주어진 문자열 가장 뒤의 }} 제거
            s = s.substring(0, s.length()-2);
            //튜플의 요소들을 구분할 수 있는 구분자로 바꾸어준다.
            s = s.replace("},{", "-");
            //구분자를 기준으로 문자열 배열로 나누어 저장한다.
            String[] strArr = s.split("-");

            //저장된 문자열을 문자열의 길이에 따라 정렬
            Arrays.sort(strArr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {

                    return Integer.compare(o1.length(), o2.length());
                }
            });

            for(String x : strArr){
                String[] temp = x.split(",");

                for(int i  = 0; i < temp.length; i++){
                    int n = Integer.parseInt(temp[i]);

                    if(!store.contains(n)) store.add(n);
                }
            }

            answer = new int[store.size()];
            int index = 0;
            for(int temp : store){
                answer[index++] = temp;
            }

            return answer;
        }
    }
}
