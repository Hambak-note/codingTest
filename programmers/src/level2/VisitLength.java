package level2;

import java.util.ArrayList;
import java.util.List;

public class VisitLength {

    public static void main(String[] args) {
        Solution s = new Solution();
        String dirs = "LULLLLLLU";
        int answer = s.solution(dirs);
        System.out.println("answer = " + answer);
    }

    static class Solution {
        public int solution(String dirs) {
            int answer = 0;

            int currentX = 0;
            int currentY = 0;
            List<String> visitList = new ArrayList<String>();

            char[] dirsArr = dirs.toCharArray();
            for (char order : dirsArr) {

                int previousX = currentX;
                int previousY = currentY;


                if(order == 'U' && currentY < 5){
                    currentY += 1;
                } else if(order == 'D'&& currentY > -5){
                    currentY -= 1;
                } else if(order == 'R' && currentX < 5){
                    currentX += 1;
                } else if(order == 'L' && currentX > -5){
                    currentX -= 1;
                }

                String fromTo = Integer.toString(previousX);
                fromTo += Integer.toString(previousY);
                fromTo += Integer.toString(currentX);
                fromTo += Integer.toString(currentY);

                String toFrom = Integer.toString(currentX);
                toFrom += Integer.toString(currentY);
                toFrom += Integer.toString(previousX);
                toFrom += Integer.toString(previousY);

                if(!visitList.contains(fromTo) && !visitList.contains(toFrom) && !fromTo.equals(toFrom)){
                    visitList.add(fromTo);
                    visitList.add(toFrom);
                }
            }

            answer = visitList.size() / 2;

            return answer;
        }
    }
}
