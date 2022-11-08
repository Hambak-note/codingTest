package level2;

public class GroupPhoto {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(2, new String[]{"N~F=0", "R~T>2"});
    }


    static class Solution {

        private String[] members = {"A", "C", "F", "J", "M", "N", "R", "T"};
        private boolean[] isVisited;
        private String[] data;
        private int answer;


        public int solution(int n, String[] data) {
            answer = 0;
            isVisited = new boolean[8];
            this.data = data;

            dfs("");
            System.out.println(answer);

            return answer;
        }

        public void dfs(String names){
            if(names.length() == 8){
                if(conditionCheck(names)){
                    answer++;
                }
                return;
            }
            for(int i = 0; i < 8; i++){
                if(!isVisited[i]){
                    isVisited[i] = true;
                    String name = names + members[i];
                    dfs(name);
                    isVisited[i] = false;
                }
            }
        }

        public boolean conditionCheck(String names){
            for(String str : data){
                int position1 = names.indexOf(str.charAt(0));
                int position2 = names.indexOf(str.charAt(2));
                char operator = str.charAt(3);
                int interval = str.charAt(4) - '0';
                if(operator == '='){
                    if(!(Math.abs(position1 - position2) == interval+1)) return false;
                }else if(operator == '>'){
                    if(!(Math.abs(position1 - position2) > interval+1)) return false;
                }else if(operator == '<'){
                    if(!(Math.abs(position1 - position2) < interval+1)) return false;
                }
            }
            return true;
        }
    }
}
