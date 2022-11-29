package level0;

public class SharePizza {



    public static void main(String[] args) {

    }

    static class Solution {
        private static final int SLICE_OF_PIZZA = 6;

        public int solution(int n) {
            int pizzas = 1;
            while(true){
                int allSlice = pizzas * SLICE_OF_PIZZA;
                if(allSlice % n == 0) return pizzas;
                pizzas++;
            }
        }
    }
}
