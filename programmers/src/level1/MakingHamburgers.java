package level1;

import java.util.Stack;

public class MakingHamburgers {

    public static void main(String[] args) {

    }

    /**
     * 빵 - 야채 - 고기 - 빵
     * 1 - 2 - 3 - 4
     *
     */

    static class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;

            Stack<Integer> burgerStack = new Stack<>();

            for (int material : ingredient) {
                burgerStack.push(material);

                if(burgerStack.size() >= 4){
                    int bottomBread = burgerStack.elementAt(burgerStack.size() - 4);
                    int vegetable = burgerStack.elementAt(burgerStack.size() - 3);
                    int meat = burgerStack.elementAt(burgerStack.size() - 2);
                    int topBread = burgerStack.elementAt(burgerStack.size() - 1);

                    if(bottomBread == 1 && vegetable == 2 && meat == 3 && topBread == 1){
                        burgerStack.pop();
                        burgerStack.pop();
                        burgerStack.pop();
                        burgerStack.pop();
                        answer += 1;
                    }
                }
            }
            return answer;
        }
    }
}
